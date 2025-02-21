package nl.scheveschilder.techiteasybackend.dtos;

import jakarta.validation.constraints.NotBlank;

public class TelevisionDto {

    public Long id;

    @NotBlank
    public String type;

    @NotBlank
    public String brand;

    @NotBlank
    public String name;

    public double price;
    public double availableSize;
    public int refreshRate;
    public String screenType;
    public String screenQuality;
    public boolean smartTV;
    public boolean wifi;
    public boolean voiceControl;
    public boolean hdr;
    public boolean bluetooth;
    public boolean ambiLight;
    public int originalStock;
    public int sold;


}
