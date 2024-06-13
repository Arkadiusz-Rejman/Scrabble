package amk.scrabble.utils;

import jakarta.servlet.ServletContext;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class PolishDictionaryChecker {
    private Set<String> wordSet;

    public PolishDictionaryChecker(ServletContext context, String filePath) throws IOException {


        InputStream inputStream = context.getResourceAsStream(filePath);
        if (inputStream == null) {
            System.out.println("Plik nie istnieje: " + filePath);
            return;
        } else {
            System.out.println("Plik istnieje: " + filePath);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            wordSet = new HashSet<>();
            String line;
            while ((line = reader.readLine()) != null) {
                wordSet.add(line.trim());
            }
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
