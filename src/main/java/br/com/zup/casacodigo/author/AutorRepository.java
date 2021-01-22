package br.com.zup.casacodigo.author;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findByEmail(String email);
}
