package org.example.gamelibrarylab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(min = 3, max = 40)
    private String title;

    @NotBlank
    private String description;

    @NotNull
    @Past
    private LocalDate releaseDate;

    @NotBlank
    private String developer;

    @NotBlank
    private String publisher;
}
