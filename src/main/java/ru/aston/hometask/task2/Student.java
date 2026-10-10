package ru.aston.hometask.task2;

import java.time.Instant;
import java.util.List;

public class Student {
    private String studentIDNumber;
    private String surname;
    private String firstName;
    private String secondName;
    private Instant dateBirth;
    private String group;
    private List<Book> books;

    public Student(String studentIDNumber, String surname, String firstName, String secondName, Instant dateBirth, String group){
        this.studentIDNumber = studentIDNumber;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateBirth = dateBirth;
        this.group = group;
    }

    public Student(String studentIDNumber, String surname, String firstName, String secondName, Instant dateBirth, String group, List<Book> books){
        this.studentIDNumber = studentIDNumber;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateBirth = dateBirth;
        this.group = group;
        this.books = books;
    }

    @Override
    public String toString(){
        return String.format("Номер студентческого билета: %s\nФамилия: %s\nИмя: %s\nОтчество: %s\nДата рождения: %s\nГруппа: %s\n",
                studentIDNumber, surname, firstName, secondName, dateBirth.toString(), group);
    }

    public void addBook(Book book){
        this.books.add(book);
    }

}
