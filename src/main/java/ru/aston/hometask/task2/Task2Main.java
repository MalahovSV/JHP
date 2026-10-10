package ru.aston.hometask.task2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task2Main {
    static final Path DATA_PAPTH = Path.of("src/main/resources/data.json");

    public static void main(String[] args) {
        if (!Files.exists(DATA_PAPTH)) writeJSON(createStudents());
        selectJSON(readJSON());
    }

    private static void selectJSON(List<Student> students) {
        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .filter(b -> b.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска искомой книги: " + year),
                        () -> System.out.println("Такая книга отсутствует")
                );
    }

    private static List<Student> readJSON(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try (var is = Files.newInputStream(DATA_PAPTH)) {
            return objectMapper.readValue(is, new TypeReference<List<Student>>() {});
        } catch (IOException e) {
            System.err.println("Error read file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private static void writeJSON(List<Student> data){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try (var os = Files.newOutputStream(DATA_PAPTH)) {
            objectMapper.writeValue(os, data);
        } catch (IOException e){
            System.err.println("Error write file:" + e.getMessage());
        }
    }

    private static List<Student> createStudents() {
        List<Student> students = new ArrayList<>();

        Student s1 = new Student("S12345", "Иванов", "Иван", "Иванович",
                LocalDate.of(2000, 1, 15), "ИУ7-21Б");
        s1.addBook(new Book(1, "978-5-17-118899-1", "Война и мир", "Лев Толстой", 1869, 1300, "АСТ"));
        s1.addBook(new Book(2, "978-5-04-116637-2", "Преступление и наказание", "Фёдор Достоевский", 1866, 670, "Эксмо"));
        s1.addBook(new Book(3, "978-5-04-316407-9", "Пикник на обочине", "Аркадий и Борис Стругацкие", 1987, 340, "АСТ"));
        s1.addBook(new Book(4, "978-5-389-07493-4", "Мастер и Маргарита", "Михаил Булгаков", 1967, 480, "Азбука"));
        s1.addBook(new Book(5, "978-5-17-090212-3", "Гарри Поттер и философский камень", "Джоан Роулинг", 2001, 430, "Росмэн"));
        students.add(s1);

        Student s2 = new Student("S12346", "Петров", "Пётр", "Петрович",
                LocalDate.of(2001, 3, 22), "ИУ7-22Б");
        s2.addBook(new Book(1, "978-5-17-118899-1", "Война и мир", "Лев Толстой", 1869, 1300, "АСТ"));
        s2.addBook(new Book(6, "978-5-699-12014-7", "1984", "Джордж Оруэлл", 1949, 320, "Эксмо"));
        s2.addBook(new Book(7, "978-5-17-087604-2", "Гарри Поттер и Тайная комната", "Джоан Роулинг", 2005, 480, "Росмэн"));
        s2.addBook(new Book(8, "978-5-04-316407-9", "Пикник на обочине", "Аркадий и Борис Стругацкие", 1987, 340, "АСТ"));
        s2.addBook(new Book(9, "978-5-04-098765-4", "Тень горы", "Грегори Дэвид Робертс", 2008, 864, "Азбука"));
        students.add(s2);

        Student s3 = new Student("S12347", "Сидорова", "Анна", "Сергеевна",
                LocalDate.of(2002, 7, 8), "ИУ7-21Б");
        s3.addBook(new Book(10, "978-5-389-07493-4", "Мастер и Маргарита", "Михаил Булгаков", 1967, 480, "Азбука"));
        s3.addBook(new Book(11, "978-5-17-118899-1", "Война и мир", "Лев Толстой", 1869, 1300, "АСТ"));
        s3.addBook(new Book(12, "978-5-04-116637-2", "Преступление и наказание", "Фёдор Достоевский", 1866, 670, "Эксмо"));
        s3.addBook(new Book(13, "978-5-17-090213-0", "Гарри Поттер и узник Азкабана", "Джоан Роулинг", 2010, 540, "Росмэн"));
        s3.addBook(new Book(14, "978-5-17-087605-9", "Гарри Поттер и Кубок огня", "Джоан Роулинг", 2012, 720, "Росмэн"));
        s3.addBook(new Book(20, "none", "Аналитическая геометрия", "Ливанов К. В.", 2015, 666, "Институт страданий"));
        students.add(s3);

        Student s4 = new Student("S12348", "Кузнецов", "Дмитрий", "Александрович",
                LocalDate.of(1999, 11, 30), "ИУ7-23Б");
        s4.addBook(new Book(15, "978-5-17-090212-3", "Гарри Поттер и философский камень", "Джоан Роулинг", 2001, 430, "Росмэн"));
        s4.addBook(new Book(16, "978-5-04-098765-4", "Тень горы", "Грегори Дэвид Робертс", 2008, 864, "Азбука"));
        s4.addBook(new Book(17, "978-5-699-12014-7", "1984", "Джордж Оруэлл", 1949, 320, "Эксмо"));
        s4.addBook(new Book(18, "978-5-389-07493-4", "Мастер и Маргарита", "Михаил Булгаков", 1967, 480, "Азбука"));
        s4.addBook(new Book(19, "978-5-17-118899-1", "Война и мир", "Лев Толстой", 1869, 1300, "АСТ"));
        s4.addBook(new Book(21, "none", "Visual Fox Pro", "Старикова А. В.", 2024, 50, "Институт страданий"));
        students.add(s4);

        return students;
    }
}