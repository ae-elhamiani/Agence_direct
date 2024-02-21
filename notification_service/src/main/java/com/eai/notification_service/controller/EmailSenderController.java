package com.eai.notification_service.controller;

import com.eai.notification_service.dto.EmailSenderRequest;
import com.eai.notification_service.model.EmailSender;
import com.eai.notification_service.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody EmailSenderRequest emailSenderRequest){
        EmailSender emailSender = new EmailSender(emailSenderRequest.getCode_otp_email(), emailSenderRequest.getEmail());
        emailSenderService.sendEmail(emailSender.getEmail(), emailSender.getSubject(), emailSender.getText()+emailSender.getCode_otp_email());
    }
}
