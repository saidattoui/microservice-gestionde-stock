<?php

namespace App\Entity;

use App\Repository\LivraisonRepository;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: LivraisonRepository::class)]
class Livraison
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;
    #[ORM\Column]
    private ?string $nomLivreur = null;

    #[ORM\Column(type: 'datetime')]
    private ?\DateTimeInterface $dateLivraison = null;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNomLivreur(): ?string
    {
        return $this->nomLivreur;
    }

    public function setNomLivreur(?string $nomLivreur): self
    {
        $this->nomLivreur = $nomLivreur;

        return $this;
    }

    public function getDateLivraison(): ?\DateTimeInterface
    {
        return $this->dateLivraison;
    }

    public function setDateLivraison(?\DateTimeInterface $dateLivraison): self
    {
        $this->dateLivraison = $dateLivraison;

        return $this;
    }

}
