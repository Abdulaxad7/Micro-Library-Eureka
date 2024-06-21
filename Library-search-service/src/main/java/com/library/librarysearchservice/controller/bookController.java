package com.library.librarysearchservice.controller;

import com.library.librarysearchservice.model.Books;
import com.library.librarysearchservice.repository.SearchRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;



@Controller

public class bookController {
    @Autowired
    private SearchRepository s_repo;

    private Books books=new Books();

    @RequestMapping(value = "/{text}")
    public String home(@CookieValue(name = "cookieName", defaultValue = "malicious") String cookieName,
                       @PathVariable("text") String text, HttpServletResponse response, Model model) throws IOException {
        if (cookieName.equals("malicious")) {
            response.sendRedirect("/setCookie");
        }
        model.addAttribute("text", text);
        return "home";
    }

    @PostMapping("/text")
    public void text(@CookieValue(name = "cookieName", defaultValue = "malicious") String cookieName,
                     HttpServletResponse response, @ModelAttribute("text") String text) throws IOException {
        if (cookieName.equals("malicious")) {
            response.sendRedirect("/setCookie");
        }
        response.sendRedirect("/books/" + text);
    }

    @GetMapping("/books")
    public String getHome() {
        return "home";
    }

    @GetMapping("/books/{text}")
    public String getBookByUserInput(@PathVariable("text") String text, Model model) {

        model.addAttribute("books", s_repo.findByInput(text));
        return "home";
    }

    @PostMapping("/bookInfo")
    public void desc(@CookieValue(name = "cookieName", defaultValue = "malicious") String cookieName,
                     HttpServletResponse response, @ModelAttribute("isbn") String isbn) throws IOException {

        if (cookieName.equals("malicious")) {
            response.sendRedirect("/setCookie");
        }
        response.sendRedirect("/books/description/" + isbn);
    }

    @GetMapping("/books/description/{desc}")
    public String getBookDescription(@PathVariable("desc") String desc, Model model) {
        model.addAttribute("books", s_repo.findByIsbn(desc));
        return "bookInfo";
    }

    @PostMapping("/books/delete")
    public void deleteBook(@CookieValue(name = "cookieName", defaultValue = "malicious") String cookieName,
                           @ModelAttribute("isbn") String isbn, HttpServletResponse response) throws IOException {
        if (cookieName.equals("malicious")) {
            response.sendRedirect("/setCookie");
        }
        response.sendRedirect("/books/delete/" + isbn);

    }

    @GetMapping("/books/delete/{isbn}")
    public String deleteBook(@PathVariable("isbn") String isbn, Model model) {
        model.addAttribute("books", s_repo.findByIsbn(isbn));
        return "bookInfo";
    }

    @PostMapping("/newBook")
    public void newBook(@CookieValue(name = "cookieName", defaultValue = "malicious") String cookieName,
                        @ModelAttribute("book") String book, HttpServletResponse response) throws IOException {
        if (cookieName.equals("malicious")) {
            response.sendRedirect("/setCookie");
        }
        response.sendRedirect("/newBook/" + book);
    }

    @GetMapping("/newBook/{book}")
    public String newBook(@PathVariable("book") String book, Model model) {

        model.addAttribute("books", s_repo.findByIsbn(book));
        return "bookInfo";
    }


    @PostMapping(value = "/buy")
    public ResponseEntity<Books> getBookForPurchase(@ModelAttribute("books") Books book){
            books=book;
        return new ResponseEntity<>(book,HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<Books> getAllBooks() {
            return new ResponseEntity<>(books, HttpStatus.OK);
    }


}



