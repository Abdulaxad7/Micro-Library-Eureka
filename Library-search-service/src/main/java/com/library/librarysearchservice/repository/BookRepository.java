package com.library.librarysearchservice.repository;


import com.library.librarysearchservice.model.Books;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookRepository extends MongoRepository<Books,String> {
}


