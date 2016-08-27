package com.graywolf.cucumber.integration;

import com.graywolf.cucumber.Application;
import com.graywolf.cucumber.persistance.Book;
import com.graywolf.cucumber.services.BookService;
import com.graywolf.cucumber.services.TestDataService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
public class BookSearchSteps {

    @Autowired
    private BookService bookService;

    @Autowired
    private TestDataService testDataService;

    private List<Book> books;


    @Given("^we have two books with names \"([^\"]*)\" and \"([^\"]*)\" that were written by \"([^\"]*)\" and published at (\\d+)$")
    public void given(String name1, String name2, String author, int year) throws Throwable {
        testDataService.buildTestData(Arrays.asList(name1, name2), year, author);
    }

    @When("^search for book by author \"([^\"]*)\" and year (\\d+)$")
    public void when(String author, int year) throws Throwable {
        books = bookService.searchByAuthorAndYear(author, year);
    }

    @Then("^(\\d+) books will be found$")
    public void then(int size) throws Throwable {
        assertEquals(2, books.size());
    }

    @And("^names of that books will be \"([^\"]*)\" and \"([^\"]*)\"$")
    public void then(String name1, String name2) throws Throwable {
        assertTrue(books.stream().map(Book::getName).collect(Collectors.toList()).containsAll(Arrays.asList(name1, name2)));
    }

    @And("^names of that books will be: (.*)$")
    public void then_list(List<String> bookNames) throws Throwable {
        assertTrue(books.stream().map(Book::getName).collect(Collectors.toList()).containsAll(bookNames));
    }

    @Given("^we have books that were written by \"([^\"]*)\" and published at (\\d+), books names: (.*)$")
    public void given_list(String author, int year, List<String> bookNames) throws Throwable {
        testDataService.buildTestData(bookNames, year, author);
    }

    @Given("^we have books that were published at (\\d+), books names and authors:$")
    public void given_map(int year, Map<String, String> bookNames) throws Throwable {
        testDataService.buildTestData(bookNames, year);
    }

    @Given("^we have list of books:$")
    public void given_dto(List<Book> bookList) throws Throwable {
        testDataService.buildTestData(bookList);
    }
}