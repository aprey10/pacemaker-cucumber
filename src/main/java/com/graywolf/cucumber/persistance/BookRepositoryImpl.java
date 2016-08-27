package com.graywolf.cucumber.persistance;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepositoryImpl implements BookRepository {

    private List<Book> bookList = new ArrayList<>();

    @Override
    public void save(Book book) {
        this.bookList.add(book);
    }

    @Override
    public void saveList(List<Book> bookList) {
        this.bookList.addAll(bookList);
    }

    @Override
    public List<Book> getList() {
        return new ArrayList<>(bookList);
    }

    @Override
    public void clear(){
        bookList.clear();
    }
}
