package br.com.zup.casacodigo.category.newcaregory;

import br.com.zup.casacodigo.category.Category;
import br.com.zup.casacodigo.shared.customannotation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NewCategoryRequest {

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name", message = "Categoria já cadastrada")
    private String name;

    public Category toModel(){
        return new Category(name);
    }

    public String getName() {
        return name;
    }
}
