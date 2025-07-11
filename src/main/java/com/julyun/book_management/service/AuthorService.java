package com.julyun.book_management.service;

import com.julyun.book_management.model.Author;
import com.julyun.book_management.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAll() { return authorRepository.findAll(); }

    public Author getById(Integer id) {
        return authorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("저자 없음"));
    }

    public Author create(Author author) { return authorRepository.save(author); }


    public Author update(Integer id, Author updatedAuthor) {
        getById(id);
        updatedAuthor.setId(id);

        return authorRepository.save(updatedAuthor);
    }
    public void delete(Integer id) {
        authorRepository.delete(id);
    }
}
