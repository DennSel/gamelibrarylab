package org.example.gamelibrarylab.mapper;

import org.example.gamelibrarylab.dto.CreateGameDTO;
import org.example.gamelibrarylab.dto.GameDTO;
import org.example.gamelibrarylab.dto.UpdateGameDTO;
import org.example.gamelibrarylab.entity.Game;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {
    public Game toEntity(CreateGameDTO dto) {
        Game game = new Game();
        game.setTitle(dto.title());
        game.setDescription(dto.description());
        game.setReleaseDate(dto.releaseDate());
        game.setDeveloper(dto.developer());
        game.setPublisher(dto.publisher());
        return game;
    }
    public GameDTO toDTO(Game entity) {
        return new GameDTO(
            entity.getId(),
            entity.getTitle(),
            entity.getDescription(),
            entity.getReleaseDate(),
            entity.getDeveloper(),
            entity.getPublisher()
    );}
    public void updateEntity(UpdateGameDTO dto, Game entity) {
        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setReleaseDate(dto.releaseDate());
        entity.setDeveloper(dto.developer());
        entity.setPublisher(dto.publisher());
    }
}
