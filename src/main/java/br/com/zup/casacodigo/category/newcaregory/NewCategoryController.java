package br.com.zup.casacodigo.category.newcaregory;

import br.com.zup.casacodigo.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NewCategoryController {
    @Autowired
    private EntityManager entityManager;

    @PostMapping("/categories")
    @Transactional
    public ResponseEntity<?> exec(@RequestBody @Valid NewCategoryRequest request){
        Category category = request.toModel();
        entityManager.persist(category);

        return ResponseEntity.ok().build();
    }
}
