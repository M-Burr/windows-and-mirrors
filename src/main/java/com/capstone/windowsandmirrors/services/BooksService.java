package com.capstone.windowsandmirrors.services;

import com.capstone.windowsandmirrors.models.Book;
import com.capstone.windowsandmirrors.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BooksService {
    @Autowired
    private BooksRepository booksRepository;

   public ArrayList<Book> findAll(){
       return (ArrayList<Book>) booksRepository.findAll();
   }

   public Optional <Book> findById(Long id){
       return booksRepository.findById(id);
   }

}
