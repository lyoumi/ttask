package com.moviesfan.test.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviesfan.test.dto.FavoriteMovies;
import com.moviesfan.test.dto.Movie;
import com.moviesfan.test.service.MovieService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("favorites/movies")
@AllArgsConstructor
public class MovieResource {
    
    private final MovieService movieService;
    
    @GetMapping
    public FavoriteMovies favoriteActors() {
        return movieService.getFavoriteMovies();
    }

    /**
     * I'd like to believe that the same method can be used to delete movie from favorites
     * @param movie
     * @return
     */
    @PutMapping
    public Movie updateFavoriteMovies(@RequestBody Movie movie) {
        return movieService.updateFavoritesMovies(movie);
    }

}
