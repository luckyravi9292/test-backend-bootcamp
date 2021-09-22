package com.galvanize.tmo.paspringstarter.processor;

import com.galvanize.tmo.paspringstarter.model.Book;
import com.galvanize.tmo.paspringstarter.model.BookResponse;
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

    public BookResponse getAllBooks() {
        BookResponse bookResponse = new BookResponse();
        listOfBooks.sort(Comparator.comparing(Book::getTitle));
        bookResponse.setBooks(listOfBooks);
        return bookResponse;
    }

    public void deleteAllBooks() {
        listOfBooks.clear();
    }
}
