package com.capstone.windowsandmirrors.repositories;

import com.capstone.windowsandmirrors.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<Book, Long> {
}
