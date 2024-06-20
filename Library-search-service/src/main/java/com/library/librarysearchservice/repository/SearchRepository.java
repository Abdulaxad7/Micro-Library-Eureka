package com.library.librarysearchservice.repository;


import com.library.librarysearchservice.model.Books;

import java.util.List;

public interface SearchRepository {
   List<Books> findByInput(String text);
   Books findByIsbn(String isbn);
}
