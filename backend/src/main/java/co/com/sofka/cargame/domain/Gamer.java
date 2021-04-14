package co.com.sofka.cargame.domain;

import lombok.Data;

import java.util.Objects;

@Data
public class Gamer {
    private final String name;
    private Driver driver;
    private Integer wins;

    public Gamer(String name, Driver driver) {
        this.name = Objects.requireNonNull(name, "It can not be null");
        this.driver =driver;
        this.wins = 0;
    }

    public Integer addWins(){
       return wins = wins + 1;
    }

    public String name() {
        return name;
    }

    public Driver driver() {
        return driver;
    }

    public Integer wins() {
        return wins;
    }
}
