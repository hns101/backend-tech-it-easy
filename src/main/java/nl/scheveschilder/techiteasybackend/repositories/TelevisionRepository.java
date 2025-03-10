package nl.scheveschilder.techiteasybackend.repositories;

import nl.scheveschilder.techiteasybackend.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    List<Television> findAllTelevisionsByBrandEqualsIgnoreCase(String brand);
}
