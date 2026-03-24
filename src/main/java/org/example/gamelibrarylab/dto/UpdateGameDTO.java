package org.example.gamelibrarylab.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UpdateGameDTO(
        @NotBlank @Size(min = 3, max = 40) String title,
        @NotBlank String description,
        @NotNull @PastOrPresent LocalDate releaseDate,
        @NotBlank String developer,
        @NotBlank String publisher
) {}