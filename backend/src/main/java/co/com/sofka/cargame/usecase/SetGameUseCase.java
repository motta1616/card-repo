package co.com.sofka.cargame.usecase;

import co.com.sofka.cargame.domain.*;
import co.com.sofka.cargame.repository.CarDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SetGameUseCase {
    public Game setGame(CarDto carDto) {
        int distance = carDto.distance();
        int finish = (distance);
        Circuit circuit = new Circuit(distance);
        int amountGamer = carDto.gamerNames().size();
        List<Gamer> gamers = new ArrayList<>();

        for(int i = 0; i < amountGamer; i++){
            Track track = new Track(i + 1);
            Car car = new Car(track, finish);
            String gamerName = carDto.gamerNames().get(i);
            Driver driver = new Driver(gamerName, car);
            Gamer gamer = new Gamer(gamerName, driver);
            gamers.add(gamer);
        }
        Game game = new Game(1, circuit, gamers);
        return game;
    }


}
