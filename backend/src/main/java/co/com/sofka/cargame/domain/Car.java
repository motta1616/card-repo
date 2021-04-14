package co.com.sofka.cargame.domain;

import lombok.Data;

@Data
public class Car {

    private  Track track;
    private Integer advance;
    private Integer finish;
    private boolean isRunnig;

    public Car(Track track, Integer finish) {
        this.track = track;
        this.finish = finish;
        this.advance = 0;
        this.isRunnig = true;
    }

    public Integer advance() {
        return advance;
    }

    public Integer finish() {
        return finish;
    }

    public boolean runnig() {
        return isRunnig;
    }

    public void setAdvance(Integer advance) {
        this.advance = advance;
    }

    public void setRunnig(boolean runnig) {
        isRunnig = runnig;
    }
}
