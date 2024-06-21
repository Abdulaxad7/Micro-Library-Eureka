package com.library.librarypurchaseservice.repository;

import com.library.librarypurchaseservice.model.Books;
import com.library.librarypurchaseservice.model.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserData,String> {

}
