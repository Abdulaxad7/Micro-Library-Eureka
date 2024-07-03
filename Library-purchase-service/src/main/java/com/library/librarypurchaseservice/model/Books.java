package com.library.librarypurchaseservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Document(collection = "library")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
   
    private String title;
    private String isbn;
    private String pageCount;
    private String publishedDate;
    private String thumbnailUrl;
    private String shortDescription;
    private String longDescription;

    @Override
    public String toString() {

        return "Books{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", pageCount='" + (pageCount==null?"":pageCount) + '\'' +
                ", publishedDate='" + (publishedDate==null?"":publishedDate) + '\'' +
                ", thumbnailUrl='" + (thumbnailUrl==null?"":thumbnailUrl) + '\'' +
                ", shortDescription='" + (shortDescription==null?"":shortDescription) + '\'' +
                ", longDescription='" + (longDescription==null?"":longDescription) + '\'' +
                '}';
    }

    public String getPublishedDate() {
        if (publishedDate!=null) {
            return publishedDate.substring(4, 10) + "\nYear " + publishedDate.substring(23, publishedDate.length());
        }
        return "";
    }



}


