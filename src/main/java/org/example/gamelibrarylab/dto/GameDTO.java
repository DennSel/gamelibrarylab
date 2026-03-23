package org.example.gamelibrarylab.dto;

import java.time.LocalDate;

public record GameDTO (
        Long id,
        String title,
        String description,
        LocalDate publisher,
        String developer,
        String releaseDate
){}
