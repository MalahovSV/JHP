package ru.aston.hometask.task2;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {

    @JsonProperty("student_id")
    private String studentIDNumber;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("second_name")
    private String secondName;

    @JsonProperty("date_birth")
    private LocalDate dateBirth;

    @JsonProperty("group")
    private String group;

    @JsonProperty("books")
    private List<Book> books;

    public Student(String studentIDNumber, String surname, String firstName, String secondName, LocalDate dateBirth, String group){
        this.studentIDNumber = Objects.requireNonNull(studentIDNumber, "ID студента не может быть null");
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateBirth = dateBirth;
        this.group = group;
        this.books = new ArrayList<Book>();
    }

    @JsonCreator
    public Student(
            @JsonProperty("student_id") String studentIDNumber,
            @JsonProperty("surname") String surname,
            @JsonProperty("first_name") String firstName,
            @JsonProperty("second_name") String secondName,
            @JsonProperty("date_birth") LocalDate dateBirth,
            @JsonProperty("group") String group,
            @JsonProperty("books") List<Book> books) {
        this.studentIDNumber = Objects.requireNonNull(studentIDNumber, "ID студента не может быть null");
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateBirth = dateBirth;
        this.group = group;
        this.books = books != null ? books : new ArrayList<>();
    }

    @Override
    public String toString(){
        return String.format("Номер студенческого билета: %s%nФамилия: %s%nИмя: %s%nОтчество: %s%nДата рождения: %s%nГруппа: %s%n",
                studentIDNumber, surname, firstName, secondName, dateBirth, group);
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return Objects.equals(this.studentIDNumber, that.studentIDNumber) &&
                Objects.equals(this.dateBirth, that.dateBirth);
    }

    @Override
    public int hashCode (){
        return Objects.hash(this.studentIDNumber, this.dateBirth);
    }

    public String getStudentIDNumber() { return studentIDNumber; }
    public String getSurname() { return surname; }
    public String getFirstName() { return firstName; }
    public String getSecondName() { return secondName; }
    public LocalDate getDateBirth() { return dateBirth; }
    public String getGroup() { return group; }
    public List<Book> getBooks() { return books; }
}
