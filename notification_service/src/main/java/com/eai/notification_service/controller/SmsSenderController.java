package com.eai.notification_service.controller;

import com.eai.notification_service.dto.EmailSenderRequest;
import com.eai.notification_service.dto.SmsSenderRequest;
import com.eai.notification_service.model.EmailSender;
import com.eai.notification_service.service.SmsSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class SmsSenderController {

    private final SmsSenderService smsSenderService;



    @PostMapping("/sendSms")
    public void sendSms(@RequestBody SmsSenderRequest smsSenderRequest) {
        smsSenderService.sendSms(smsSenderRequest);
    }
}
