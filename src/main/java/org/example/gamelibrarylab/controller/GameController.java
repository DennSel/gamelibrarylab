package org.example.gamelibrarylab.controller;

import jakarta.validation.Valid;
import org.example.gamelibrarylab.dto.CreateGameDTO;
import org.example.gamelibrarylab.dto.GameDTO;
import org.example.gamelibrarylab.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        GameDTO game = service.getGameById(id);
        model.addAttribute("game", game);
        return "games/detail";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("createGameDTO", new CreateGameDTO(
                "", "", LocalDate.now(), "", ""
        ));
        return "games/create";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute CreateGameDTO dto,
                         BindingResult result) {
        if (result.hasErrors()) return "games/create";
        service.createGame(dto);
        return "redirect:/games";
    }
}

