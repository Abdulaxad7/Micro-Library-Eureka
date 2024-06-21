package com.library.librarypurchaseservice.feign;

import com.library.librarypurchaseservice.model.Books;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient("LIBRARY-SEARCH-SERVICE")
public interface PurchaseInterface {
    @PostMapping(value = "/buy")
    ResponseEntity<Books> getBookForPurchase(@ModelAttribute("books") Books book);
    @GetMapping("/getAll")
    ResponseEntity<Books> getAllBooks();
}


