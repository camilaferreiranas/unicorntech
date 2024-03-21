package br.com.camilaferreiranas.unicorntechapp.services;

import br.com.camilaferreiranas.unicorntechapp.entities.Startup;
import br.com.camilaferreiranas.unicorntechapp.entities.dto.CreateStartupRequest;

import java.util.List;

public interface StartupService {

    Startup save(CreateStartupRequest startupRequest);

    List<Startup> findAll();
}
