package com.capstone.windowsandmirrors.controllers;

import com.capstone.windowsandmirrors.models.AddBookRequest;
import com.capstone.windowsandmirrors.models.Book;
import com.capstone.windowsandmirrors.services.AddBooksService;
import com.capstone.windowsandmirrors.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

// tell Spring that this is controller using code below:
@RestController
public class BooksController {
    @Autowired
    private BooksService booksService;

    @Autowired
    private AddBooksService addBooksService;

    @GetMapping("/api/books")
    public ArrayList<Book> getAllBooks(Model books) {
        return booksService.findAll();
    }

    @GetMapping("/api/books/{id}")
    public Book retrieveBook(@PathVariable long id){
        Optional<Book> book=booksService.findById(id);
        return book.get();
    }

    @PostMapping("/api/books")
    public String addBook(@RequestBody AddBookRequest bookRequest){
         addBooksService.addBook(bookRequest);
        return "hello";
    }


}
