package nl.scheveschilder.techiteasybackend.dtos;

import jakarta.validation.constraints.NotBlank;

public class CIModuleDto {
    public Long id;

    @NotBlank
    public String name;

    @NotBlank
    public String type;

    public Double price;
    
}
