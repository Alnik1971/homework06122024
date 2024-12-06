package ru.netology.homework241206.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.homework241206.enums.Authorities;
import ru.netology.homework241206.exception.InvalidCredentials;
import ru.netology.homework241206.exception.UnauthorizedUser;
import ru.netology.homework241206.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    private ResponseEntity<String> icHandler(InvalidCredentials e) {
        return new ResponseEntity<>("HTTP Status: %s || Exception: ".formatted(HttpStatus.BAD_REQUEST) + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnauthorizedUser.class)
    private ResponseEntity<String> uuHandler(UnauthorizedUser e) {
        return new ResponseEntity<>("HTTP Status: %s || Exception: ".formatted(HttpStatus.UNAUTHORIZED) + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
