package com.movieratingapp.application.service.impl;

import com.movieratingapp.application.dto.RatingDTO;
import com.movieratingapp.application.entity.MovieEntity;
import com.movieratingapp.application.entity.RatingEntity;
import com.movieratingapp.application.repository.MovieRepository;
import com.movieratingapp.application.repository.RatingRepository;
import com.movieratingapp.application.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public RatingEntity submitRating(RatingDTO ratingDTO) {
        if (ratingDTO.getRatingValue() < 1 || ratingDTO.getRatingValue() > 10) {
            throw new IllegalArgumentException("Rating should be between 1 and 10");
        }
        MovieEntity movieEntity = movieRepository.
                getById(ratingDTO.getMovieId().getMovieId());

        RatingEntity rating = new RatingEntity(
                movieEntity,
                ratingDTO.getUserId(),
                ratingDTO.getUserName(),
                ratingDTO.getRatingValue(),
                ratingDTO.getReviewComments());

        rating.setSubmissionTime(LocalDateTime.now());
        rating = ratingRepository.save(rating);

        movieEntity.addRatings(rating);
        movieRepository.save(movieEntity);
        return rating;
    }

    @Override
    public List<RatingEntity> getAllRatingsForMovie(Long movieId) {
        MovieEntity movieEntity = movieRepository.getById(movieId);
        return ratingRepository.findByMovieId(movieEntity);
    }

    @Override
    public Double getOverallMovieRating(Long movieId) {
        return ratingRepository.calculateOverallMovieRating(movieId);
    }
}
