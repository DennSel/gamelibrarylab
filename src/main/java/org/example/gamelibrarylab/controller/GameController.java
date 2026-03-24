package org.example.gamelibrarylab.controller;

import jakarta.validation.Valid;
import org.example.gamelibrarylab.dto.CreateGameDTO;
import org.example.gamelibrarylab.dto.GameDTO;
import org.example.gamelibrarylab.dto.UpdateGameDTO;
import org.example.gamelibrarylab.service.GameService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/games")
public class GameController {
    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public String list(
            @RequestParam(required = false) String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model
    ) {
        Page<GameDTO> gamePage;

        if (query != null && !query.isBlank()) {
            gamePage = service.filterGamesPaginated(query, page, size);
        } else {
            gamePage = service.getAllGamesPaginated(page, size);
        }

        model.addAttribute("games", gamePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", gamePage.getTotalPages());
        model.addAttribute("totalItems", gamePage.getTotalElements());
        model.addAttribute("hasNext", gamePage.hasNext());
        model.addAttribute("hasPrevious", gamePage.hasPrevious());
        model.addAttribute("query", query);

        return "list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        GameDTO game = service.getGameById(id);
        model.addAttribute("game", game);
        return "detail";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("createGameDTO", new CreateGameDTO(
                "", "", LocalDate.now(), "", ""
        ));
        return "create";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute CreateGameDTO dto,
                         BindingResult result) {
        if (result.hasErrors()) return "create";
        service.createGame(dto);
        return "redirect:/games";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        GameDTO game = service.getGameById(id);
        model.addAttribute("updateGameDTO", new UpdateGameDTO(
                game.title(),
                game.description(),
                game.releaseDate(),
                game.developer(),
                game.publisher()
        ));
        model.addAttribute("gameId", id);
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute UpdateGameDTO dto,
                         BindingResult result) {
        if (result.hasErrors()) return "edit";
        service.updateGame(id, dto);
        return "redirect:/games/{id}";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.deleteGame(id);
        return "redirect:/games";
    }
}

