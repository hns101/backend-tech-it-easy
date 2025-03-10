package nl.scheveschilder.techiteasybackend.services;

import nl.scheveschilder.techiteasybackend.dtos.TelevisionDto;
import nl.scheveschilder.techiteasybackend.dtos.TelevisionInputDto;
import nl.scheveschilder.techiteasybackend.exceptions.RecordNotFoundException;
import nl.scheveschilder.techiteasybackend.models.Television;
import nl.scheveschilder.techiteasybackend.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

//    @Autowired
    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }


    public TelevisionDto getTelevision(Long id) {
        Optional<Television> televisionOptional = repos.findById(id);
        if (televisionOptional.isPresent()) {
            Television tv = televisionOptional.get();
            return fromTelevisionToDto(tv);
        } else {
            throw new RecordNotFoundException("Television " + id + " not found😖");
        }

    }

    public List<TelevisionDto> getAllTelevisions() {
        List<Television> tvList = repos.findAll();
        List<TelevisionDto> tvDtoList = new ArrayList<>();

        for (Television tv : tvList) {
            TelevisionDto dto = fromTelevisionToDto(tv);
            tvDtoList.add(dto);
        }

        return tvDtoList;
    }

    public List<TelevisionDto> getAllTelevisionsByBrand(String brand) {
        List<Television> tvList = repos.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
        List<TelevisionDto> tvDtoList = new ArrayList<>();

        for (Television tv : tvList) {
            TelevisionDto dto = fromTelevisionToDto(tv);
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }


    public TelevisionDto createTelevision(TelevisionInputDto dto) {

        Television television = fromDtoToTelevision(dto);
        repos.save(television);

        return fromTelevisionToDto(television);
    }

    public void deleteTelevision(@RequestBody Long id) {
        repos.deleteById(id);
    }

    public TelevisionDto updateTelevision(Long id, TelevisionInputDto tv) {

        Optional<Television> optionalTelevision= repos.findById(id);
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
            if (tv.getSmartTv()) {
                televisionFound.setSmartTV(tv.getSmartTv());
            }
            if (tv.getWifi()) {
                televisionFound.setWifi(tv.getWifi());
            }
            if (tv.getVoiceControl()) {
                televisionFound.setVoiceControl(tv.getVoiceControl());
            }
            if (tv.getHdr()) {
                televisionFound.setHdr(tv.getHdr());
            }
            if (tv.getBluetooth()) {
                televisionFound.setBluetooth(tv.getBluetooth());
            }
            if (tv.getAmbiLight()) {
                televisionFound.setAmbiLight(tv.getAmbiLight());
            }
            if (tv.getOriginalStock() != 0) {
                televisionFound.setOriginalStock(tv.getOriginalStock());
            }
            if (tv.getSold() != 0) {
                televisionFound.setSold(tv.getSold());
            }
            Television save = this.repos.save(televisionFound);

            return fromTelevisionToDto(save);

        } else {
            throw new RecordNotFoundException("This television " + id + " does not exist 😭");
        }
    }


    // Mapper
    public static Television fromDtoToTelevision(TelevisionInputDto dto) {
        Television television = new Television();

        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTV(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());
        return television;
    }

    public static TelevisionDto fromTelevisionToDto(Television television) {
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
        return televisionDto;
    }



}





