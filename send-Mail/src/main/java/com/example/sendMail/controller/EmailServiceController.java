package com.example.sendMail.controller;

import com.example.sendMail.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/mail")
public class EmailServiceController {
    private final EmailService emailService;

    public EmailServiceController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String sendMail(@RequestParam(value = "file",required = false)MultipartFile[] file,String to,String [] cc,String subject,String body ){
        return emailService.sendMail(file, to, cc, subject, body);
    }
}
