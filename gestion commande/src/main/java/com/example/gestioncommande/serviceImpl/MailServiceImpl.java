package com.example.gestioncommande.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

////import javax.mail.internet.MimeMessage;

//@Service
//public class MailServiceImpl {


  //  @Autowired
   // private JavaMailSender mailSender;

    //@Autowired
    //private TemplateEngine templateEngine;

    //public void sendMail(String to,String Subject,String title,String message) throws MessagingException {
      //  MimeMessage mimeMessage = mailSender.createMimeMessage();
        //MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //helper.setFrom("arwa.bougattaya@esprit.tn");
       // helper.setTo(to);
        //helper.setSubject(Subject);
        //Context context=new Context();
        //context.setVariable("title",title);
        //context.setVariable("message",message);
        //String emailContent= templateEngine.process("templateEmail",context);
        //helper.setText(emailContent,true);
        //mailSender.send(mimeMessage);
   // }


//}
