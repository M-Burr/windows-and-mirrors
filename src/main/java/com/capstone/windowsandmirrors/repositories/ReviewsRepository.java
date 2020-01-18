package com.capstone.windowsandmirrors.repositories;

import com.capstone.windowsandmirrors.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends CrudRepository<Review, Long> {

}
