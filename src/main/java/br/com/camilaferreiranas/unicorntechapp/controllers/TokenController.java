package br.com.camilaferreiranas.unicorntechapp.controllers;

import br.com.camilaferreiranas.unicorntechapp.entities.dto.LoginRequest;
import br.com.camilaferreiranas.unicorntechapp.entities.dto.LoginResponse;
import br.com.camilaferreiranas.unicorntechapp.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@AllArgsConstructor
@RequestMapping(path = "/login")
public class TokenController {
    private final LoginService loginService;


    @PostMapping
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest loginRequest) {
        var login = loginService.login(loginRequest);
        return ResponseEntity.ok(login);
    }

}
