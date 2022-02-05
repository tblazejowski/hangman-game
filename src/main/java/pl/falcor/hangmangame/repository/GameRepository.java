package pl.falcor.hangmangame.repository;

import org.springframework.data.repository.CrudRepository;
import pl.falcor.hangmangame.entities.Game;

public interface GameRepository extends CrudRepository<Game, Long> {
}
