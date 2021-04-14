package co.com.sofka.cargame.repository;

import lombok.Data;

import java.util.List;

@Data
public class CarDto {

    private Integer distance;
    private List<String> gamerNames;

    public Integer distance() {
        return distance;
    }

    public List<String> gamerNames() {
        return gamerNames;
    }
}
