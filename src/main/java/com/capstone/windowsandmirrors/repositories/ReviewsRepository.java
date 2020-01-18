package com.capstone.windowsandmirrors.repositories;

import com.capstone.windowsandmirrors.models.AverageRatingByAccountType;
import com.capstone.windowsandmirrors.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface ReviewsRepository extends CrudRepository<Review, Long> {
    @Query(
            value = "SELECT AVG(reviews.rating) AS averageScore, COUNT(reviews.id) AS numberReviews, users.account_type as accountType FROM reviews JOIN users ON users.id = reviews.user_id WHERE book_id = ?1 GROUP BY users.account_type",
            nativeQuery = true
    )
    public List<AverageRatingByAccountType> getAverageRatingForBook(Long bookId);

    List<Review> findReviewsByBookId(Long bookId);
}
