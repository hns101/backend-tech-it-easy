package nl.scheveschilder.techiteasybackend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "remotecontrollers")
public class RemoteController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private Double price;
    private Integer originalStock;

}
