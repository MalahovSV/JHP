package ru.aston.hometask.task3;

import ru.aston.hometask.task3.patterns.builder.Director;
import ru.aston.hometask.task3.patterns.builder.builders.ComputerBuilder;
import ru.aston.hometask.task3.patterns.builder.builders.RouterBuilder;
import ru.aston.hometask.task3.patterns.strategy.DataEncryptor;
import ru.aston.hometask.task3.patterns.strategy.ciphers.Base64Strategy;
import ru.aston.hometask.task3.patterns.strategy.ciphers.CaesarCipherStrategy;
import ru.aston.hometask.task3.patterns.strategy.ciphers.VigenereCipherStrategy;

import java.util.ArrayList;
import java.util.List;

public class StartPatterns {
    private final String SEPARATOR_LINE = "\n========================================================================\n";

    public void startBuilder(){
        System.out.println(SEPARATOR_LINE);
        Director director = new Director();
        List<Object> warehouse = new ArrayList<>();

        ComputerBuilder pcBuilder = new ComputerBuilder();
        director.makeDesktop(pcBuilder);
        warehouse.add(pcBuilder.build());

        RouterBuilder routerBuilder = new RouterBuilder();
        director.makeRouter(routerBuilder);
        warehouse.add(routerBuilder.build());
        warehouse.forEach(System.out::println);
    }

    public void startStrategy(){
        String secretData = "For the Imperor!";

        System.out.println(SEPARATOR_LINE + "Оригинальные данные: " + secretData + "\n");

        DataEncryptor encryptor = new DataEncryptor(new Base64Strategy());

        String base64Encrypted = encryptor.encrypt(secretData);
        System.out.println("Зашифровано (Base64): " + base64Encrypted);
        System.out.println("Расшифровано: " + encryptor.decrypt(base64Encrypted) + "\n");

        encryptor.setStrategy(new CaesarCipherStrategy(3));
        String caesarEncrypted = encryptor.encrypt(secretData);
        System.out.println("Зашифровано (Цезарь): " + caesarEncrypted);
        System.out.println("Расшифровано: " + encryptor.decrypt(caesarEncrypted) + "\n");

        encryptor.setStrategy(new VigenereCipherStrategy("astra"));
        String vigenereEncrypted = encryptor.encrypt(secretData);
        System.out.println("Зашифровано (Виженер): " + vigenereEncrypted);
        System.out.println("Расшифровано: " + encryptor.decrypt(vigenereEncrypted));
    }
}
