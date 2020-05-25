package com.moviesfan.test.service;

import com.moviesfan.test.dto.FavoriteMovies;
import com.moviesfan.test.dto.Movie;

public interface MovieService {

    FavoriteMovies getFavoriteMovies();

    Movie updateFavoritesMovies(Movie movie);
}
