package org.example.gamelibrarylab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @PastOrPresent
    private LocalDate releaseDate;

    @NotBlank
    private String developer;

    @NotBlank
    private String publisher;
}
