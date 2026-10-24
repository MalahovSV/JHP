package ru.aston.hometask.task3.patterns.strategy.ciphers;

import ru.aston.hometask.task3.patterns.strategy.EncryptionStrategy;

public class VigenereCipherStrategy implements EncryptionStrategy {
    private final String key;

    public VigenereCipherStrategy(String key) {
        this.key = key.toLowerCase();
    }

    @Override
    public String encrypt(String data) {
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;

        for (char character : data.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                int shift = key.charAt(keyIndex % key.length()) - 'a';
                char encrypted = (char) ((character - base + shift) % 26 + base);
                result.append(encrypted);
                keyIndex++;
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String encryptedData) {
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;

        for (char character : encryptedData.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                int shift = key.charAt(keyIndex % key.length()) - 'a';

                char decrypted = (char) ((character - base - shift + 26) % 26 + base);
                result.append(decrypted);
                keyIndex++;
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    @Override
    public String getAlgorithmName() {
        return "Шифр Виженера (ключ: " + key + ")";
    }
}