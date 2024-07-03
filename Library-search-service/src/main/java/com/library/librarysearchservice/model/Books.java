package com.library.librarysearchservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

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
    private String[]authors;
    private String[] categories;

    @Override
    public String toString() {
        return "Books{" +
                "  title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", pageCount='" + pageCount + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", authors=" + (authors == null ? "[]" : Arrays.asList(authors)) +
                ", categories=" + (categories == null ? "[]" : Arrays.asList(categories)) +
                '}';
    }
    public String getPublishedDate() {
        if (publishedDate != null && publishedDate.length() > 23){

                return publishedDate.substring(4, 10) + "\nYear " + publishedDate.substring(23, publishedDate.length());

        }
        return "";
    }
    public String getAuthors() {

        return Arrays.toString(authors).replace("[", "").replace("]", "");
    }
    public String getCategories() {
        return Arrays.toString(categories).replace("[", "").replace("]", "");
    }
}


