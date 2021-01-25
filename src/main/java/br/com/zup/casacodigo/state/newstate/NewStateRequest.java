package br.com.zup.casacodigo.state.newstate;

import br.com.zup.casacodigo.country.Country;
import br.com.zup.casacodigo.shared.customannotation.ExistsInDatabase;
import br.com.zup.casacodigo.shared.customannotation.UniqueValue;
import br.com.zup.casacodigo.state.State;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NewStateRequest {
    @NotBlank
    @UniqueValue(domainClass = State.class, fieldName = "name", message = "Este Estado já está cadastrado")
    private String name;

    // TODO: Impedir a checagem de existência no banco caso o parâmetro seja nulo
    @NotNull
    @ExistsInDatabase(domainClass = Country.class, message = "Informe um País existente em nossos registros")
    private Long countryId;

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public State toModel(EntityManager entityManager) {
        Country country = entityManager.find(Country.class, countryId);
        return new State(name, country);
    }
}
