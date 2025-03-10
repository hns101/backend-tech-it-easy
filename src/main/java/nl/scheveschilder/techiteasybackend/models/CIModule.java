package nl.scheveschilder.techiteasybackend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cimodules")
public class CIModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private Double price;

}

