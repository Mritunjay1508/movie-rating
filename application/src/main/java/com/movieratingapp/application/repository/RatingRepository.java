package com.movieratingapp.application.repository;

import com.movieratingapp.application.entity.MovieEntity;
import com.movieratingapp.application.entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {

    List<RatingEntity> findByMovieId(MovieEntity movieId);

    @Query("SELECT AVG(r.ratingValue) FROM RatingEntity r WHERE r.movieId.id = ?1")
    Double calculateOverallMovieRating(Long movieId);

}
