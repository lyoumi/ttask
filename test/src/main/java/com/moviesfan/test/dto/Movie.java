package com.moviesfan.test.dto;

import java.util.List;
import lombok.Data;

@Data
public class Movie {
    private String id;
    private String title;
    private double imdbRate;
    private String description;
    private boolean isFavorite;
    private List<ActorDto> actors;
}
