package nl.scheveschilder.techiteasybackend.dtos;

import nl.scheveschilder.techiteasybackend.models.Television;

public class TelevisionInputDto {
    public static Television fromDtoToTelevision(TelevisionDto televisionDto) {
        Television television = new Television();
        television.setId(televisionDto.id);
        television.setType(televisionDto.type);
        television.setBrand(televisionDto.brand);
        television.setName(televisionDto.name);
        television.setPrice(televisionDto.price);
        television.setAvailableSize(televisionDto.availableSize);
        television.setRefreshRate(televisionDto.refreshRate);
        television.setScreenType(televisionDto.screenType);
        television.setScreenQuality(televisionDto.screenQuality);
        television.setSmartTV(televisionDto.smartTV);
        television.setWifi(televisionDto.wifi);
        television.setVoiceControl(televisionDto.voiceControl);
        television.setHdr(televisionDto.hdr);
        television.setBluetooth(televisionDto.bluetooth);
        television.setAmbiLight(televisionDto.ambiLight);
        television.setOriginalStock(televisionDto.originalStock);
        television.setSold(televisionDto.sold);
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
