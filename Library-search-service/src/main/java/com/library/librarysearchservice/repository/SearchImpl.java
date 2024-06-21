package com.library.librarysearchservice.repository;

import com.library.librarysearchservice.model.Books;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchImpl implements SearchRepository{
    @Autowired
    MongoConverter converter;
    @Autowired
    MongoClient client;
    @Override
    public List<Books> findByInput(String text) {
        List<Books> books = new ArrayList<>();
        MongoDatabase database = client.getDatabase("Library");
        MongoCollection<org.bson.Document> collection = database.getCollection("library");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                        new Document("query", text)
                        .append("path", Arrays.asList("title", "isbn", "categories", "authors")))),
                        new Document("$sort",
                        new Document("publishedDate", -1L))));

        result.forEach(n->books.add(converter.read(Books.class, n)));
            return books.parallelStream().distinct().collect(Collectors.toList());
    }
    @Override
    public Books findByIsbn(String isbn){

        MongoDatabase database = client.getDatabase("Library");
        MongoCollection<Document> collection = database.getCollection("library");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", isbn)
                                .append("path", Arrays.asList("isbn"))))));
        return converter.read(Books.class, result.first());
    }

}
