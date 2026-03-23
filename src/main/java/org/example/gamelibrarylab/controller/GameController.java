package org.example.gamelibrarylab.controller;

import org.example.gamelibrarylab.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/games")
public class GameController {
    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }
}

