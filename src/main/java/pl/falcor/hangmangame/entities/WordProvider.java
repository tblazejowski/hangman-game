package pl.falcor.hangmangame.entities;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordProvider {

    private static List<String> wordList = Arrays.asList("kot", "malkontent", "żółw");
    private String word;
    private final List<String> wordsFromFile = new WordReader().getWordsFromFile();

    public String provide() {
        Random random = new Random();
        word = wordsFromFile.get(random.nextInt(wordsFromFile.size()));
        return word;
    }

    public String hide() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append("_");
        }
        return sb.toString();
    }
}
