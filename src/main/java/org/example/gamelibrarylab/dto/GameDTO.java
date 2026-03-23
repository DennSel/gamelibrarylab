package org.example.gamelibrarylab.dto;

import java.time.LocalDate;

public record GameDTO (
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        String developer,
        String publisher
){}
