package com.capstone.windowsandmirrors.controllers;

import com.capstone.windowsandmirrors.models.Book;
import com.capstone.windowsandmirrors.services.BooksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// tell Spring that this is controller using code below:
@RestController
@CrossOrigin(origins = "*")

public class BooksController {
//    @Autowired
//    BooksRepository2 repository;
    // this annotations tells Spring where to access this crud action
    @Autowired
    private BooksServices booksServices;

    @GetMapping("/books")
    public ArrayList<Book> getAllBooks(Model books) {
        return booksServices.findAll();

    }


}
