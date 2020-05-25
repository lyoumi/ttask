package com.moviesfan.test.dto;

import java.util.List;
import lombok.Data;

@Data
public class Actor {

    private String id;
    private String name;
    private boolean isFavorite;
    private List<MovieDto> movies;
}
