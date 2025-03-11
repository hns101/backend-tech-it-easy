package nl.scheveschilder.techiteasybackend.services;

import nl.scheveschilder.techiteasybackend.dtos.WallBracketDto;
import nl.scheveschilder.techiteasybackend.dtos.WallBracketInputDto;
import nl.scheveschilder.techiteasybackend.exceptions.RecordNotFoundException;
import nl.scheveschilder.techiteasybackend.models.WallBracket;
import nl.scheveschilder.techiteasybackend.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private final WallBracketRepository repos;

    public WallBracketService(WallBracketRepository repos) {
        this.repos = repos;
    }
    
    public WallBracketDto getWallBracket(Long id) {
        Optional<WallBracket> WallBracketOptional = repos.findById(id);
        if (WallBracketOptional.isPresent()) {
            WallBracket wb = WallBracketOptional.get();
            return fromWallBracketToDto(wb);
        } else {
            throw new RecordNotFoundException("WallBracket " + id + " not found😖");
        }
    }

    public List<WallBracketDto> getAllWallBrackets() {
        List<WallBracket> wbList = repos.findAll();
        List<WallBracketDto> wbDtoList = new ArrayList<>();

        for (WallBracket wb : wbList) {
            WallBracketDto dto = fromWallBracketToDto(wb);
            wbDtoList.add(dto);
        }

        return wbDtoList;
    }


    public WallBracketDto createWallBracket(WallBracketInputDto dto) {

        WallBracket WallBracket = fromDtoToWallBracket(dto);
        repos.save(WallBracket);

        return fromWallBracketToDto(WallBracket);
    }

    public void deleteWallBracket(@RequestBody Long id) {
        repos.deleteById(id);
    }

    public WallBracketDto updateWallBracket(Long id, WallBracketInputDto wb) {

        Optional<WallBracket> optionalWallBracket= repos.findById(id);
        WallBracket WallBracketFound = optionalWallBracket.get();
        if (optionalWallBracket.isPresent()) {

            if (wb.getSize() != null) {
                WallBracketFound.setSize(wb.getSize());
            }
            if (wb.getName() != null) {
                WallBracketFound.setName(wb.getName());
            }
            if (wb.getPrice() != 0) {
                WallBracketFound.setPrice(wb.getPrice());
            }
            if (wb.getAdjustable()) {
                WallBracketFound.setAdjustable(wb.getAdjustable());
            }


            WallBracket save = this.repos.save(WallBracketFound);

            return fromWallBracketToDto(save);

        } else {
            throw new RecordNotFoundException("This WallBracket " + id + " does not exist 😭");
        }
    }


    // Mapper
    public static WallBracket fromDtoToWallBracket(WallBracketInputDto dto) {
        WallBracket WallBracket = new WallBracket();

        WallBracket.setSize(dto.getSize());
        WallBracket.setName(dto.getName());
        WallBracket.setPrice(dto.getPrice());
        WallBracket.setAdjustable(dto.getAdjustable());

        return WallBracket;
    }

    public static WallBracketDto fromWallBracketToDto(WallBracket WallBracket) {
        WallBracketDto WallBracketDto = new WallBracketDto();
        
        WallBracketDto.id = WallBracket.getId();
        WallBracketDto.size = WallBracket.getSize();
        WallBracketDto.name = WallBracket.getName();
        WallBracketDto.price = WallBracket.getPrice();
        WallBracketDto.adjustable = WallBracket.getAdjustable();

        return WallBracketDto;
    }


}
