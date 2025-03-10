package nl.scheveschilder.techiteasybackend.dtos;

import jakarta.validation.constraints.NotNull;

public class IdInputDto {

    @NotNull
    public Long id;
}
