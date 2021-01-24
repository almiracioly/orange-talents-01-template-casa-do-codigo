package br.com.zup.casacodigo.book.listbooks;

import br.com.zup.casacodigo.book.Book;

public class BookResponse {
    private Long id;
    private String title;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


}
