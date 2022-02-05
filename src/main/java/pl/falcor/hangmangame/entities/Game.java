package pl.falcor.hangmangame.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String word;
    private final String guess;

    public Game(WordProvider wordProvider) {
        this.word = wordProvider.provide();
        this.guess = wordProvider.hide();
    }

    public Game(String word, String guess) {
        this.word = word;
        this.guess = guess;
    }

    public Game() {
        WordProvider wordProvider = new WordProvider();
        this.word = wordProvider.provide();
        this.guess = wordProvider.hide();
    }

    public long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getGuess() {
        return guess;
    }
}
