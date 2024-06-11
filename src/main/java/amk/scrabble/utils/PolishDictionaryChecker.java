package amk.scrabble.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class PolishDictionaryChecker {
    private Set<String> wordSet;

    public PolishDictionaryChecker(String filePath) throws IOException {
        System.out.println("ODPALAM");
        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            System.out.println("Plik nie istnieje");
        }else System.out.println("Plik istnieje: " + filePath);


        try {
            wordSet = new HashSet<>(Files.readAllLines(path));
            System.out.println("Plik załadowany poprawnie: " + filePath);
        } catch (IOException e) {
            System.err.println("Błąd podczas ładowania pliku: " + e.getMessage());
            throw e;
        }
    }

    public boolean isWordInDictionary(String word) {
        return wordSet.contains(word);
    }

}
