package com.capstone.windowsandmirrors.repositories;

import com.capstone.windowsandmirrors.models.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends CrudRepository<Author, Long> {
}
