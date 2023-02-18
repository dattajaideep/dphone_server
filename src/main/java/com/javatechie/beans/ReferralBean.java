package com.javatechie.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReferralBean {
    private int Id;
    private int referrerId;
    private String referrerCode;
    private String referralName;
    private String referralEmail;
    private String referralPhoneNumber;
    private Date referredDate;
}
