package com.example.BookAuthor81.service;

import com.example.BookAuthor81.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<String> findBooksByAuthorName() {
        try {
            return bookRepository.findBooksByAuthorName();
        } catch (Exception e) {
            logger.error("Ошибка при получении списка книг:", e);
            throw new RuntimeException(e);
        }
    }
}