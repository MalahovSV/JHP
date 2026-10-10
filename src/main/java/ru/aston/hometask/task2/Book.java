package ru.aston.hometask.task2;

import com.fasterxml.jackson.annotation.*;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book implements Comparable<Book> {

    @JsonProperty("book_id")
    private int id;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("name_book")
    private String name;

    @JsonProperty("author")
    private String author;

    @JsonProperty("year")
    private int year;

    @JsonProperty("pages")
    private int pages;

    @JsonProperty("publisher")
    private String publisher;

    @JsonCreator
    public Book(
            @JsonProperty("book_id") int id,
            @JsonProperty("isbn") String isbn,
            @JsonProperty("name_book") String name,
            @JsonProperty("author") String author,
            @JsonProperty("year") int year,
            @JsonProperty("pages") int pages,
            @JsonProperty("publisher") String publisher) {
        this.id = id;
        this.isbn = Objects.requireNonNull(isbn, "ISBN не может быть null (Отсутствие ISBN указать как None)");
        this.name = name;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.publisher = publisher;
    }

    @Override
    public String toString(){
        return String.format("ID: %s%nISBN: %s%nНаименование: %s%nАвтор: %s%nИздатель: %s%nСтраниц: %d%nГод издания: %d%n",
                this.id, this.isbn, this.name, this.author, this.publisher, this.pages, this.year);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book)o;
        return Objects.equals(this.isbn, that.isbn) &&
                Objects.equals(this.author, that.author) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.year, that.year) &&
                Objects.equals(this.publisher, that.publisher);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.isbn, this.author, this.name, this.year, this.publisher);
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.pages, o.pages);
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public int getPages() {return pages;}
    public int getYear() {return year;}
    public String getAuthor() {return author;}
    public String getIsbn() {return isbn;}
    public String getPublisher() {return publisher;}

}
