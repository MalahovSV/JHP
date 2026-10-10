package ru.aston.hometask.task2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {

    @JsonProperty("book_id")
    private int id;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("name_book")
    private String name;

    @JsonProperty("author")
    private String author;

    @JsonProperty("year")
    private short year;

    @JsonProperty("pages")
    private short pages;

    @JsonProperty("publisher")
    private String publisher;

    public Book(int id, String isbn, String name, String author, short year, short pages, String publisher){
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public short getPages() {
        return pages;
    }

    public short getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }
}
