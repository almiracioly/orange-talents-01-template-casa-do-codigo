package br.com.zup.casacodigo.bookpurchase;

import br.com.zup.casacodigo.country.Country;
import br.com.zup.casacodigo.shared.customannotation.ExistsInDatabase;
import br.com.zup.casacodigo.state.State;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewBookPurchaseRequest {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String personalDocument;

    @NotBlank
    private String address;

    @NotBlank
    private String extraAddressInfo;

    @NotBlank
    private String city;

    @ExistsInDatabase(domainClass = Country.class, message = "Informe um País cadastrado em nossos registros")
    private Long countryId;

    @ExistsInDatabase(domainClass = State.class, message = "Informe um Estado cadastrado em nossos registros")
    private Long stateId;

    @NotBlank
    private String phone;

    @NotBlank
    @Size(max = 9)
    private String zipCode;


    public boolean isDocumentValid() {
        if(personalDocument.isEmpty()) throw new IllegalCallerException("Não é possível validar um documento vazio");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(personalDocument, null) || cnpjValidator.isValid(personalDocument, null);
    }

    public NewBookPurchaseRequest(@NotBlank @Email String email, @NotBlank String name, @NotBlank String surname, @NotBlank String personalDocument, @NotBlank String address, @NotBlank String extraAddressInfo, @NotBlank String city, Long countryId, Long stateId, @NotBlank String phone, @NotBlank @Size(max = 9) String zipCode) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.personalDocument = personalDocument;
        this.address = address;
        this.extraAddressInfo = extraAddressInfo;
        this.city = city;
        this.countryId = countryId;
        this.stateId = stateId;
        this.phone = phone;
        this.zipCode = zipCode;
    }

    public String getPersonalDocument() {
        return personalDocument;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }
}
