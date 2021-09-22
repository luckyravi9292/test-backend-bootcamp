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

    @PostMapping("/api/book")
    public String addBook(@RequestBody Book book) {
        return libraryProcessor.addBookToLibrary(book);
    }

    @GetMapping("/api/books")
    public ArrayList<Book> getBooks() {
        return libraryProcessor.getAllBooks();
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<Void> deleteBooks() {
        libraryProcessor.deleteAllBooks();
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
