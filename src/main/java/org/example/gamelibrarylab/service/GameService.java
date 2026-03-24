package org.example.gamelibrarylab.service;

import org.example.gamelibrarylab.dto.CreateGameDTO;
import org.example.gamelibrarylab.dto.GameDTO;
import org.example.gamelibrarylab.dto.UpdateGameDTO;
import org.example.gamelibrarylab.entity.Game;
import org.example.gamelibrarylab.exception.ResourceNotFoundException;
import org.example.gamelibrarylab.mapper.GameMapper;
import org.example.gamelibrarylab.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository repo;
    private final GameMapper mapper;
    public GameService(GameRepository r, GameMapper m) {
        this.repo = r;
        this.mapper = m;
    }

    public List<GameDTO> getAllGames() {
        List<Game> games = repo.findAll();
        return games
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public GameDTO getGameById(Long id) {
        Game game = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Game with ID " + id + " not found"
                ));
        return mapper.toDTO(game);
    }

    public GameDTO createGame(CreateGameDTO dto) {
        if (repo.existsByTitleAndDeveloper(dto.title(), dto.developer())) {
            throw new IllegalStateException(
                    "A game with title '" + dto.title() +
                            "' from '" + dto.developer() +
                            "' already exists"
            );
        }

        Game game = mapper.toEntity(dto);
        Game saved = repo.save(game);
        return mapper.toDTO(saved);
    }

    public GameDTO updateGame(Long id, UpdateGameDTO dto) {
        Game game = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Game with ID " + id + " not found"
                ));

        mapper.updateEntity(dto, game);
        Game updated = repo.save(game);
        return mapper.toDTO(updated);
    }

    public void deleteGame(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Game with ID " + id + " not found"
            );
        }
        repo.deleteById(id);
    }

    public List<GameDTO> filterGames(String query) {
        if (query == null || query.isBlank()) {
            return getAllGames();
        }

        List<Game> games = repo.findByTitleContainingIgnoreCaseOrDeveloperContainingIgnoreCase(
                query, query
        );

        return games.stream()
                .map(mapper::toDTO)
                .toList();
    }

}