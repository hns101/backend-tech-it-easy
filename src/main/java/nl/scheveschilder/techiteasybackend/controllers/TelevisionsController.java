package nl.scheveschilder.techiteasybackend.controllers;

import nl.scheveschilder.techiteasybackend.exceptions.RecordNotFoundException;
import nl.scheveschilder.techiteasybackend.models.Television;
import nl.scheveschilder.techiteasybackend.repositories.TelevisionRepository;
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



    private final TelevisionRepository repos;

    public TelevisionsController(TelevisionRepository repos) {
        this.repos = repos;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Television>> getTelevisions(){
        if (repos.findAll().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(repos.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable Long id) {
        Optional<Television> optionalTelevision = repos.findById(id);
        if (optionalTelevision.isPresent()) {
            return ResponseEntity.ok(optionalTelevision.get());
        } else {
            throw new RecordNotFoundException("Deze Televisie Id " + id + " bestaat niet 😭");
        }
    }

    @PostMapping
    public ResponseEntity<String> addTelevision(@RequestBody Television tv) {
        this.repos.save(tv);
        return ResponseEntity.created(null).body("Televisie " + tv.getName() + " aangemaakt op ID" + tv.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable Long id, @RequestBody Television tv) {
        Optional<Television> optionalTelevision= this.repos.findById(id);
        if (optionalTelevision.isPresent()) {
            Television televisionFound = optionalTelevision.get();
            if (tv.getName()!=null) {
                televisionFound.setName(tv.getName());
            }
            if (tv.getType() != null) {
                televisionFound.setType(tv.getType());
            }
            if (tv.getBrand() != null) {
                televisionFound.setBrand(tv.getBrand());
            }
            if (tv.getName() != null) {
                televisionFound.setName(tv.getName());
            }
            if (tv.getPrice() != 0) {
                televisionFound.setPrice(tv.getPrice());
            }
            if (tv.getAvailableSize() != 0) {
                televisionFound.setAvailableSize(tv.getAvailableSize());
            }
            if (tv.getRefreshRate() != 0) {
                televisionFound.setRefreshRate(tv.getRefreshRate());
            }
            if (tv.getScreenType() != null) {
                televisionFound.setScreenType(tv.getScreenType());
            }
            if (tv.getScreenQuality() != null) {
                televisionFound.setScreenQuality(tv.getScreenQuality());
            }
            if (tv.isSmartTV()) {
                televisionFound.setSmartTV(tv.isSmartTV());
            }
            if (tv.isWifi()) {
                televisionFound.setWifi(tv.isWifi());
            }
            if (tv.isVoiceControl()) {
                televisionFound.setVoiceControl(tv.isVoiceControl());
            }
            if (tv.isHdr()) {
                televisionFound.setHdr(tv.isHdr());
            }
            if (tv.isBluetooth()) {
                televisionFound.setBluetooth(tv.isBluetooth());
            }
            if (tv.isAmbiLight()) {
                televisionFound.setAmbiLight(tv.isAmbiLight());
            }
            if (tv.getOriginalStock() != 0) {
                televisionFound.setOriginalStock(tv.getOriginalStock());
            }
            if (tv.getSold() != 0) {
                televisionFound.setSold(tv.getSold());
            }
            repos.save(televisionFound);

        } else {
            throw new RecordNotFoundException("Deze Televisie " + id + " bestaat niet 😭");
        }
        return ResponseEntity.ok("Televisie " + tv.getName() + " aangepast op Id" + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        repos.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
