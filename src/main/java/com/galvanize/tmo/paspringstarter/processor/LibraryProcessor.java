package com.galvanize.tmo.paspringstarter.processor;

import com.galvanize.tmo.paspringstarter.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;

@Service
public class LibraryProcessor {

    static ArrayList<Book> listOfBooks = new ArrayList<>();

    public String addBookToLibrary(Book book) {
        book.setId(listOfBooks.size() + 1);
        listOfBooks.add(book);
        return book.toString();
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = listOfBooks;
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return books;
    }

    public void deleteAllBooks() {
        listOfBooks.clear();
    }
}
