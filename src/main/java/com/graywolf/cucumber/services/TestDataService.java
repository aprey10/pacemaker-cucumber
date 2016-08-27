package com.graywolf.cucumber.services;

import com.graywolf.cucumber.persistance.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by aprey on 25.08.2016.
 */
@Service
public class TestDataService {

    public void buildTestData(List<String> names, int year, String author) {
        //build test data
    }

    public void buildTestData(Map<String, String> names, int year) {
        //build test data
    }

    public void buildTestData(List<Book> bookList) {
        //build test data
    }
}
