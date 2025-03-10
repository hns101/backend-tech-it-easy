package nl.scheveschilder.techiteasybackend.services;

import nl.scheveschilder.techiteasybackend.dtos.TelevisionDto;
import nl.scheveschilder.techiteasybackend.dtos.WallBracketDto;
import nl.scheveschilder.techiteasybackend.exceptions.RecordNotFoundException;
import nl.scheveschilder.techiteasybackend.models.Television;
import nl.scheveschilder.techiteasybackend.models.WallBracket;
import nl.scheveschilder.techiteasybackend.repositories.TelevisionRepository;
import nl.scheveschilder.techiteasybackend.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
public class TelevisionWallBracketService{

    private TelevisionRepository televisionRepository;

    private WallBracketRepository wallBracketRepository;

    public TelevisionWallBracketService(TelevisionRepository televisionRepository, WallBracketRepository wallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.wallBracketRepository = wallBracketRepository;
    }

    public Collection<TelevisionDto> getTelevisionsByWallBracketId(Long wallBracketId) {
        Collection<TelevisionDto> dtos = new HashSet<>();
        WallBracket wallbracket = wallBracketRepository.findById(wallBracketId).orElseThrow(()->{throw new RecordNotFoundException("Did not find the wallbracket");});
        for (Television television : wallbracket.getTelevisions()) {
            TelevisionDto televisionDto = new TelevisionDto();

            televisionDto.id = television.getId();
            televisionDto.type = television.getType();
            televisionDto.brand = television.getBrand();
            televisionDto.name = television.getName();
            televisionDto.price = television.getPrice();
            televisionDto.availableSize = television.getAvailableSize();
            televisionDto.refreshRate = television.getRefreshRate();
            televisionDto.screenType = television.getScreenType();
            televisionDto.screenQuality = television.getScreenQuality();
            televisionDto.smartTV = television.isSmartTV();
            televisionDto.wifi = television.isWifi();
            televisionDto.voiceControl = television.isVoiceControl();
            televisionDto.hdr = television.isHdr();
            televisionDto.bluetooth = television.isBluetooth();
            televisionDto.ambiLight = television.isAmbiLight();
            televisionDto.originalStock = television.getOriginalStock();
            televisionDto.sold = television.getSold();

            dtos.add(televisionDto);
        }
        return dtos;
    }

    public Collection<WallBracketDto> getWallBracketsByTelevisionId(Long televisionId) {
        List<WallBracketDto> dtos = new ArrayList<>();
        Television television  = televisionRepository.findById(televisionId).orElseThrow(()->{throw new RecordNotFoundException("No Tv found");});
        for (WallBracket wallBracket : television.getWallBrackets()) {
            var dto = new WallBracketDto();

            dto.id = wallBracket.getId();
            dto.name = wallBracket.getName();
            dto.size = wallBracket.getSize();
            dto.adjustable = wallBracket.getAdjustable();
            dto.price = wallBracket.getPrice();

            dtos.add(dto);
        }
        return dtos;
    }


    public Long addTelevisionWallBracket(Long televisionId, Long wallBracketId) {
        Television television = televisionRepository.findById(televisionId).orElseThrow(()->{throw new RecordNotFoundException("TV Not Found");});
        WallBracket wallBracket = wallBracketRepository.findById(wallBracketId).orElseThrow(()->{throw new RecordNotFoundException("WallBracket not found");});
        wallBracket.getTelevisions().add(television);
        return wallBracketRepository.save(wallBracket).getId();
    }
}