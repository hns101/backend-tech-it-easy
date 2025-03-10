package nl.scheveschilder.techiteasybackend.controllers;


import jakarta.validation.Valid;
import nl.scheveschilder.techiteasybackend.dtos.WallBracketDto;
import nl.scheveschilder.techiteasybackend.dtos.WallBracketInputDto;
import nl.scheveschilder.techiteasybackend.services.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {

    private final WallBracketService service;

    public WallBracketController(WallBracketService service) {

        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets(){

        List<WallBracketDto> dtos;
        dtos = service.getAllWallBrackets();

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallBracketDto> getWallBracketById(@PathVariable("id") Long id) {
        WallBracketDto WallBracket = service.getWallBracket(id);
        return ResponseEntity.ok().body(WallBracket);
    }

    @PostMapping
    public ResponseEntity<WallBracketDto> addWallBracket(@Valid @RequestBody WallBracketInputDto WallBracketInputDto) {
        WallBracketDto dto = service.createWallBracket(WallBracketInputDto);
        return ResponseEntity.created(null).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWallBracket(@PathVariable Long id) {
        service.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WallBracketDto> putUpdateWallBracket(@PathVariable Long id, @RequestBody WallBracketInputDto updateWallBracket) {
        WallBracketDto dto = service.updateWallBracket(id, updateWallBracket);
        return ResponseEntity.ok().body(dto);
    }

}
