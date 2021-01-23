package br.com.zup.casacodigo.book.newbook;

import br.com.zup.casacodigo.author.Author;
import br.com.zup.casacodigo.book.Book;
import br.com.zup.casacodigo.category.Category;
import br.com.zup.casacodigo.shared.customannotation.ExistsInDatabase;
import br.com.zup.casacodigo.shared.customannotation.UniqueValue;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NewBookRequest {
    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "title", message = "Este título já está em uso")
    private String title;

    @NotBlank
    @Size(min = 1, max = 500)
    private String resume;

    private String summary;

    @NotNull
    @Positive
    @Min(20)
    private BigDecimal price;

    @NotNull
    @Min(100)
    private int numberOfPages;

    @NotBlank
    @ISBN(type = ISBN.Type.ANY)
    @UniqueValue(domainClass = Book.class, fieldName = "isbn", message = "Este ISBN já consta em nossos registros")
    private String isbn;

    @Future
    private LocalDate futurePublishDate;

    @NotNull
    @Positive
    @ExistsInDatabase(domainClass = Category.class, message = "Informe uma Categoria de livro existente nos registros")
    private Long categoryId;

    @NotNull
    @Positive
    @ExistsInDatabase(domainClass = Author.class, message = "Informe um Autor existente nos registros")
    private Long authorId;

    public Book toModel(EntityManager manager) {
        Category category = manager.find(Category.class, categoryId);
        Author author = manager.find(Author.class, authorId);
        Book book = new Book(title, resume, summary, price, numberOfPages, isbn, category, author);

        if(futurePublishDate != null) book.setFuturePublishDate(futurePublishDate);

        return book;
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getFuturePublishDate() {
        return futurePublishDate;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getAuthorId() {
        return authorId;
    }
}
