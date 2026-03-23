package org.example.gamelibrarylab.controller;

import org.example.gamelibrarylab.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


@WebMvcTest(GameController.class)
public class GameControllerTest {
    @Autowired
    MockMvc mvc;

    @MockitoBean
    GameService service;

    @Test
    void listReturnsCorrectView() throws Exception {
        when(service.getAllGames()).thenReturn(List.of());

        mvc.perform(get("/games"))
                .andExpect(status().isOk())
                .andExpect(view().name("games/list"))
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
}

