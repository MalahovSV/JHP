package ru.aston.hometask.task3.patterns.strategy;


import ru.aston.hometask.task3.patterns.strategy.ciphers.EncryptionStrategy;

public class DataEncryptor {
    private EncryptionStrategy strategy;

    public DataEncryptor(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }

    public String encrypt(String data) {
        if (strategy == null) {
            throw new IllegalStateException("Стратегия шифрования не выбрана!");
        }
        System.out.println("Используется алгоритм: " + strategy.getAlgorithmName());
        return strategy.encrypt(data);
    }

    public String decrypt(String data) {
        if (strategy == null) {
            throw new IllegalStateException("Стратегия шифрования не выбрана!");
        }
        return strategy.decrypt(data);
    }
}