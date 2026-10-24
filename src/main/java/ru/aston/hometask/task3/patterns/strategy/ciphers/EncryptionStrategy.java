package ru.aston.hometask.task3.patterns.strategy.ciphers;

public interface EncryptionStrategy {
    String encrypt(String data);
    String decrypt(String encryptedData);
    String getAlgorithmName();
}
