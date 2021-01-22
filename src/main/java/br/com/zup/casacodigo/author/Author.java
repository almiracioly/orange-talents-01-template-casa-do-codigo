package br.com.zup.casacodigo.author;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "authors")
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @Column(nullable = false) private String name;
    @Column(nullable = false) private String email;
    @Column(nullable = false, columnDefinition = "TEXT") private String description;
    @Column(nullable = false) private LocalDateTime createdAt =  LocalDateTime.now();

    public Author(String name, String email, String description){
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id.equals(author.id) && email.equals(author.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
