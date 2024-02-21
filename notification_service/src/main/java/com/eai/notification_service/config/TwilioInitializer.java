package com.eai.notification_service.config;

import com.twilio.Twilio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class TwilioInitializer {
    private final TwilioConfiguration twilioConfiguration;

    public TwilioInitializer(TwilioConfiguration twilioConfiguration){
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken()
        );
        log.info("Twilio initialized ... with account sid {} ", twilioConfiguration.getAccountSid());
    }
}
