package br.com.zup.casacodigo.author.newauthor;

import br.com.zup.casacodigo.author.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewAuthorRequest {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 1, max = 400)
    private String description;

    public Author toModel() {
        return new Author(name, email, description);
    }

    public NewAuthorRequest(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Size(min = 1, max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }
}
