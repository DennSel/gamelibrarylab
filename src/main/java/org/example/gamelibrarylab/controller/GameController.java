package org.example.gamelibrarylab.controller;

import org.example.gamelibrarylab.dto.GameDTO;
import org.example.gamelibrarylab.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/games")
public class GameController {
    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        List<GameDTO> games = service.getAllGames();
        model.addAttribute("games", games);
        return "games/list";
    }
}

