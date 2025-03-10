package nl.scheveschilder.techiteasybackend.dtos;

import jakarta.validation.constraints.NotBlank;

public class RemoteControllerDto {

    public Long id;

    public String compatibleWith;
    public String batteryType;

    @NotBlank
    public String name;

    @NotBlank
    public String brand;

    public Double price;
    public Integer originalStock;
    
}
