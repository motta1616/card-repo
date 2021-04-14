package co.com.sofka.cargame.repository;

import co.com.sofka.cargame.usecase.SetGameUseCase;
import co.com.sofka.cargame.usecase.StartGameUseCase;
import co.com.sofka.cargame.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;
    private SetGameUseCase setGameUseCase = new SetGameUseCase();
    private StartGameUseCase startGameUseCase = new StartGameUseCase();

    public void start(CarDto carDto) {

        try {
            Game game = setGameUseCase.setGame(carDto);
            startGameUseCase.startGame(game);
            repository.save(game.podium());

        }catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exception.getMessage());
        }
    }
}
