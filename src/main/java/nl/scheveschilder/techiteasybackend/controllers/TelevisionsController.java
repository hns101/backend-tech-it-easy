package nl.scheveschilder.techiteasybackend.controllers;

import nl.scheveschilder.techiteasybackend.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/tv")
public class TelevisionsController {

    private List<String> televisionDataBase = new ArrayList<>();

    @GetMapping("/getall")
    public ResponseEntity<List<String>> getTelevisions(){
        if (televisionDataBase.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(televisionDataBase);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevisionById(@PathVariable int id) {
        if (id == 4) {
            throw new RecordNotFoundException("Deze Televisie Id " + id + " bestaat niet 😭");
        }
        if (id == 6) {
            throw new RecordNotFoundException(id);
        }
        return ResponseEntity.ok(televisionDataBase.get(id));
    }

    @PostMapping
    public ResponseEntity<String> addTelevision(@RequestBody String tv) {
        televisionDataBase.add(tv);
        return ResponseEntity.created(null).body("Televisie " + tv + " aangemaakt");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable int id, @RequestBody String tv) {
        televisionDataBase.set(id, tv);
        return ResponseEntity.ok("Televisie " + tv + " aangepast op Id" + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable int id) {
        televisionDataBase.set(id,null);
        return ResponseEntity.noContent().build();
    }



}
