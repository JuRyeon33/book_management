package com.julyun.book_management.repository;

import com.julyun.book_management.model.Author;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AuthorRepository {
    private final Map<Integer, Author> store = new LinkedHashMap<>();
    private final AtomicInteger seq = new AtomicInteger(0);

    public List<Author> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Author> findById(Integer id) { // Optional을 사용한 이유는 없을 경우 에러처리를 하기 위해
        return Optional.ofNullable(store.get(id));
    }

    public Author save(Author author) {
        if (author.getId() == null) {
            author.setId(seq.incrementAndGet());
        }
        store.put(author.getId(), author);

        return author;
    }


    public void delete(Integer id) {
        store.remove(id);
    }

}
