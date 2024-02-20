package com.eai.otpservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "otp_phone")
public class OtpPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "code")
    private String code;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OtpStatus status;

    // Constructors, getters, setters, etc.
}
