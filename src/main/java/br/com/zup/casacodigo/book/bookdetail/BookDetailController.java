package br.com.zup.casacodigo.book.bookdetail;

import br.com.zup.casacodigo.book.Book;
import javassist.ByteArrayClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
public class BookDetailController {

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/books/{id}")
    public ResponseEntity<?> exec(@PathVariable Long id){
        Book foundBook = entityManager.find(Book.class, id);
        if(foundBook == null) return ResponseEntity.notFound().build();

        BookDetailResponse bookDetail = new BookDetailResponse(foundBook);

        return ResponseEntity.ok(bookDetail);
    }
}
