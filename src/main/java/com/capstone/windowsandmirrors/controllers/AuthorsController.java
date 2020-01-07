package com.capstone.windowsandmirrors.controllers;

import com.capstone.windowsandmirrors.models.Author;
import com.capstone.windowsandmirrors.services.AuthorsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
public class AuthorsController {
    @Autowired
    private AuthorsServices authorsServices;

    @GetMapping("/authors")


    public ArrayList<Author> getAllAuthors(Model authors) {
        return authorsServices.findAll();
    }

}
