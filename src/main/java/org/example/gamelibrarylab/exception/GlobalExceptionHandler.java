package org.example.gamelibrarylab.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleNotFound(Model m, Exception e) {
        m.addAttribute("message", e.getMessage());
        return "error/404";
    }

    @ExceptionHandler(DuplicateGameException.class)
    public String handleDuplicate(Model m, DuplicateGameException e) {
        m.addAttribute("error", e.getMessage());
        return "create";
    }
}
