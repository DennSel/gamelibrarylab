package org.example.gamelibrarylab.repository;

import jakarta.validation.constraints.NotBlank;
import org.example.gamelibrarylab.entity.Game;
import org.springframework.data.repository.ListCrudRepository;

public interface GameRepository extends ListCrudRepository<Game, Long> {
    boolean existsByTitleAndDeveloper(
            @NotBlank
            String title,
            @NotBlank
            String developer
    );
}

