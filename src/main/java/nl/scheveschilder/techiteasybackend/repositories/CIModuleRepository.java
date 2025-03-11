package nl.scheveschilder.techiteasybackend.repositories;

import nl.scheveschilder.techiteasybackend.models.CIModule;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CIModuleRepository extends JpaRepository<CIModule, Long> {
}
