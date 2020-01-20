package com.capstone.windowsandmirrors.services;

import com.capstone.windowsandmirrors.models.Author;
import com.capstone.windowsandmirrors.models.Book;
import com.capstone.windowsandmirrors.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthorsService {
    @Autowired
    private AuthorsRepository authorsRepository;

    public ArrayList<Author> findAll(){ return (ArrayList<Author>) authorsRepository.findAll();
    }

    public void updateAuthorRating(Author author){
        Set<Book> authorsBooks = author.getBooks();
        Double bookTotal = 0.0;

        Iterator<Book> it = authorsBooks.iterator();
        while (it.hasNext()){
            Book book = it.next();
            bookTotal += book.getAverageRating();
        }

        Double authorRating = bookTotal / authorsBooks.size();
        author.setAvgRating(authorRating);
        authorsRepository.save(author);
    }

    public Optional<Author> findById(Long id) {
        return authorsRepository.findById(id);
    }
}
