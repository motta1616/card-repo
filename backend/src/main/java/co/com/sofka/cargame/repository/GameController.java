package co.com.sofka.cargame.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {

    @Autowired
    private GameService service;

    @PostMapping(value = "api/game")
    public void start(@RequestBody CarDto carDto) {
        service.start(carDto);
    }
}
