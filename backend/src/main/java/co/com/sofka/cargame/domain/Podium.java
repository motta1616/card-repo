package co.com.sofka.cargame.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Podium {

    @Id
    @GeneratedValue
    private Integer numberGame;
    private Integer awinerGamer;
    private String first;
    private String second;
    private String third;

    public Podium() {
        this.first = "first";
        this.second = "second";
        this.third = "third";
    }

    public String first() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String second() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String third() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public void setAwinerGamer(Integer awinerGamer) {
        this.awinerGamer = awinerGamer;
    }
}

