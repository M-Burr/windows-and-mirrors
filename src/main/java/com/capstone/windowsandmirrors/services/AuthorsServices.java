package com.capstone.windowsandmirrors.services;

import com.capstone.windowsandmirrors.models.Author;
import com.capstone.windowsandmirrors.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthorsServices {
    @Autowired
    private AuthorsRepository authorsRepository;

    public ArrayList<Author> findAll(){
        return (ArrayList<Author>) authorsRepository.findAll();
    }

}
