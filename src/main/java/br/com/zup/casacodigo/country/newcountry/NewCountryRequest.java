package br.com.zup.casacodigo.country.newcountry;

import br.com.zup.casacodigo.country.Country;
import br.com.zup.casacodigo.shared.customannotation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NewCountryRequest {
    @NotBlank
    @UniqueValue(domainClass = Country.class, fieldName = "name", message = "Este país já está cadastrado")
    private String name;

    public Country toModel() {
        return new Country(name);
    }

    public String getName() {
        return name;
    }
}
