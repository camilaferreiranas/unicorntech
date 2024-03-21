package br.com.camilaferreiranas.unicorntechapp.controllers;

import br.com.camilaferreiranas.unicorntechapp.entities.User;
import br.com.camilaferreiranas.unicorntechapp.entities.dto.CreateUserRequest;
import br.com.camilaferreiranas.unicorntechapp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody CreateUserRequest userRequest) {
        return ResponseEntity.ok(userService.save(userRequest));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
}
