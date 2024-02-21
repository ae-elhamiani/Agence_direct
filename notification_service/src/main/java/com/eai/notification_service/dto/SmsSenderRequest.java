package com.eai.notification_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsSenderRequest {
    private Integer code_otp_phone;
    private String indicatif_tel;
    private String num_tel;
}
