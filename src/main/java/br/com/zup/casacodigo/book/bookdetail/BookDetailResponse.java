package br.com.zup.casacodigo.book.bookdetail;

import br.com.zup.casacodigo.book.Book;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookDetailResponse {
    private String title;
    private String resume;
    private String summary;
    private BigDecimal price;

    private BookAuthorDetailResponse author;

    private int numberOfPages;
    private String isbn;

    private String futurePublishDate;

    public BookDetailResponse(Book book) {
        this.title = book.getTitle();
        this.resume = book.getResume();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.author = new BookAuthorDetailResponse(book.getAuthor());
        this.numberOfPages = book.getNumberOfPages();
        this.isbn = book.getIsbn();

        if(book.getFuturePublishDate() != null) {
            this.futurePublishDate = book.getFuturePublishDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
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

    public BookAuthorDetailResponse getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getFuturePublishDate() {
        return futurePublishDate;
    }
}
