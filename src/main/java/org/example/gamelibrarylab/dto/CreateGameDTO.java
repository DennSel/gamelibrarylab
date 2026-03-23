package org.example.gamelibrarylab.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record CreateGameDTO(
        @NotBlank String title,
        @NotBlank String publisher,
        @NotNull @PastOrPresent LocalDate releaseDate,
        @NotBlank String developer,
        @NotBlank String description
        ) {}
