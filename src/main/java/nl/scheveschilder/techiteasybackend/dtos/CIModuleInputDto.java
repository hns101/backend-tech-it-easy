package nl.scheveschilder.techiteasybackend.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class CIModuleInputDto {

    @Size(max = 20, message = "Name must be between 0-20 characters")
    private String name;
    @NotNull(message = "type is required")
    private String type;
    @Positive(message = "Price must be higher than zero")
    private Double price;

    public @Size(max = 20, message = "Name must be between 0-20 characters") String getName() {
        return name;
    }

    public void setName(@Size(max = 20, message = "Name must be between 0-20 characters") String name) {
        this.name = name;
    }

    public @NotNull(message = "type is required") String getType() {
        return type;
    }

    public void setType(@NotNull(message = "type is required") String type) {
        this.type = type;
    }

    public @Positive(message = "Price must be higher than zero") Double getPrice() {
        return price;
    }

    public void setPrice(@Positive(message = "Price must be higher than zero") Double price) {
        this.price = price;
    }
}
