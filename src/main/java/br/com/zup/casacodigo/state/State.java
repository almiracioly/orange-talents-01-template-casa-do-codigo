package br.com.zup.casacodigo.state;

import br.com.zup.casacodigo.country.Country;

import javax.persistence.*;

@Entity
@Table(name = "states")
public class State {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(unique = true, nullable = false) private String name;
    @ManyToOne
    private Country country;

    @Deprecated
    public State() {
    }

    public State(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }
}
