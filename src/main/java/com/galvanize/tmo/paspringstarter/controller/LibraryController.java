package com.galvanize.tmo.paspringstarter.controller;

import com.galvanize.tmo.paspringstarter.model.Book;
import com.galvanize.tmo.paspringstarter.processor.LibraryProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class LibraryController {

    @Autowired
    LibraryProcessor libraryProcessor;

    @GetMapping("/health")
    public void health() {}

    @PostMapping("/api/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = libraryProcessor.addBookToLibrary(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @GetMapping("/api/books")
    public ResponseEntity<ArrayList<Book>> getBooks() {
        ArrayList<Book> allBooks =  libraryProcessor.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<Void> deleteBooks() {
        libraryProcessor.deleteAllBooks();
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
