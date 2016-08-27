package com.graywolf.cucumber.services;

import com.graywolf.cucumber.persistance.Book;
import com.graywolf.cucumber.persistance.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by graywolf on 8/7/16.
 */
@Service
public class BookService {

    @Autowired
    public BookRepository bookRepository;

    public List<Book> searchByAuthorAndYear(String author, int year) {
        return bookRepository.getList().stream().filter(book ->
                book.getAuthor().equals(author) && book.getYear() == year
        ).collect(Collectors.toList());
    }

}
