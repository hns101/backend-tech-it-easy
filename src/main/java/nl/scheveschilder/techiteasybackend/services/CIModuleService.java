package nl.scheveschilder.techiteasybackend.services;

import nl.scheveschilder.techiteasybackend.dtos.CIModuleDto;
import nl.scheveschilder.techiteasybackend.dtos.CIModuleInputDto;
import nl.scheveschilder.techiteasybackend.exceptions.RecordNotFoundException;
import nl.scheveschilder.techiteasybackend.models.CIModule;
import nl.scheveschilder.techiteasybackend.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CIModuleService {

    private final CIModuleRepository repos;

    public CIModuleService(CIModuleRepository repos) {
        this.repos = repos;
    }
    
    public CIModuleDto getCIModule(Long id) {
        Optional<CIModule> CIModuleOptional = repos.findById(id);
        if (CIModuleOptional.isPresent()) {
            CIModule cim = CIModuleOptional.get();
            return fromCIModuleToDto(cim);
        } else {
            throw new RecordNotFoundException("CIModule " + id + " not found😖");
        }
    }

    public List<CIModuleDto> getAllCIModules() {
        List<CIModule> cimList = repos.findAll();
        List<CIModuleDto> cimDtoList = new ArrayList<>();

        for (CIModule cim : cimList) {
            CIModuleDto dto = fromCIModuleToDto(cim);
            cimDtoList.add(dto);
        }

        return cimDtoList;
    }


    public CIModuleDto createCIModule(CIModuleInputDto dto) {

        CIModule CIModule = fromDtoToCIModule(dto);
        repos.save(CIModule);

        return fromCIModuleToDto(CIModule);
    }

    public void deleteCIModule(@RequestBody Long id) {
        repos.deleteById(id);
    }

    public CIModuleDto updateCIModule(Long id, CIModuleInputDto cim) {

        Optional<CIModule> optionalCIModule= repos.findById(id);
        CIModule CIModuleFound = optionalCIModule.get();
        if (optionalCIModule.isPresent()) {

            if (cim.getType() != null) {
                CIModuleFound.setType(cim.getType());
            }
            if (cim.getName() != null) {
                CIModuleFound.setName(cim.getName());
            }
            if (cim.getPrice() != 0) {
                CIModuleFound.setPrice(cim.getPrice());
            }

            CIModule save = this.repos.save(CIModuleFound);

            return fromCIModuleToDto(save);

        } else {
            throw new RecordNotFoundException("This CIModule " + id + " does not exist 😭");
        }
    }


    // Mapper
    public static CIModule fromDtoToCIModule(CIModuleInputDto dto) {
        CIModule CIModule = new CIModule();

        CIModule.setType(dto.getType());
        CIModule.setName(dto.getName());
        CIModule.setPrice(dto.getPrice());

        return CIModule;
    }

    public static CIModuleDto fromCIModuleToDto(CIModule CIModule) {
        CIModuleDto CIModuleDto = new CIModuleDto();
        
        CIModuleDto.id = CIModule.getId();
        CIModuleDto.type = CIModule.getType();
        CIModuleDto.name = CIModule.getName();
        CIModuleDto.price = CIModule.getPrice();

        return CIModuleDto;
    }


}
