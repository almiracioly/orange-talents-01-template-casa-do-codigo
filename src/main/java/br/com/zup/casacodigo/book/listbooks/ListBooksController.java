package br.com.zup.casacodigo.book.listbooks;

import br.com.zup.casacodigo.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ListBooksController {

    @Autowired
    EntityManager entityManager;

    @GetMapping("/books")
    public List<BookResponse> exec(Integer page){
        List<Book> books = entityManager.createQuery("select b from Book b").setFirstResult(page != null ? page : 0).setMaxResults(5).getResultList();
        List<BookResponse> bookListResponse = books.stream().map(BookResponse::new).collect(Collectors.toList());
        return bookListResponse;
    }
}
