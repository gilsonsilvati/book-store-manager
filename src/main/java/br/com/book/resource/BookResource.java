package br.com.book.resource;

import br.com.book.dto.MessageRespondeDTO;
import br.com.book.entity.Book;
import br.com.book.repository.BookRepository;
import br.com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookResource {

    @Autowired
    private BookService bookService;

    @PostMapping
    public MessageRespondeDTO create(@RequestBody Book book) {
        return bookService.create(book);
    }

}
