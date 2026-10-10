package ru.aston.hometask.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Task2Main {
    public static void main(String[] args) {
        writeJSON();
    }

    private static void writeJSON(){
        ObjectMapper objectMapper = new ObjectMapper();
        Book book = new Book(1, "1232134", "Пикник на обочине", "Аркадий и Борис Стругацкие", 1987, 340, "АСТ");

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("data.json");


        try {
            objectMapper.writeValue(file, book);
        } catch (IOException e){
            System.err.println("Error write file:" + e.getMessage());
            e.printStackTrace();
        }
    }
}