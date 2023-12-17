<?php
namespace App\Controller;
use App\Entity\Livraison;
use App\Form\LivraisonType;
use App\Repository\LivraisonRepository;

use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Knp\Component\Pager\PaginatorInterface;
use Dompdf\Dompdf;
use Dompdf\Options;
use Symfony\Component\HttpFoundation\JsonResponse;




class LivraisonController extends AbstractController
{
    #[Route('/livraisons', name: 'livraison_index')]
    public function index(Request $request, LivraisonRepository $livraisonRepository, PaginatorInterface $paginator): Response
    {
        $pagination = $paginator->paginate(
            $livraisonRepository->findAll(),
            $request->query->getInt('page', 1), // Numéro de page
            4 // Nombre d'éléments par page
        );

        return $this->render('livraison/index.html.twig', [
            'livraisons' => $pagination,
        ]);
    }


    #[Route('/livraison/{id}', name: 'livraison_show')]
    public function show(int $id, LivraisonRepository $livraisonRepository): Response
    {
        $livraison = $livraisonRepository->find($id);

        if (!$livraison) {
            throw $this->createNotFoundException('Livraison not found');
        }

        return $this->render('livraison/show.html.twig', [
            'livraison' => $livraison,
        ]);
    }

    #[Route('/livraison/new', name: 'livraison_new')]
    public function new(Request $request): Response
    {
        $livraison = new Livraison();
        $form = $this->createForm(LivraisonType::class, $livraison);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($livraison);
            $entityManager->flush();

            return $this->redirectToRoute('livraison_index');
        }

        return $this->render('livraison/new.html.twig', [
            'livraison' => $livraison,
            'form' => $form->createView(),
        ]);
    }

    #[Route('/livraison/pdf', name: 'livraison_pdf')]
    public function generatePdf(Request $request, LivraisonRepository $livraisonRepository): Response
    {
        // Fetch all Livraison entities
        $livraisons = $livraisonRepository->findAll();

        // Create an instance of Dompdf
        $options = new Options();
        $options->set('isHtml5ParserEnabled', true);
        $options->set('isPhpEnabled', true);
        $dompdf = new Dompdf($options);

        // Generate HTML content for the PDF
        $html = $this->renderView('livraison/pdf_template.html.twig', ['livraisons' => $livraisons]);

        // Load HTML to Dompdf
        $dompdf->loadHtml($html);

        // Set paper size
        $dompdf->setPaper('A4', 'portrait');

        // Render PDF (first step: save it to a variable)
        $dompdf->render();

        // Get the generated PDF as a string
        $output = $dompdf->output();

        // Send the generated PDF as a response
        $response = new Response($output);
        $response->headers->set('Content-Type', 'application/pdf');
        $response->headers->set('Content-Disposition', 'inline; filename="livraisons.pdf"');

        return $response;
    }



    #[Route('/livraison/statistics', name: 'livraison_statistics')]
    public function statistics(LivraisonRepository $livraisonRepository): Response
    {
        $statistics = $livraisonRepository->countDeliveriesPerMonth();

        return $this->render('livraison/statistics.html.twig', [
            'statistiques' => $statistics,
        ]);
    }
}
