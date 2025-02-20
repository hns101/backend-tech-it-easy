package nl.scheveschilder.techiteasybackend.services;

import nl.scheveschilder.techiteasybackend.dtos.TelevisionDto;
import nl.scheveschilder.techiteasybackend.dtos.TelevisionInputDto;
import nl.scheveschilder.techiteasybackend.exceptions.RecordNotFoundException;
import nl.scheveschilder.techiteasybackend.models.Television;
import nl.scheveschilder.techiteasybackend.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }

    public Television getTelevision(Long id) {
        return this.repos.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found😖"));
    }

    public List<Television> getAllTelevision() {
        return this.repos.findAll();
    }


    public void createTelevision(TelevisionDto televisionDto) {
        Television television = TelevisionInputDto.fromDtoToTelevision(televisionDto);
        this.repos.save(television);
    }

    public void deleteTelevision(Long id) {
        this.repos.deleteById(id);
    }

    public ResponseEntity<String> updateTelevision(Long id, Television tv) {

        Optional<Television> optionalTelevision= this.repos.findById(id);
        Television televisionFound = optionalTelevision.get();
        if (optionalTelevision.isPresent()) {

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
            Television save = this.repos.save(televisionFound);

        } else {
            throw new RecordNotFoundException("This television " + id + " does not exist 😭");
        }
        return ResponseEntity.ok("Television " +  televisionFound.getName() + " Updated on Id" + id);
    }

}





