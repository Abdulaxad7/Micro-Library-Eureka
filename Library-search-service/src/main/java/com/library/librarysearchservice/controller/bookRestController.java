//package com.library.librarysearchservice.controller;
//
//import com.library.librarysearchservice.model.Books;
//import com.library.librarysearchservice.repository.BookRepository;
//import com.library.librarysearchservice.repository.SearchRepository;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.NoHandlerFoundException;
//
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//
//public class bookRestController {
//
//    @Autowired
//    private BookRepository b_repo;
//    @Autowired
//    private SearchRepository s_repo;
//
//    @RequestMapping(value = "/")
//    public void home(HttpServletResponse response) throws IOException {
//
//
//        response.sendRedirect("/swagger-ui.html");
//    }
//
//    @PostMapping("/newBook")
//    public void newBook(@ModelAttribute("book") Books book){
//
//        b_repo.save(book);
//    }
//
//    @GetMapping(  "/books")
//    public List<Books> getHome(){
//        return b_repo.findAll();
//    }
//
//    @GetMapping("/books/{text}")
//    public List<Books> getBookByUserInput(@PathVariable("text") String text){
//     return s_repo.findByInput(text);
//    }
//
//
//    @GetMapping("/books/description/{desc}")
//    public Books getBookDescription(@PathVariable("desc") String desc, Model model){
//       return s_repo.findByIsbn(desc);
//    }
//
//    @DeleteMapping("books/delete/{desc}")
//    public void deleteBook(@PathVariable("desc") String desc){
//        b_repo.deleteById(desc);
//    }
//    @ExceptionHandler(NoHandlerFoundException.class)
//    public String handleNotFound(Exception ex) {
//        return "Error: resource not found. "+ex.getMessage();
//    }
//
//
//}
