package com.movieratingapp.application.service;

import com.movieratingapp.application.dto.RatingDTO;
import com.movieratingapp.application.entity.RatingEntity;

import java.util.List;

public interface RatingService {

    RatingEntity submitRating(RatingDTO ratingDTO);

    List<RatingEntity> getAllRatingsForMovie(Long movieId);

    Double getOverallMovieRating(Long movieId);
}
