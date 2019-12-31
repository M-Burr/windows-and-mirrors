package com.capstone.windowsandmirrors.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// tell Spring that this is controller using code below:
@RestController
public class BooksController {
    // this annotations tells Spring where to access this crud action
    @RequestMapping("/books")
    public List<String> booksIndex() {
        return new ArrayList<>();
    }
}
