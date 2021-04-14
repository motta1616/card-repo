package co.com.sofka.cargame.domain;

import lombok.Data;


@Data
public class Circuit {
    private Integer distance;

    public Circuit(Integer distance) { this.distance = distance; }
}
