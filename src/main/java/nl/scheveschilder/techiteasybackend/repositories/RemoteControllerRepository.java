package nl.scheveschilder.techiteasybackend.repositories;

import nl.scheveschilder.techiteasybackend.models.RemoteController;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemoteControllerRepository extends JpaRepository<RemoteController, Long> {
}
