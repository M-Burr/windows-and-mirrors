package com.capstone.windowsandmirrors.repositories;

import com.capstone.windowsandmirrors.models.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository2 extends CrudRepository<Books, Long> {
}
