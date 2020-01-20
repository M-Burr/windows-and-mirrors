package com.capstone.windowsandmirrors.controllers;

import com.capstone.windowsandmirrors.models.Author;
import com.capstone.windowsandmirrors.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class AuthorsController {
    @Autowired
    private AuthorsService authorsService;

    @GetMapping("/api/authors")
    public ArrayList<Author> getAllAuthors(Model authors) {
        return authorsService.findAll();
    }

    @GetMapping("/api/authors/{id}")
    public Author retrieveAuthor(@PathVariable Long id){
        Optional<Author> author= authorsService.findById(id);
        return author.get();
    }

}
