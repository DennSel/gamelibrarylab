package org.example.gamelibrarylab.service;

import org.example.gamelibrarylab.dto.GameDTO;
import org.example.gamelibrarylab.entity.Game;
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
}