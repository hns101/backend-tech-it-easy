package nl.scheveschilder.techiteasybackend.controllers;


import jakarta.validation.Valid;
import nl.scheveschilder.techiteasybackend.dtos.CIModuleDto;
import nl.scheveschilder.techiteasybackend.dtos.CIModuleInputDto;
import nl.scheveschilder.techiteasybackend.services.CIModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cimodules")
public class CIModuleController {

    private final CIModuleService service;

    public CIModuleController(CIModuleService service) {

        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CIModuleDto>> getAllCIModules(){

        List<CIModuleDto> dtos;
        dtos = service.getAllCIModules();

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CIModuleDto> getCIModuleById(@PathVariable("id") Long id) {
        CIModuleDto CIModule = service.getCIModule(id);
        return ResponseEntity.ok().body(CIModule);
    }

    @PostMapping
    public ResponseEntity<CIModuleDto> addCIModule(@Valid @RequestBody CIModuleInputDto CIModuleInputDto) {
        CIModuleDto dto = service.createCIModule(CIModuleInputDto);
        return ResponseEntity.created(null).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCIModule(@PathVariable Long id) {
        service.deleteCIModule(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CIModuleDto> putUpdateCIModule(@PathVariable Long id, @RequestBody CIModuleInputDto updateCIModule) {
        CIModuleDto dto = service.updateCIModule(id, updateCIModule);
        return ResponseEntity.ok().body(dto);
    }

}
