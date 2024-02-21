package com.eai.notification_service.service;

import com.eai.notification_service.config.TwilioConfiguration;
import com.eai.notification_service.dto.SmsSenderRequest;
import com.eai.notification_service.model.SmsSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("twilio")
@RequiredArgsConstructor
@Slf4j
public class SmsSenderService {

    private final TwilioConfiguration twilioConfiguration;

    public void sendSms(SmsSenderRequest smsSenderRequest){
        String phoneNumber = smsSenderRequest.getIndicatif_tel()+smsSenderRequest.getNum_tel();
        if (isPhoneNumberValid(smsSenderRequest.getNum_tel()) && isIndicatifTelValid(smsSenderRequest.getIndicatif_tel())) {
            PhoneNumber to = new PhoneNumber(phoneNumber);
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            SmsSender smsSender = new SmsSender(smsSenderRequest.getCode_otp_phone(), smsSenderRequest.getIndicatif_tel(), smsSenderRequest.getNum_tel());

            String message = smsSender.getText() + smsSender.getCode_otp_phone();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            log.info("Send sms {}", smsSenderRequest);
        } else {
            throw new IllegalArgumentException(
                    "Phone number [" + phoneNumber + "] is not a valid number"
            );
        }

    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        // Vérifie si la longueur du numéro de téléphone est de 9 chiffres
        if (phoneNumber.length() != 9) {
            return false;
        }

        // Vérifie si chaque caractère du numéro de téléphone est un chiffre
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isIndicatifTelValid(String indicatifTel) {
        if (!indicatifTel.startsWith("+") || indicatifTel.length() < 2) {
            return false;
        }
        for (int i = 1; i < indicatifTel.length(); i++) {
            if (!Character.isDigit(indicatifTel.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
