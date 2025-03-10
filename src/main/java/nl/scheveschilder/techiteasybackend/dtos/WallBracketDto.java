package nl.scheveschilder.techiteasybackend.dtos;

import jakarta.validation.constraints.NotBlank;

public class WallBracketDto {
    public Long id;

    @NotBlank
    public String name;

    @NotBlank
    public String size;

    public Double price;

    public Boolean adjustable ;

}
