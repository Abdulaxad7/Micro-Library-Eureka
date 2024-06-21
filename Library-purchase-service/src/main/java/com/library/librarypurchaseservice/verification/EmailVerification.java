package com.library.librarypurchaseservice.verification;

import com.library.librarypurchaseservice.model.Books;
import com.library.librarypurchaseservice.model.UserData;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@Service
@Data
public class EmailVerification {
    private String pass;
    @Autowired
    private JavaMailSender sendmail;

    private SimpleMailMessage message=new SimpleMailMessage();

    @Async
    public void SendEmail(UserData data){
        pass=UUID.randomUUID().toString();
        message.setTo(data.getEmail());
        message.setSubject("Email Verification");
        message.setText("Your Email Verification Code is:  \n"+pass+"\n"+"Do not share this code with anyone");

        sendmail.send(message);
    }
    public boolean CheckEmail(String password){
        return pass.equals(password);
    }
    public void reminder(UserData data,Books book){
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        message.setTo(data.getEmail());
        message.setSubject("Thank You for Your Purchase! 📚");
        message.setText("Hi ,\n" +data.getFirstname()+" "+data.getLastname()+
                "\n" +
                "We hope this email finds you well!\n" +
                "\n" +
                "Thank you for purchasing "+book+" from Library Inc. We truly appreciate your support and are delighted that you’ve chosen our book. We’re confident that you’ll enjoy reading it.\n" +
                "\n" +
                "Your Purchase Details:\n" +
                "Order Number: " +(int)(Math.random()*100000)+"\n"+
                "Purchase Date: " +currentDateTime.format(formatter)+"\n"+
                "Shipping Method: trough ship (if applicable)\n" +
                "If you have any questions or need further assistance regarding your order, please don't hesitate to reach out to us. We’re here to help!\n" +
                "\n");
        sendmail.send(message);
    }

}






