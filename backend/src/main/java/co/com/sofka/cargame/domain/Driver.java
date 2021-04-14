package co.com.sofka.cargame.domain;

import lombok.Data;

import java.util.Objects;

@Data
public class Driver {

    private final String fullName;
    private Car car;

    public Driver(String fullName, Car car) {
        this.fullName = Objects.requireNonNull(fullName);
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public Integer throwdice() {
        return ((int) Math.floor((Math.random() * 6) + 1)*100);
    }

}

