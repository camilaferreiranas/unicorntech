package br.com.camilaferreiranas.unicorntechapp.repositories;

import br.com.camilaferreiranas.unicorntechapp.entities.Startup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StartupRepository extends JpaRepository<Startup, UUID> {
}
