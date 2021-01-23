package br.com.zup.casacodigo.book.newbook;

import br.com.zup.casacodigo.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NewBookController {

    @Autowired
    EntityManager entityManager;

    @PostMapping("/books")
    @Transactional
    public ResponseEntity<?> exec(@RequestBody @Valid NewBookRequest request){
        Book book = request.toModel(entityManager);
        entityManager.persist(book);

        return ResponseEntity.ok().build();
    }
}
