package com.graywolf.cucumber.services;

import com.graywolf.cucumber.persistance.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by graywolf on 8/7/16.
 */
@Service
public class BookService {

    public List<Book> searchByAuthorAndYear(String author, int year){
        return Arrays.asList("name1", "name2").stream().map(
                name -> new Book(name, author, year)
        ).collect(Collectors.toList());
    }

}
