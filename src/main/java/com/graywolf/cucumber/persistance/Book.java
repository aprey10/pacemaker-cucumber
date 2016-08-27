package com.graywolf.cucumber.persistance;

import lombok.Data;

/**
 * Created by aprey on 25.08.2016.
 */
@Data
public class Book {

    private String name;

    private String author;

    private int year;

    public Book(){

    }

    public Book(String name, String author, int year){
        this.author = author;
        this.name = name;
        this.year = year;
    }
}
