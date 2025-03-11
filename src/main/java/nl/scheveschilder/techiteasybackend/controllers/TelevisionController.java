package nl.scheveschilder.techiteasybackend.controllers;

import jakarta.validation.Valid;
import nl.scheveschilder.techiteasybackend.dtos.TelevisionDto;
import nl.scheveschilder.techiteasybackend.dtos.TelevisionInputDto;
import nl.scheveschilder.techiteasybackend.dtos.WallBracketDto;
import nl.scheveschilder.techiteasybackend.services.TelevisionService;
import nl.scheveschilder.techiteasybackend.services.TelevisionWallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService service;

    private final TelevisionWallBracketService televisionWallBracketService;

    public TelevisionController(TelevisionService service,
                                TelevisionWallBracketService televisionWallBracketService){
        this.service = service;
        this.televisionWallBracketService = televisionWallBracketService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions(@RequestParam(value = "brand", required = false) Optional<String> brand){

        List<TelevisionDto> dtos;

        if (brand.isEmpty()){
            dtos = service.getAllTelevisions();
        } else {
            dtos = service.getAllTelevisionsByBrand(brand.get());
        }
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevisionById(@PathVariable("id") Long id) {
        TelevisionDto television = service.getTelevision(id);
        return ResponseEntity.ok().body(television);
    }

    @PostMapping
    public ResponseEntity<TelevisionDto> addTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionDto dto = service.createTelevision(televisionInputDto);
        return ResponseEntity.created(null).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        service.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> putUpdateTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto updateTelevision) {
        TelevisionDto dto = service.updateTelevision(id, updateTelevision);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/televisions/{id}/remotecontroller/{remoteId}")
    public void assignRemoteControllerToTelevision(@PathVariable("id") Long id,@PathVariable Long remoteId) {
        service.assignRemoteControllerToTelevision(id, remoteId);
    }

    @PutMapping("/televisions/{id}/cimodule/{ciModuleId}")
    public void assignCIModuleToTelevision(@PathVariable("id") Long id, @PathVariable("ciModuleId") Long ciModuleId) {
        service.assignCIModuleToTelevision(id, ciModuleId);
    }


    @PutMapping("/televisions/{id}/wallbracket/{wbid}")
    public void assignWallBracketToTelevision(@PathVariable("id") Long id,@PathVariable Long wbid){

    }

    @GetMapping("/televisions/{televisionId}/wallBrackets")
    public Collection<WallBracketDto> getWallBracketsByTelevisionId(@PathVariable("televisionId") Long televisionId){
        return televisionWallBracketService.getWallBracketsByTelevisionId(televisionId);
    }



}
