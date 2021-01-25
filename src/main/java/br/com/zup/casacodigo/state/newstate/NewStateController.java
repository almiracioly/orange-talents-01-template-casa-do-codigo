package br.com.zup.casacodigo.state.newstate;

import br.com.zup.casacodigo.state.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NewStateController {

    @Autowired
    private EntityManager entityManager;

    @PostMapping("/states")
    @Transactional
    public ResponseEntity<?> exec(@RequestBody @Valid NewStateRequest request){
        State state = request.toModel(entityManager);
        entityManager.persist(state);

        return ResponseEntity.ok().build();
    }
}
