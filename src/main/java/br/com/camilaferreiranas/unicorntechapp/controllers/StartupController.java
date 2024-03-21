package br.com.camilaferreiranas.unicorntechapp.controllers;

import br.com.camilaferreiranas.unicorntechapp.entities.Startup;
import br.com.camilaferreiranas.unicorntechapp.entities.dto.CreateStartupRequest;
import br.com.camilaferreiranas.unicorntechapp.services.StartupService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/startup")
@AllArgsConstructor
public class StartupController {

    private final StartupService service;


    @PostMapping
    public ResponseEntity<Startup> save(@RequestBody CreateStartupRequest startupRequest) {
        return ResponseEntity.ok(service.save(startupRequest));
    }

    @GetMapping
    public ResponseEntity<List<Startup>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
