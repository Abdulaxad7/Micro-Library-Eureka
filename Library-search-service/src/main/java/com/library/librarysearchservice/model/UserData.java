package com.library.librarysearchservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "user-cards")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    private String cardHolder;
    private String cardNumber;
    private String cardExpiry;
    private String cardCVV;
    private String cardType;

}
