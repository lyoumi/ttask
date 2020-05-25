package com.moviesfan.test.dto;

import java.util.List;
import lombok.Data;

@Data
public class FavoriteMovies {
    private List<Movie> movies;
}
