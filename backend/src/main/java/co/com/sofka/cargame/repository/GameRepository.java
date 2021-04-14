package co.com.sofka.cargame.repository;

import co.com.sofka.cargame.domain.Podium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository <Podium, Integer> {
}
