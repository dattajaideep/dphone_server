package com.javatechie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReferralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "referrer_id")
    private int referrerId;
    @Column(name = "referrer_code")
    private String referrerCode;
    @Column(name = "referralName")
    private String referralName;
    @Column(name = "referralEmail")
    private String referralEmail;
    @Column(name = "referralPhoneNumber")
    private String referralPhoneNumber;
    @Column(name = "referredDate")
    @Temporal(TemporalType.DATE)
    private Date referredDate;
}
