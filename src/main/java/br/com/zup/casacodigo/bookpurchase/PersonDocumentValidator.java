package br.com.zup.casacodigo.bookpurchase;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PersonDocumentValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return NewBookPurchaseRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object genericObject, Errors errors) {
        if (errors.hasErrors()) return ;

        NewBookPurchaseRequest request = (NewBookPurchaseRequest) genericObject;
        if(!request.isDocumentValid()) {
            errors.rejectValue("personalDocument", null, "Informe um CPF ou CNPJ válido");
        }
    }
}
