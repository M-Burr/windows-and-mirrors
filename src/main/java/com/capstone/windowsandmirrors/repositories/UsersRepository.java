package com.capstone.windowsandmirrors.repositories;

import com.capstone.windowsandmirrors.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
    User findUserByEmail(String email);
}
