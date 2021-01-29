package br.com.zup.casacodigo.bookpurchase;

import br.com.zup.casacodigo.country.Country;
import br.com.zup.casacodigo.state.State;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class StateBelongsToCountryValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> aClass) {
        return NewBookPurchaseRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object genericObject, Errors errors) {
        if (errors.hasErrors()) return;

        NewBookPurchaseRequest request = (NewBookPurchaseRequest) genericObject;
        Country stateCountry = entityManager.find(Country.class, request.getCountryId());
        State state = entityManager.find(State.class, request.getStateId());

        if (!state.getCountry().equals(stateCountry)) {
            errors.rejectValue("stateId", null, "O Estado informado não pertence ao país informado");
        }
    }
}
