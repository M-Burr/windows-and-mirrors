package com.capstone.windowsandmirrors.services;

import com.capstone.windowsandmirrors.models.Books;
import com.capstone.windowsandmirrors.repositories.BooksRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BooksServices {
    @Autowired
    private BooksRepository2 booksRepository2;

   public ArrayList<Books> findAll(){
       System.out.println("Testing Books Database!");
       return (ArrayList<Books>) booksRepository2.findAll();
   }

}
