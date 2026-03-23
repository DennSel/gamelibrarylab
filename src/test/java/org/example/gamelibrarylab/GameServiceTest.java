package org.example.gamelibrarylab;

import org.example.gamelibrarylab.dto.CreateGameDTO;
import org.example.gamelibrarylab.dto.GameDTO;
import org.example.gamelibrarylab.dto.UpdateGameDTO;
import org.example.gamelibrarylab.entity.Game;
import org.example.gamelibrarylab.exception.ResourceNotFoundException;
import org.example.gamelibrarylab.mapper.GameMapper;
import org.example.gamelibrarylab.repository.GameRepository;
import org.example.gamelibrarylab.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        testGame = new Game();
        testGame.setId(1L);
        testGame.setTitle("The Legend of Zelda: Breath of the Wild");
        testGame.setDescription("Ett äventyrsspel i en öppen värld");
        testGame.setReleaseDate(LocalDate.of(2017, 3, 3));
        testGame.setDeveloper("Nintendo");
        testGame.setPublisher("Nintendo");

        testGameDTO = new GameDTO(
                1L,
                "The Legend of Zelda: Breath of the Wild",
                "Open World Adventure Game",
                LocalDate.of(2017, 3, 3),
                "Nintendo",
                "Nintendo"
        );

        testCreateDTO = new CreateGameDTO(
                "Elden Ring",
                "Action RPG in a dark fantasy world",
                LocalDate.of(2022, 2, 25),
                "FromSoftware",
                "Bandai Namco Entertainment"
        );

        testUpdateDTO = new UpdateGameDTO(
                "Super Mario Odyssey",
                "Mario's new adventure",
                LocalDate.of(2017, 10, 27),
                "Nintendo EPD",
                "Nintendo"
        );

        testGameList = Arrays.asList(
                testGame,
                createGame(2L, "Elden Ring", "FromSoftware", LocalDate.of(2022, 2, 25)),
                createGame(3L, "Super Mario Odyssey", "Nintendo", LocalDate.of(2017, 10, 27))
        );

        testGameDTOList = Arrays.asList(
                testGameDTO,
                createGameDTO(2L, "Elden Ring", "FromSoftware"),
                createGameDTO(3L, "Super Mario Odyssey", "Nintendo")
        );
    }

    private Game createGame(Long id, String title, String developer, LocalDate releaseDate) {
        Game game = new Game();
        game.setId(id);
        game.setTitle(title);
        game.setDescription("Description for " + title);
        game.setReleaseDate(releaseDate);
        game.setDeveloper(developer);
        game.setPublisher(developer + " Publisher");
        return game;
    }

    private GameDTO createGameDTO(Long id, String title, String developer) {
        return new GameDTO(
                id,
                title,
                "Description for " + title,
                LocalDate.of(2023, 1, 1),
                developer,
                developer + " Publisher"
        );
    }

    // ============ getAllGames() tests ============

    @Test
    void getAllGames_withGamesInDb_returnsListOfGameDTOs() {
        when(repository.findAll()).thenReturn(testGameList);
        when(mapper.toDTO(any(Game.class))).thenAnswer(invocation -> {
            Game game = invocation.getArgument(0);
            return convertToDTO(game);
        });

        List<GameDTO> result = gameService.getAllGames();

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("The Legend of Zelda: Breath of the Wild", result.get(0).title());
        assertEquals("Elden Ring", result.get(1).title());
        assertEquals("Super Mario Odyssey", result.get(2).title());

        verify(repository).findAll();
        verify(mapper, times(3)).toDTO(any(Game.class));
    }

    @Test
    void getAllGames_withEmptyDb_returnsEmptyList() {
        when(repository.findAll()).thenReturn(Arrays.asList());

        List<GameDTO> result = gameService.getAllGames();

        assertNotNull(result);
        assertTrue(result.isEmpty());

        verify(repository).findAll();
        verify(mapper, never()).toDTO(any(Game.class));
    }

    // ============ getGameById() tests =========

    @Test
    void getGameById_withValidId_returnsGameDTO() {
        Long gameId = 1L;
        when(repository.findById(gameId)).thenReturn(Optional.of(testGame));
        when(mapper.toDTO(testGame)).thenReturn(testGameDTO);

        GameDTO result = gameService.getGameById(gameId);

        assertNotNull(result);
        assertEquals(1L, result.id());
        assertEquals("The Legend of Zelda: Breath of the Wild", result.title());
        assertEquals("Nintendo", result.developer());

        verify(repository).findById(gameId);
        verify(mapper).toDTO(testGame);
    }

    @Test
    void getGameById_withInvalidId_throwsResourceNotFoundException() {
        Long invalidId = 999L;
        when(repository.findById(invalidId)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> gameService.getGameById(invalidId)
        );

        assertEquals("Game with ID " + invalidId + " not found", exception.getMessage());

        verify(repository).findById(invalidId);
        verify(mapper, never()).toDTO(any());
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

    // ============ HELPERS ============
    private GameDTO convertToDTO(Game game) {
        return new GameDTO(
                game.getId(),
                game.getTitle(),
                game.getDescription(),
                game.getReleaseDate(),
                game.getDeveloper(),
                game.getPublisher()
        );
    }
}
