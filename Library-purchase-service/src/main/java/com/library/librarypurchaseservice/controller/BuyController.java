package com.library.librarypurchaseservice.controller;

import com.library.librarypurchaseservice.model.Books;
import com.library.librarypurchaseservice.model.UserData;
import com.library.librarypurchaseservice.repository.UserRepo;
import com.library.librarypurchaseservice.verification.EmailVerification;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Controller
public class BuyController {
    @Autowired
    private UserRepo repo;
    @Autowired
    private EmailVerification email;
    public UserData ema;


    @RequestMapping(value = "/purchases")
    public String buyBook(@ModelAttribute("book") Books book, @ModelAttribute("user")UserData data, Model model){
        ema=data;
        model.addAttribute("user", ema);
        repo.save(data);
        email.SendEmail(data);
        return "emailCheck";
    }

    @RequestMapping(value = "/check")
    public String check(@RequestParam("password") String pass, HttpServletResponse response) throws IOException {
        if( email.CheckEmail(pass)){
            email.reminder(ema,new Books());
            return "purchase";
        }
        response.sendRedirect("/incorrect");
        return "emailCheck";
    }

    @RequestMapping(value = "/incorrect")
    public String incorrect( Model model){
        model.addAttribute("user", ema);
        return "emailCheck";
    }

}

