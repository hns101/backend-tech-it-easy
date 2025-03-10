package nl.scheveschilder.techiteasybackend.dtos;

import jakarta.validation.constraints.*;

public class RemoteControllerInputDto {

    @NotNull(message = "Compatible with is required")
    private String compatibleWith;
    @NotNull(message = "BatteryTypeis required")
    private String batteryType;
    @Size(max = 20, message = "Name must be between 0-20 characters")
    private String name;
    @NotNull(message = "Brand is required")
    private String brand;
    @Positive(message = "Price must be higher than zero")
    private Double price;
    @PositiveOrZero(message = "RemoteController cannot have negative stock")
    private Integer originalStock;

    public @NotNull(message = "Compatible with is required") String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(@NotNull(message = "Compatible with is required") String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public @NotNull(message = "BatteryTypeis required") String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(@NotNull(message = "BatteryTypeis required") String batteryType) {
        this.batteryType = batteryType;
    }

    public @Size(max = 20, message = "Name must be between 0-20 characters") String getName() {
        return name;
    }

    public void setName(@Size(max = 20, message = "Name must be between 0-20 characters") String name) {
        this.name = name;
    }

    public @NotNull(message = "Brand is required") String getBrand() {
        return brand;
    }

    public void setBrand(@NotNull(message = "Brand is required") String brand) {
        this.brand = brand;
    }

    public @Positive(message = "Price must be higher than zero") Double getPrice() {
        return price;
    }

    public void setPrice(@Positive(message = "Price must be higher than zero") Double price) {
        this.price = price;
    }

    public @PositiveOrZero(message = "RemoteController cannot have negative stock") Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(@PositiveOrZero(message = "RemoteController cannot have negative stock") Integer originalStock) {
        this.originalStock = originalStock;
    }
}
