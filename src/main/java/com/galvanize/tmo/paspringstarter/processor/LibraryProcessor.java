package com.galvanize.tmo.paspringstarter.processor;

import com.galvanize.tmo.paspringstarter.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;

@Service
public class LibraryProcessor {

    static ArrayList<Book> listOfBooks = new ArrayList<>();

    public Book addBookToLibrary(Book book) {
        book.setId(listOfBooks.size() + 1);
        listOfBooks.add(book);
        return book;
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> listOfAllBooks = new ArrayList<>();
        listOfBooks.sort(Comparator.comparing(Book::getTitle));
        return listOfAllBooks;
    }

    public void deleteAllBooks() {
        listOfBooks.clear();
    }
}
