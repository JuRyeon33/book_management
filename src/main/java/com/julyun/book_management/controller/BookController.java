package com.julyun.book_management.controller;

import com.julyun.book_management.dto.AuthorDto;
import com.julyun.book_management.dto.BookDto;
import com.julyun.book_management.model.Book;
import com.julyun.book_management.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> list() {
        return bookService.getAll();
    }
    @GetMapping("/{id}")
    public Book get(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @PostMapping
    public Book create(@Valid @RequestBody BookDto bookdto) {
        Book book = new Book();
        book.setTitle(bookdto.getTitle());
        book.setAuthorId(bookdto.getAuthorId());

        return bookService.create(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Integer id, @Valid @RequestBody BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthorId(bookDto.getAuthorId());

        return bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bookService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
