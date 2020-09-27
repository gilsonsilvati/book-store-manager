package br.com.book.service;

import br.com.book.dto.MessageRespondeDTO;
import br.com.book.entity.Book;
import br.com.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public MessageRespondeDTO create(Book book) {
        Book saveBook = bookRepository.save(book);

        return MessageRespondeDTO.builder()
                .message("Book created with ID: " + saveBook.getId())
                .build();
    }

}
