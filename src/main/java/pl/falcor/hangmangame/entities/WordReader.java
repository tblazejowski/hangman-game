package pl.falcor.hangmangame.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordReader {

    private List<String> words = new ArrayList<>();

    public List<String> getWordsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/words.txt"))) {
            String line = br.readLine();
            while (line != null) {
                words.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    public List<String> getWords() {
        return words;
    }
}
