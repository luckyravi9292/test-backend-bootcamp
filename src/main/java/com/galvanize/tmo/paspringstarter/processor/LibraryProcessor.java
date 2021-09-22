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
        Book book1 = new Book(1, "Douglas Adams", "The Hitchhiker's Guide to the Galaxy", 1979);
        Book book2 = new Book(2, "Philip K. Dick", "Do Androids Dream of Electric Sheep?", 1968);
        Book book3 = new Book(3, "William Gibson", "Neuromancer", 1984);
        ArrayList<Book> listOfAllBooks = new ArrayList<>();
        listOfAllBooks.add(book1);
        listOfAllBooks.add(book2);
        listOfAllBooks.add(book3);
        listOfAllBooks.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return listOfAllBooks;
    }

    public void deleteAllBooks() {
        listOfBooks.clear();
    }
}
