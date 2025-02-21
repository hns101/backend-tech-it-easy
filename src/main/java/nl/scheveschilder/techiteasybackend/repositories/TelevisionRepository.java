package nl.scheveschilder.techiteasybackend.repositories;

import nl.scheveschilder.techiteasybackend.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
}
