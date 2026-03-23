package org.example.gamelibrarylab.repository;

import org.example.gamelibrarylab.entity.Game;
import org.springframework.data.repository.ListCrudRepository;

public interface GameRepository extends ListCrudRepository<Game, Long> {}

