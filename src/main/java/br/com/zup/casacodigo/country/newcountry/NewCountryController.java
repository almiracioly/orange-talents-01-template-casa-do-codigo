package br.com.zup.casacodigo.country.newcountry;

import br.com.zup.casacodigo.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NewCountryController {

    @Autowired
    EntityManager entityManager;

    @PostMapping("/countries")
    @Transactional
    public ResponseEntity<?> exec(@RequestBody @Valid NewCountryRequest request){
        Country country = request.toModel();
        entityManager.persist(country);

        return ResponseEntity.ok().build();
    }
}
