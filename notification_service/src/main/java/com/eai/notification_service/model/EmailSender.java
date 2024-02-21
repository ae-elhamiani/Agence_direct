package com.eai.notification_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailSender {
    private String code_otp_email;
    private String email;
    private final String subject = "Agence Directe – Code d’accès";
    private final String text = "Madame, Monsieur, Nous avons le plaisir de vous faire " +
            "parvenir votre code de connexion à votre espace personnel Agence Directe : ";

}
