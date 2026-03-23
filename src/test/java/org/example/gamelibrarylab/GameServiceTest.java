package org.example.gamelibrarylab;

import org.example.gamelibrarylab.dto.CreateGameDTO;
import org.example.gamelibrarylab.dto.GameDTO;
import org.example.gamelibrarylab.dto.UpdateGameDTO;
import org.example.gamelibrarylab.entity.Game;
import org.example.gamelibrarylab.mapper.GameMapper;
import org.example.gamelibrarylab.repository.GameRepository;
import org.example.gamelibrarylab.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @Mock
    private GameRepository repository;

    @Mock
    private GameMapper mapper;

    @InjectMocks
    private GameService gameService;

    private Game testGame;
    private GameDTO testGameDTO;
    private CreateGameDTO testCreateDTO;
    private UpdateGameDTO testUpdateDTO;
    private List<Game> testGameList;
    private List<GameDTO> testGameDTOList;

    @BeforeEach
    void setUp() {
        // TODO: Initialize test objects
    }

    // ============ getAllGames() tests ============

    @Test
    void getAllGames_withGamesInDb_returnsListOfGameDTOs() {
        // TODO: Implement
    }

    @Test
    void getAllGames_withEmptyDb_returnsEmptyList() {
        // TODO: Implement
    }

    // ============ getGameById() tests =========

    @Test
    void getGameById_withValidId_returnsGameDTO() {
        // TODO: Implement
    }

    @Test
    void getGameById_withInvalidId_throwsResourceNotFoundException() {
        // TODO: Implement
    }

    // ============ createGame() tests =========

    @Test
    void createGame_withValidDto_returnsGameDTO() {
        // TODO: Implement
    }

    @Test
    void createGame_withDuplicateTitleAndDeveloper_throwsIllegalStateException() {
        // TODO: Implement
    }

    // ============ updateGame() tests (FRIVILLIGT) ============

    @Test
    void updateGame_withValidDto_returnsUpdatedGameDTO() {
        // TODO: Implement
    }

    @Test
    void updateGame_withInvalidId_throwsResourceNotFoundException() {
        // TODO: Implement
    }

    // ============ deleteGame() tests (FRIVILLIGT) ============

    @Test
    void deleteGame_withValidId_deletesGame() {
        // TODO: Implement
    }

    @Test
    void deleteGame_withInvalidId_throwsResourceNotFoundException() {
        // TODO: Implement
    }
}
