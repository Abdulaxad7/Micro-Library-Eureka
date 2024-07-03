package com.library.librarypurchaseservice.model;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.scheduling.annotation.Async;

import java.util.Random;

@Document("user-data")
@Data
@Async
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    public UserData() {}
    private String Firstname;
    private String Lastname;
    private String Email;
    private String Address;
    private String Address2;
    private String Country;
    private String State;
    private String Zip;
    private String CardHolder;
    private String CardNumber;
    private String CardExpiry;
    private String CardCVV;
    private String CardBalance;

    public void setCardBalance(String cardBalance) {
        Random random = new Random();
        this.CardBalance = random.nextInt(1000)+"";;


    }
}
