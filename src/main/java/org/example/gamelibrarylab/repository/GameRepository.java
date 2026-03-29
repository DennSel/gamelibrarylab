package org.example.gamelibrarylab.repository;

import jakarta.validation.constraints.NotBlank;
import org.example.gamelibrarylab.entity.Game;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GameRepository extends ListCrudRepository<Game, Long> {
    boolean existsByTitleAndDeveloper(
            @NotBlank
            String title,
            @NotBlank
            String developer
    );

    Page<Game> findByTitleContainingIgnoreCaseOrDeveloperContainingIgnoreCase(
            String title, String developer, Pageable pageable
    );

    Page<Game> findAll(Pageable pageable);
}



