package ru.aston.hometask.task3.patterns.strategy.ciphers;


public class CaesarCipherStrategy implements EncryptionStrategy {
    private final int shift;

    public CaesarCipherStrategy(int shift) {
        this.shift = shift;
    }

    @Override
    public String encrypt(String data) {
        StringBuilder result = new StringBuilder();
        for (char character : data.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char encrypted = (char) ((character - base + shift) % 26 + base);
                result.append(encrypted);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String encryptedData) {
        return new CaesarCipherStrategy(26 - (shift % 26)).encrypt(encryptedData);
    }

    @Override
    public String getAlgorithmName() {
        return "Шифр Цезаря (сдвиг " + shift + ")";
    }
}