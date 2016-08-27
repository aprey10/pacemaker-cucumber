package com.graywolf.cucumber.integration;

import com.graywolf.cucumber.Application;
import com.graywolf.cucumber.persistance.Book;
import com.graywolf.cucumber.services.BookService;
import com.graywolf.cucumber.services.TestDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by graywolf on 8/27/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
public class SimpleIntegrationTest {

    @Autowired
    TestDataService testDataService;

    @Autowired
    BookService bookService;

    @Test
    public void testBookSearch() {

        //Given: we have two books with titles title1 and title2 that were written by John Doe and published at 1990
        String author = "John Doe";
        int year = 1990;
        List<String> bookTitles = Arrays.asList("title1", "title2");
        testDataService.buildTestData(bookTitles, year, author);

        //When: search by author John Doe and year 1990
        List<Book> bookList = bookService.searchByAuthorAndYear(author, year);

        //Then: find two books with titles title1 and title2
        assertEquals(2, bookList.size());
        assertTrue(bookList.stream().map(Book::getTitle)
                .collect(Collectors.toList())
                .containsAll(bookTitles));

    }
}
