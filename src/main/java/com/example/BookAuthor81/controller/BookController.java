package com.example.BookAuthor81.controller;

import com.example.BookAuthor81.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/books")
@RestController
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Конечная точка для получения всех книг Льва Толстого
    @GetMapping()
    public ResponseEntity<List<String>> getTolstoyBooks() {
        List<String> books = bookService.findBooksByAuthorName();

        if (!books.isEmpty()) {
            log.info("\nНайдены книги: {}", books); // Логируем результат
            return new ResponseEntity<>(books, HttpStatus.OK);
        } else {
            log.warn("Книги Льва Толстого не найдены."); // Предупреждение, если книг нет
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Возвращаем статус 404, если книг нет
        }
    }
}