package br.com.zup.casacodigo.author.newauthor;

import br.com.zup.casacodigo.author.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NewAuthorController {

    @Autowired
    private EntityManager entityManager;

    @PostMapping("/authors")
    @Transactional
    public ResponseEntity<?> exec(@RequestBody @Valid NewAuthorRequest request){
        Author author = request.toModel();
        entityManager.persist(author);

        return ResponseEntity.ok().build();
    }
}
