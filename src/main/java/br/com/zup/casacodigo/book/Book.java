package br.com.zup.casacodigo.book;

import br.com.zup.casacodigo.author.Author;
import br.com.zup.casacodigo.category.Category;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT", length = 500)
    private String resume;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int numberOfPages;

    @Column(nullable = false, unique = true)
    private String isbn;

    private LocalDate futurePublishDate = LocalDate.now().plusDays(30L);

    @ManyToOne
    private Category category;


    @ManyToOne
    private Author author;

    @Deprecated
    public Book() {
    }

    public Book(String title, String resume, String summary, BigDecimal price, int numberOfPages, String isbn, Category category, Author author) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.category = category;
        this.author = author;
    }

    public void setFuturePublishDate(LocalDate futurePublishDate) {
        this.futurePublishDate = futurePublishDate;
    }


    public Long getId() {
        return id;
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

    public Author getAuthor() {
        return author;
    }
}
