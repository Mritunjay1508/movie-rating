package com.movieratingapp.application.controller;

import com.movieratingapp.application.entity.MovieEntity;
import com.movieratingapp.application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieEntity createMovie(@RequestBody MovieEntity movieEntity) {
        return movieService.createMovie(movieEntity.getMovieName(), movieEntity.getPincode());
    }

    @GetMapping("/{movieId}")
    public MovieEntity getMovie(@PathVariable Long movieId) {
        return movieService.getMovieById(movieId);
    }

    @GetMapping
    public List<MovieEntity> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/pincode/{pincode}")
    public List<MovieEntity> getMoviesByPincode(@PathVariable String pincode) {
        return movieService.getMoviesByPincode(pincode);
    }
}
