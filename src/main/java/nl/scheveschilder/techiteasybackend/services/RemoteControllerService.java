package nl.scheveschilder.techiteasybackend.services;

import nl.scheveschilder.techiteasybackend.dtos.RemoteControllerDto;
import nl.scheveschilder.techiteasybackend.dtos.RemoteControllerInputDto;
import nl.scheveschilder.techiteasybackend.exceptions.RecordNotFoundException;
import nl.scheveschilder.techiteasybackend.models.RemoteController;
import nl.scheveschilder.techiteasybackend.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository repos;

    public RemoteControllerService(RemoteControllerRepository repos) {
        this.repos = repos;
    }
    
    public RemoteControllerDto getRemoteController(Long id) {
        Optional<RemoteController> RemoteControllerOptional = repos.findById(id);
        if (RemoteControllerOptional.isPresent()) {
            RemoteController rc = RemoteControllerOptional.get();
            return fromRemoteControllerToDto(rc);
        } else {
            throw new RecordNotFoundException("RemoteController " + id + " not found😖");
        }

    }

    public List<RemoteControllerDto> getAllRemoteControllers() {
        List<RemoteController> rcList = repos.findAll();
        List<RemoteControllerDto> rcDtoList = new ArrayList<>();

        for (RemoteController rc : rcList) {
            RemoteControllerDto dto = fromRemoteControllerToDto(rc);
            rcDtoList.add(dto);
        }

        return rcDtoList;
    }


    public RemoteControllerDto createRemoteController(RemoteControllerInputDto dto) {

        RemoteController RemoteController = fromDtoToRemoteController(dto);
        repos.save(RemoteController);

        return fromRemoteControllerToDto(RemoteController);
    }

    public void deleteRemoteController(@RequestBody Long id) {
        repos.deleteById(id);
    }

    public RemoteControllerDto updateRemoteController(Long id, RemoteControllerInputDto rc) {

        Optional<RemoteController> optionalRemoteController= repos.findById(id);
        RemoteController RemoteControllerFound = optionalRemoteController.get();
        if (optionalRemoteController.isPresent()) {

            if (rc.getCompatibleWith() != null) {
                RemoteControllerFound.setCompatibleWith(rc.getCompatibleWith());
            }
            if (rc.getBatteryType() != null) {
                RemoteControllerFound.setBatteryType(rc.getBatteryType());
            }
            if (rc.getBrand() != null) {
                RemoteControllerFound.setBrand(rc.getBrand());
            }
            if (rc.getName() != null) {
                RemoteControllerFound.setName(rc.getName());
            }
            if (rc.getPrice() != 0) {
                RemoteControllerFound.setPrice(rc.getPrice());
            }
            if (rc.getOriginalStock() != 0) {
                RemoteControllerFound.setOriginalStock(rc.getOriginalStock());
            }
            RemoteController save = this.repos.save(RemoteControllerFound);

            return fromRemoteControllerToDto(save);

        } else {
            throw new RecordNotFoundException("This RemoteController " + id + " does not exist 😭");
        }
    }


    // Mapper
    public static RemoteController fromDtoToRemoteController(RemoteControllerInputDto dto) {
        RemoteController RemoteController = new RemoteController();

        RemoteController.setBatteryType(dto.getBatteryType());
        RemoteController.setBrand(dto.getBrand());
        RemoteController.setName(dto.getName());
        RemoteController.setPrice(dto.getPrice());
        RemoteController.setCompatibleWith(dto.getCompatibleWith());
        RemoteController.setBatteryType(dto.getBatteryType());
        RemoteController.setOriginalStock(dto.getOriginalStock());
        return RemoteController;
    }

    public static RemoteControllerDto fromRemoteControllerToDto(RemoteController RemoteController) {
        RemoteControllerDto RemoteControllerDto = new RemoteControllerDto();

        RemoteControllerDto.id = RemoteController.getId();
        RemoteControllerDto.batteryType = RemoteController.getBatteryType();
        RemoteControllerDto.brand = RemoteController.getBrand();
        RemoteControllerDto.name = RemoteController.getName();
        RemoteControllerDto.price = RemoteController.getPrice();
        RemoteControllerDto.compatibleWith = RemoteController.getCompatibleWith();
        RemoteControllerDto.originalStock = RemoteController.getOriginalStock();
        return RemoteControllerDto;
    }


}
