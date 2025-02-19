package nl.scheveschilder.techiteasybackend.services;

import nl.scheveschilder.techiteasybackend.dtos.TelevisionDto;
import nl.scheveschilder.techiteasybackend.dtos.TelevisionInputDto;
import nl.scheveschilder.techiteasybackend.exceptions.RecordNotFoundException;
import nl.scheveschilder.techiteasybackend.models.Television;
import nl.scheveschilder.techiteasybackend.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

@Service
public class TelevisionService {

    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }

    public Television getTelevision(Long id) {
        return this.repos.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television " + id + " not Found"));
    }

    public Television createTelevision(TelevisionDto televisionDto) {
        Television television = TelevisionInputDto.fromDtoToTelevision(televisionDto);
        this.repos.save(television);
        return television;
    }



}
