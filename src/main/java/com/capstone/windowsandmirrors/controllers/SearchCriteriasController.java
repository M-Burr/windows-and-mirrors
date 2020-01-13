package com.capstone.windowsandmirrors.controllers;

import com.capstone.windowsandmirrors.models.Book;
import com.capstone.windowsandmirrors.models.Tag;
import com.capstone.windowsandmirrors.services.SearchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
public class SearchCriteriasController {
    @Autowired
    private SearchesService searchesService;

    @GetMapping("/api/searchcriteria")
    public ArrayList<Tag> getAllTags(Model tags) {
        return searchesService.findAll();
    }

    @GetMapping("/api/complete-search")
    public Set<Book> search(@RequestParam String identifier ){
        String[] array = identifier.split(",");
        Set<String> set = new HashSet<>(Arrays.asList(array));

        return searchesService.completeSearch(set);
    }

}
