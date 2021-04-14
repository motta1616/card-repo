package co.com.sofka.cargame.domain;


import lombok.Data;

@Data
public class Track {
    private Integer id;


    public Track(Integer id) {
        this.id = id;
    }
}
