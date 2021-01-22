package br.com.zup.casacodigo.category.newcaregory;

import br.com.zup.casacodigo.category.Category;

import javax.validation.constraints.NotBlank;

public class NewCategoryRequest {

    @NotBlank
    private String name;

    public Category toModel(){
        return new Category(name);
    }

    public String getName() {
        return name;
    }
}
