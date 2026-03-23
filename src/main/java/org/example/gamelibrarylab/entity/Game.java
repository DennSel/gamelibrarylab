package org.example.gamelibrarylab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

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

    public void setTitle(@NotBlank String title) {
    }

    public void setDescription(@NotBlank String description) {
    }

    public void setReleaseDate(@NotNull @PastOrPresent LocalDate localDate) {
    }

    public void setDeveloper(@NotBlank String developer) {
    }

    public void setPublisher(@NotBlank String publisher) {
    }

    public Long getId() {
        return 0L;
    }

    public String getTitle() {
        return "";
    }

    public String getDescription() {
        return "";
    }

    public String getReleaseDate() {
        return "";
    }

    public String getPublisher() {
        return "";
    }

    public String getDeveloper() {
        return "";
    }
}
