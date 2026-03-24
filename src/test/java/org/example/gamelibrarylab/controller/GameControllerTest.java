package org.example.gamelibrarylab.controller;

import org.example.gamelibrarylab.dto.GameDTO;
import org.example.gamelibrarylab.exception.ResourceNotFoundException;
import org.example.gamelibrarylab.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


@WebMvcTest(GameController.class)
public class GameControllerTest {
    @Autowired
    MockMvc mvc;

    @MockitoBean
    GameService service;

    @Test
    void listReturnsCorrectView() throws Exception {
        Page<GameDTO> emptyPage = new PageImpl<>(List.of());
        when(service.getAllGamesPaginated(0, 10)).thenReturn(emptyPage);

        mvc.perform(get("/games"))
                .andExpect(status().isOk())
                .andExpect(view().name("list"))
                .andExpect(model().attributeExists("games"));
    }

    @Test
    void createWithInvalidDataReturnsForm() throws Exception {
        mvc.perform(post("/games")
                        .param("title", "")
                        .param("description", "")
                        .param("releaseDate", "")
                        .param("developer", "")
                        .param("publisher", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("create"))
                .andExpect(model().attributeExists("createGameDTO"))
                .andExpect(model().hasErrors());
    }

    @Test
    void detailWhenGameNotFoundReturns404() throws Exception {
        when(service.getGameById(999L))
                .thenThrow(new ResourceNotFoundException("Game with ID 999 not found"));

        mvc.perform(get("/games/999"))
                .andExpect(status().isOk())
                .andExpect(view().name("error/404"))
                .andExpect(model().attributeExists("message"));
    }

    @Test
    void editFormReturnsCorrectView() throws Exception {
        GameDTO game = new GameDTO(1L, "Test Game", "Test Description",
                LocalDate.now(), "Test Dev", "Test Pub");
        when(service.getGameById(1L)).thenReturn(game);

        mvc.perform(get("/games/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("edit"))
                .andExpect(model().attributeExists("updateGameDTO"))
                .andExpect(model().attributeExists("gameId"));
    }

    @Test
    void updateWithValidDataRedirectsToDetail() throws Exception {
        mvc.perform(post("/games/1/edit")
                        .param("title", "Updated Title")
                        .param("description", "Updated Description")
                        .param("releaseDate", "2023-01-01")
                        .param("developer", "Updated Dev")
                        .param("publisher", "Updated Pub"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/games/1"));
    }

    @Test
    void updateWithInvalidDataReturnsForm() throws Exception {
        mvc.perform(post("/games/1/edit")
                        .param("title", "")
                        .param("description", "")
                        .param("releaseDate", "")
                        .param("developer", "")
                        .param("publisher", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("edit"))
                .andExpect(model().hasErrors());
    }

    @Test
    void deleteRedirectsToList() throws Exception {
        mvc.perform(post("/games/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/games"));

        verify(service).deleteGame(1L);
    }
}

