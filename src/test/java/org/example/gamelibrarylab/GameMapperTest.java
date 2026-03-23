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

@ExtendWith(MockitoExtension.class)
public class GameMapperTest {

    @InjectMocks
    private GameMapper gameMapper;

    private Game testGame;
    private CreateGameDTO testCreateDTO;
    private UpdateGameDTO testUpdateDTO;

    @BeforeEach
    void setUp() {
        // TODO: Initialize test objects
    }

    // ============ toEntity() tests ============
    @Test
    void toEntity_withValidDto_returnsGameWithAllFields() {
        // TODO: Implement
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
