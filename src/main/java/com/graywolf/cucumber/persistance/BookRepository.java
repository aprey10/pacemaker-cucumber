package com.graywolf.cucumber.persistance;

import java.util.List;

/**
 * Created by graywolf on 8/27/16.
 */
public interface BookRepository {

    void save(Book book);

    void saveList(List<Book> bookList);

    List<Book> getList();

    void clear();
}
