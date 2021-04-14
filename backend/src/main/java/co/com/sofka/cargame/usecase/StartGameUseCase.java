package co.com.sofka.cargame.usecase;

import co.com.sofka.cargame.domain.Game;
import co.com.sofka.cargame.domain.Gamer;
import co.com.sofka.cargame.domain.Podium;

import java.util.List;

public class StartGameUseCase {
    public void startGame(Game game) {
        int run;
        boolean stop = false;
        List<Gamer> gamers = game.gamers();
        Podium podium = game.podium();
        while (!stop){
            for (int i = 0; i <gamers.size(); i++){
                Gamer gamer = gamers.get(i);

                int meta = gamer.driver().getCar().finish() * 1000;
                run = gamer.driver().getCar().advance();
                if(run<meta){
                    run= run + gamer.driver().throwdice();
                    gamer.driver().getCar().setAdvance(run);
                }else {
                    firstAndSecond(podium, gamer);
                    if (thirdPlace(podium, gamer)){
                        third(podium, gamer);
                        stop = true;
                        break;
                    }
                }
            }
        }
    }

    private void firstAndSecond(Podium podium, Gamer gamer) {
        if(firstPlace(podium)){
            first(podium, gamer);
        }
        if(secondPlace(podium, gamer)){
            second(podium, gamer);
        }
    }

    private void third(Podium podium, Gamer gamer) {
        podium.setThird(gamer.name());
    }

    private void second(Podium podium, Gamer gamer) {
        podium.setSecond(gamer.name());
        gamer.driver().getCar().setRunnig(false);
    }

    private void first(Podium podium, Gamer gamer) {
        podium.setFirst(gamer.name());
        gamer.driver().getCar().setRunnig(false);
        podium.setAwinerGamer(gamer.addWins());
    }

    private boolean thirdPlace(Podium podium, Gamer gamer) {
        return podium.third().equals("third") && gamer.driver().getCar().runnig();
    }

    private boolean secondPlace(Podium podium, Gamer gamer) {
        return podium.second().equals("second") && gamer.driver().getCar().runnig();

    }

    private boolean firstPlace(Podium podium) {
        return podium.first().equals("first");
    }
}
