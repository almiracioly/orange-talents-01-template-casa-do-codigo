package br.com.zup.casacodigo.category.newcaregory;

import br.com.zup.casacodigo.category.Category;
import br.com.zup.casacodigo.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoryNameAlreadyExistsValidator implements Validator {

    private CategoryRepository categoryRepository;

    public CategoryNameAlreadyExistsValidator(@Autowired CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NewCategoryRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object genericObject, Errors errors) {
        if(errors.hasErrors()) return;

        NewCategoryRequest request = (NewCategoryRequest) genericObject;
        Optional<Category> foundCategory = categoryRepository.findByName(request.getName());
        if(foundCategory.isPresent()){
            errors.rejectValue("name", null, "Esta categoria já existe");
        }
    }
}
