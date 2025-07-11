package com.julyun.book_management.controller;

import com.julyun.book_management.model.Author;
import com.julyun.book_management.service.AuthorService;
import com.julyun.book_management.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DashboardController {
    private final AuthorService authorService;
    private final BookService bookService;

    @GetMapping("/api/dashboard/authors")
    public Map<Author, Long> countByAuthor() {
        return authorService.getAll().stream()
                .collect(
                        Collectors.toMap(
                                author -> author,
                                author -> bookService.getAll().stream()
                                        .filter(book -> book.getAuthorId().equals(author.getId()))
                                        .count()
                        )
                );
    }
}
