package br.com.zup.casacodigo.book.bookdetail;

import br.com.zup.casacodigo.author.Author;

public class BookAuthorDetailResponse {
    private String name;
    private String description;

    public BookAuthorDetailResponse(Author author) {
        this.name = author.getName();
        this.description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
