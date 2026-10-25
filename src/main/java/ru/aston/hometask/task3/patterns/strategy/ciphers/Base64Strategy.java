package ru.aston.hometask.task3.patterns.strategy.ciphers;


import java.util.Base64;

public class Base64Strategy implements EncryptionStrategy {
    @Override
    public String encrypt(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    @Override
    public String decrypt(String encryptedData) {
        return new String(Base64.getDecoder().decode(encryptedData));
    }

    @Override
    public String getAlgorithmName() {
        return "Base64 (кодирование)";
    }
}