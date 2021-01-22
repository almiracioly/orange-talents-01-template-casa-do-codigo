package br.com.zup.casacodigo.shared.customannotation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {
    private String domainAttribute;
    private Class<?> aClass;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void initialize(UniqueValue params){
        domainAttribute = params.fieldName();
        aClass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select 1 from "+ aClass.getName() + " where " + domainAttribute + " = :parameter");
        query.setParameter("parameter", value);
        List<?> list = query.getResultList();

        return list.isEmpty();
    }
}
