package com.javatechie.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {
    private int id;
    private String name;
    private String email;
    private String password;
    private String roles;
    private int points;
    private String referalCode;
}
