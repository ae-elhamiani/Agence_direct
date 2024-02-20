package com.eai.otpservice.repository;


import com.eai.otpservice.model.OtpPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpPhoneRepository extends JpaRepository<OtpPhone, Long> {
    // Additional query methods if needed
}
