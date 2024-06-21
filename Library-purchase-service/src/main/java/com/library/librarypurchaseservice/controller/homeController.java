package com.library.librarypurchaseservice.controller;

import com.library.librarypurchaseservice.feign.PurchaseInterface;
import com.library.librarypurchaseservice.model.Books;
import com.library.librarypurchaseservice.repository.UserRepo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class homeController {
    @Autowired
    UserRepo repo;
    @Autowired
    private PurchaseInterface purchaseInterface;
    @RequestMapping(value = "/")
    public String home(@ModelAttribute("book") Books book, Model model,
                       @CookieValue(name = "cookieName", defaultValue = "malicious") String cookieName, HttpServletResponse response
                       ) throws IOException {
        if(cookieName.equals("malicious")){
            response.sendRedirect("/setCookie");
        }
        Books b_book=purchaseInterface.getAllBooks().getBody();
        System.out.println(b_book);
        model.addAttribute("book",b_book);
        return "purchase";
    }
}

