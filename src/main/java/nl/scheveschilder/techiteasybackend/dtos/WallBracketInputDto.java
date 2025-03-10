package nl.scheveschilder.techiteasybackend.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class WallBracketInputDto {

    @Size(max = 20, message = "Name must be between 0-20 characters")
    private String name;
    @NotNull(message = "size is required")
    private String size;
    @Positive(message = "Price must be higher than zero")
    private Double price;

    private Boolean adjustable ;

    public @Size(max = 20, message = "Name must be between 0-20 characters") String getName() {
        return name;
    }

    public void setName(@Size(max = 20, message = "Name must be between 0-20 characters") String name) {
        this.name = name;
    }

    public @NotNull(message = "size is required") String getSize() {
        return size;
    }

    public void setSize(@NotNull(message = "size is required") String size) {
        this.size = size;
    }

    public @Positive(message = "Price must be higher than zero") Double getPrice() {
        return price;
    }

    public void setPrice(@Positive(message = "Price must be higher than zero") Double price) {
        this.price = price;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }
}
