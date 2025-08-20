package com.example.BookAuthor81.repository;

import com.example.BookAuthor81.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value =
                    "SELECT b.name FROM book b " +
                    "JOIN author a ON b.author_id = a.id " +
                    "WHERE a.name = 'Лев Толстой'",
            nativeQuery = true)
    List<String> findBooksByAuthorName();
}