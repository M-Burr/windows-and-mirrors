package com.capstone.windowsandmirrors.controllers;

import com.capstone.windowsandmirrors.models.Book;
import com.capstone.windowsandmirrors.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;

// tell Spring that this is controller using code below:
@RestController
@CrossOrigin(origins = "*")

public class BooksController {
    @Autowired
    private BooksService booksService;

    @GetMapping("/api/books")
    public ArrayList<Book> getAllBooks(Model books) {
        return booksService.findAll();
    }

    @GetMapping("/api/books/{id}")
    public Book retrieveBook(@PathVariable long id){
        Optional<Book> book=booksService.findById(id);
        return book.get();
    }


}
