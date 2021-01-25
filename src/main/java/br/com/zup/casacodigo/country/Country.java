package br.com.zup.casacodigo.country;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(unique = true, nullable = false) private String name;

    @Deprecated
    public Country(){}

    public Country(String name) {
        this.name = name;
    }
}
