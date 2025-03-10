package nl.scheveschilder.techiteasybackend.models;

import jakarta.persistence.*;


@Entity
@Table(name = "wallBrackets")
public class WallBracket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String size;
    private Boolean adjustable ;
    private String name;
    private Double price;

    private Integer originalStock;


}
