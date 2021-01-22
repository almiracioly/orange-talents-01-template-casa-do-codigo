package br.com.zup.casacodigo.category;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Deprecated
    public Category(){}

    public Category(String name) {
        this.name = name;
    }
}
