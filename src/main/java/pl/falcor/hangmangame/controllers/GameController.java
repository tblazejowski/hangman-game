package pl.falcor.hangmangame.controllers;

import org.springframework.web.bind.annotation.*;
import pl.falcor.hangmangame.entities.Game;
import pl.falcor.hangmangame.entities.WordProvider;
import pl.falcor.hangmangame.repository.GameRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://0.0.0.0:4200"})
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("game")
    public Game getGame(){
        Game game = new Game(new WordProvider());
        gameRepository.save(game);
        return game;
    }

    @GetMapping("game/{id}")
    public Game getGameById(@PathVariable Long id){
        return gameRepository.findById(id).orElseThrow();
    }

    @PutMapping("game")
    public Game updateGame(){
        return new Game("updated Game", "");
    }
}
