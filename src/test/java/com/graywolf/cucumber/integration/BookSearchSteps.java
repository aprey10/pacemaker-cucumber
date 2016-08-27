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


    @Given("^we have two books with titles \"([^\"]*)\" and \"([^\"]*)\" that were written by \"([^\"]*)\" and published at (\\d+)$")
    public void given(String title1, String title2, String author, int year) throws Throwable {
        testDataService.buildTestData(Arrays.asList(title1, title2), year, author);
    }

    @When("^search for book by author \"([^\"]*)\" and year (\\d+)$")
    public void when(String author, int year) throws Throwable {
        books = bookService.searchByAuthorAndYear(author, year);
    }

    @Then("^(\\d+) books will be found$")
    public void then(int size) throws Throwable {
        assertEquals(size, books.size());
    }

    @And("^titles of that books will be \"([^\"]*)\" and \"([^\"]*)\"$")
    public void then(String title1, String title2) throws Throwable {
        assertTrue(books.stream().map(Book::getTitle).collect(Collectors.toList()).containsAll(Arrays.asList(title1,
                title2)));
    }

    @And("^titles of that books will be: (.*)$")
    public void then_list(List<String> booktitles) throws Throwable {
        assertTrue(books.stream().map(Book::getTitle).collect(Collectors.toList()).containsAll(booktitles));
    }

    @Given("^we have books that were written by \"([^\"]*)\" and published at (\\d+), books titles: (.*)$")
    public void given_list(String author, int year, List<String> bookTitles) throws Throwable {
        testDataService.buildTestData(bookTitles, year, author);
    }

    @Given("^we have books that were published at (\\d+), books titles and authors:$")
    public void given_map(int year, Map<String, String> bookTitles) throws Throwable {
        testDataService.buildTestData(bookTitles, year);
    }

    @Given("^we have list of books:$")
    public void given_dto(List<Book> bookList) throws Throwable {
        testDataService.buildTestData(bookList);
    }
}