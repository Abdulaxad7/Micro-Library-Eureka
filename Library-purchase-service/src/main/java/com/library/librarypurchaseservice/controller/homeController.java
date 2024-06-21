package com.library.librarypurchaseservice.controller;

import com.library.librarypurchaseservice.feign.PurchaseInterface;
import com.library.librarypurchaseservice.model.Books;
import com.library.librarypurchaseservice.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class homeController {
    @Autowired
    UserRepo repo;
    @Autowired
    private PurchaseInterface purchaseInterface;
    @RequestMapping(value = "/")
    public String home(@ModelAttribute("book") Books book){
   Books books=purchaseInterface.getBookForPurchase(book).getBody();
        System.out.println(books);
        Books b_book=purchaseInterface.getAllBooks().getBody();
        System.out.println(b_book);
        return "purchase";
    }
}
