package com.eai.notification_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsSender {
    private Integer code_otp_phone;
    private String indicatif_tel;
    private String num_tel;
    private final String text = "Agence Directe. /n"+
            "Ouverture de compte en ligne Code de confirmation: ";

}
