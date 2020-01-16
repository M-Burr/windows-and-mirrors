package com.capstone.windowsandmirrors.controllers;

import com.capstone.windowsandmirrors.models.Book;
import com.capstone.windowsandmirrors.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/books")
    public String addBook(Book newBook, Model model){
        model.addAttribute("book", newBook);
        return "books";
    }


}
