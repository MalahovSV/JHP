package ru.aston.hometask.task3.demos;

import ru.aston.hometask.task3.patterns.strategy.DataEncryptor;
import ru.aston.hometask.task3.patterns.strategy.ciphers.Base64Strategy;
import ru.aston.hometask.task3.patterns.strategy.ciphers.CaesarCipherStrategy;
import ru.aston.hometask.task3.patterns.strategy.ciphers.VigenereCipherStrategy;

public class StrategyDemo {
    public void run() {
        String secretData = "For the Emperor!";

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
