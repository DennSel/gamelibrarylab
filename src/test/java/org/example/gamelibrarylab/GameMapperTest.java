package org.example.gamelibrarylab;

import org.example.gamelibrarylab.dto.CreateGameDTO;
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

    // ============ toDTO() tests =============

    @Test
    void toDTO_withValidGame_returnsDTOWithAllFields() {
        // TODO: Implement
    }

    @Test
    void toDTO_withNullEntity_throwsNullPointerException() {
        // TODO: Implement
    }

    // ============ updateEntity() tests ========

    @Test
    void updateEntity_withValidDto_updatesAllFields() {
        // TODO: Implement
    }

    @Test
    void updateEntity_withNullDto_throwsNullPointerException() {
        // TODO: Implement
    }

    @Test
    void updateEntity_withNullEntity_throwsNullPointerException() {
        // TODO: Implement
    }


}
