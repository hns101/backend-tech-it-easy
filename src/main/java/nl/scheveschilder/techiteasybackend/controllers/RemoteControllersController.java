package nl.scheveschilder.techiteasybackend.controllers;


import jakarta.validation.Valid;
import nl.scheveschilder.techiteasybackend.dtos.RemoteControllerDto;
import nl.scheveschilder.techiteasybackend.dtos.RemoteControllerInputDto;
import nl.scheveschilder.techiteasybackend.services.RemoteControllerService;
import nl.scheveschilder.techiteasybackend.services.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/remotecontrollers")
public class RemoteControllersController {

    private final RemoteControllerService service;

    public RemoteControllersController(RemoteControllerService service) {

        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RemoteControllerDto>> getAllRemoteControllers(){

        List<RemoteControllerDto> dtos;
        dtos = service.getAllRemoteControllers();

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> getRemoteControllerById(@PathVariable("id") Long id) {
        RemoteControllerDto RemoteController = service.getRemoteController(id);
        return ResponseEntity.ok().body(RemoteController);
    }

    @PostMapping
    public ResponseEntity<RemoteControllerDto> addRemoteController(@Valid @RequestBody RemoteControllerInputDto RemoteControllerInputDto) {
        RemoteControllerDto dto = service.createRemoteController(RemoteControllerInputDto);
        return ResponseEntity.created(null).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRemoteController(@PathVariable Long id) {
        service.deleteRemoteController(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> putUpdateRemoteController(@PathVariable Long id, @RequestBody RemoteControllerInputDto updateRemoteController) {
        RemoteControllerDto dto = service.updateRemoteController(id, updateRemoteController);
        return ResponseEntity.ok().body(dto);
    }




}
