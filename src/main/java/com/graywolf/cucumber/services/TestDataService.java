package com.graywolf.cucumber.services;

import com.graywolf.cucumber.persistance.Book;
import com.graywolf.cucumber.persistance.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by aprey on 25.08.2016.
 */
@Service
public class TestDataService {

    @Autowired
    private BookRepository bookRepository;

    public void buildTestData(List<String> titles, int year, String author) {
        bookRepository.clear();
        titles.stream().forEach(title -> bookRepository.save(
                new Book().builder()
                        .title(title)
                        .author(author)
                        .year(year).build()));
    }

    public void buildTestData(Map<String, String> titleAuthorMap, int year) {
        bookRepository.clear();
        titleAuthorMap.entrySet().stream().forEach(entry -> bookRepository.save(
                new Book().builder().title(entry.getKey())
                        .author(entry.getValue())
                        .year(year).build()));
    }

    public void buildTestData(List<Book> bookList) {
        bookRepository.clear();
        bookRepository.saveList(bookList);
    }
}
