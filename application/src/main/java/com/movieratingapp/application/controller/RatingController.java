package com.movieratingapp.application.controller;

import com.movieratingapp.application.dto.RatingDTO;
import com.movieratingapp.application.entity.RatingEntity;
import com.movieratingapp.application.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RatingEntity submitRating(@RequestBody RatingDTO ratingDTO) {
        return ratingService.submitRating(ratingDTO);
    }

    @GetMapping("/movie/{movieId}")
    public List<RatingEntity> getMovieRating(@PathVariable Long movieId) {
        return ratingService.getAllRatingsForMovie(movieId);
    }

    @GetMapping("/movie/{movieId}/overall")
    public Double getOverallMovieRating(@PathVariable Long movieId) {
        return ratingService.getOverallMovieRating(movieId);
    }
}
