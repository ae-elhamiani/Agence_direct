package com.eai.otpservice.service;

import com.eai.otpservice.dto.OtpPhoneRequest;

public interface OtpService {

    void generateOtpPhone(OtpPhoneRequest otpPhoneRequest);
}
