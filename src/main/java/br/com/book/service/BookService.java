package br.com.book.service;

import br.com.book.dto.BookDTO;
import br.com.book.dto.MessageResponseDTO;
import br.com.book.entity.Book;
import br.com.book.mapper.BookMapper;
import br.com.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    public MessageResponseDTO create(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO);
        Book saveBook = bookRepository.save(bookToSave);

        return MessageResponseDTO.builder()
                .message("Book created with ID " + saveBook.getId())
                .build();
    }

    public BookDTO findById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return bookMapper.toDTO(optionalBook.get());
    }
}
