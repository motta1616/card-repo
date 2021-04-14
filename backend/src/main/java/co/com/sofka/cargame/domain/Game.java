package co.com.sofka.cargame.domain;

import lombok.Data;


import java.util.List;

@Data
public class Game {

    private Integer id;
    private Circuit circuit;
    private List<Gamer> gamers;
    private Podium podium;

    public Game(Integer id, Circuit circuit, List<Gamer> gamers) {
        this.circuit = circuit;
        this.gamers = gamers;
        this.podium = new Podium();

    }

    public List<Gamer> gamers() {
        return gamers;
    }

    public Podium podium() {
        return podium;
    }

}
