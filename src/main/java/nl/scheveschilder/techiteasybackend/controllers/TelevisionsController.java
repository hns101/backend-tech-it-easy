package nl.scheveschilder.techiteasybackend.controllers;

import nl.scheveschilder.techiteasybackend.dtos.TelevisionDto;
import nl.scheveschilder.techiteasybackend.dtos.TelevisionInputDto;
import nl.scheveschilder.techiteasybackend.exceptions.RecordNotFoundException;
import nl.scheveschilder.techiteasybackend.models.Television;
import nl.scheveschilder.techiteasybackend.services.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionsController {


    private final TelevisionService service;

//    private final TelevisionRepository repos;

    public TelevisionsController(TelevisionService service) {
        this.service = service;
    }



    @GetMapping("/all")
    public ResponseEntity<List<Television>> getTelevisions(){
        if (service.getAllTelevision().isEmpty()) {
            throw new RecordNotFoundException("No content in the list found");
        } else {
        return ResponseEntity.ok(service.getAllTelevision());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevisionById(@PathVariable Long id) {
        return ResponseEntity.ok(TelevisionInputDto.fromTelevisionToDto(this.service.getTelevision(id)));
    }

    @PostMapping
    public ResponseEntity<String> addTelevision(@RequestBody TelevisionDto televisionDto) {
        this.service.createTelevision(televisionDto);
        return ResponseEntity.created(null).body("Television " + televisionDto.name + " created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        service.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putUpdateTelevision(@PathVariable Long id, @RequestBody TelevisionDto televisionDto) {

        return this.service.updateTelevision(id, TelevisionInputDto.fromDtoToTelevision(televisionDto));
    }

}
