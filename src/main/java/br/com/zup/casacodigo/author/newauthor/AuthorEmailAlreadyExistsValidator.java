package br.com.zup.casacodigo.author.newauthor;

import br.com.zup.casacodigo.author.Author;
import br.com.zup.casacodigo.author.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class AuthorEmailAlreadyExistsValidator implements Validator {

    private AutorRepository authorRepository;

    public AuthorEmailAlreadyExistsValidator(@Autowired AutorRepository authorRepository){
        this.authorRepository = authorRepository;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return NewAuthorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object genericObject, Errors errors) {
        if (errors.hasErrors()) return;

        NewAuthorRequest request = (NewAuthorRequest) genericObject;
        Optional<Author> foundAuthor = authorRepository.findByEmail(request.getEmail());
        if(foundAuthor.isPresent()){
            errors.rejectValue("email", null, "Este email já está em uso por outro Autor");
        }
    }
}
