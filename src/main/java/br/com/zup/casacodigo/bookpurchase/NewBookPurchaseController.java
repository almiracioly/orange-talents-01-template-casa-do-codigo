package br.com.zup.casacodigo.bookpurchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NewBookPurchaseController {

    @Autowired
    private StateBelongsToCountryValidator stateBelongsToCountryValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new PersonDocumentValidator(), stateBelongsToCountryValidator);
    }

    @PostMapping("/purchases")
    @Transactional
    public ResponseEntity<?> exec(@RequestBody @Valid NewBookPurchaseRequest request) {
        return ResponseEntity.ok().build();
    }
}
