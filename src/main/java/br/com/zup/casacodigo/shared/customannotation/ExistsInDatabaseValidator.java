package br.com.zup.casacodigo.shared.customannotation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsInDatabaseValidator implements ConstraintValidator<ExistsInDatabase, Object> {
    private Class<?> aClass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ExistsInDatabase params) {
        aClass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Object foundObject = entityManager.find(aClass, value);
        return foundObject != null;
    }
}
