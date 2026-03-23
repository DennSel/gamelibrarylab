package org.example.gamelibrarylab;

import org.example.gamelibrarylab.dto.CreateGameDTO;
import org.example.gamelibrarylab.dto.GameDTO;
import org.example.gamelibrarylab.dto.UpdateGameDTO;
import org.example.gamelibrarylab.entity.Game;
import org.example.gamelibrarylab.mapper.GameMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GameMapperTest {

    @InjectMocks
    private GameMapper gameMapper;

    private Game testGame;
    private CreateGameDTO testCreateDTO;
    private UpdateGameDTO testUpdateDTO;

    @BeforeEach
    void setUp() {
        // Create test: Game
        testGame = new Game();
        testGame.setId(1L);
        testGame.setTitle("Scat Cat: The Cat's Scatting Adventure");
        testGame.setDescription("Adventure of a scatting cat");
        testGame.setReleaseDate(LocalDate.of(2000, 1, 1));
        testGame.setDeveloper("Developer");
        testGame.setPublisher("Publisher");

        // Create test: CreateGameDTO
        testCreateDTO = new CreateGameDTO(
                "Elden Ring",
                "Action RPG",
                LocalDate.of(2022, 2, 25),
                "FromSoftware",
                "Bandai Namco Entertainment"
        );

        // Create test: UpdateGameDTO
        testUpdateDTO = new UpdateGameDTO(
                "Super Mario Odyssey",
                "Platformer adventure",
                LocalDate.of(2017, 10, 27),
                "Nintendo NEW",
                "Nintendo"
        );
    }

    // ============ toEntity() tests ============
    @Test
    void toEntity_withValidDto_returnsGameWithAllFields() {
        Game result = gameMapper.toEntity(testCreateDTO);

        assertNotNull(result);
        assertEquals(testCreateDTO.title(), result.getTitle());
        assertEquals(testCreateDTO.description(), result.getDescription());
        assertEquals(testCreateDTO.releaseDate(), result.getReleaseDate());
        assertEquals(testCreateDTO.developer(), result.getDeveloper());
        assertEquals(testCreateDTO.publisher(), result.getPublisher());
        assertNull(result.getId());
    }

    @Test
    void toEntity_withNullDto_throwsNullPointerException() {
        // TODO: Implement
    }

    @Test
    void toEntity_withEmptyString_handlesCorrectly() {
        // TODO: Implement
    }

    // ============ toDTO() tests =============

    @Test
    void toDTO_withValidGame_returnsDTOWithAllFields() {
        // TODO: Implement
    }

    @Test
    void toDTO_withNullEntity_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            gameMapper.toDTO(null);
        });
    }

    @Test
    void toDTO_mapsIdCorrectly() {
        Game gameWithId = new Game();
        gameWithId.setId(999L);
        gameWithId.setTitle("Test Game");
        gameWithId.setDescription("Test");
        gameWithId.setReleaseDate(LocalDate.now());
        gameWithId.setDeveloper("Dev");
        gameWithId.setPublisher("Pub");

        GameDTO result = gameMapper.toDTO(gameWithId);

        assertEquals(999L, result.id());
    }

    // ============ updateEntity() tests ========

    @Test
    void updateEntity_withValidDto_updatesAllFields() {
        // Arrange
        Game game = new Game();
        game.setId(1L);
        game.setTitle("Old Title");

        // Act
        gameMapper.updateEntity(testUpdateDTO, game);

        // Assert
        assertEquals(testUpdateDTO.title(), game.getTitle());
        assertEquals(testUpdateDTO.description(), game.getDescription());
        assertEquals(testUpdateDTO.releaseDate(), game.getReleaseDate());
        assertEquals(testUpdateDTO.developer(), game.getDeveloper());
        assertEquals(testUpdateDTO.publisher(), game.getPublisher());
    }

    @Test
    void updateEntity_withNullDto_throwsNullPointerException() {
        Game game = new Game();

        assertThrows(NullPointerException.class, () -> {
            gameMapper.updateEntity(null, game);
        });
    }

    @Test
    void updateEntity_withNullEntity_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            gameMapper.updateEntity(testUpdateDTO, null);
        });
    }

    @Test
    void updateEntity_preservesExistingId() {
        Game game = new Game();
        game.setId(1337L);
        game.setTitle("Old Title");
        game.setDescription("Old Desc");
        game.setReleaseDate(LocalDate.of(2020, 1, 1));
        game.setDeveloper("Old Dev");
        game.setPublisher("Old Pub");

        gameMapper.updateEntity(testUpdateDTO, game);

        assertEquals(1337L, game.getId());
        assertEquals(testUpdateDTO.title(), game.getTitle());
    }


}
