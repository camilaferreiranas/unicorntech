package br.com.camilaferreiranas.unicorntechapp.entities.dto;

import java.time.Instant;

public record LoginResponse(String accessToken, Instant expiresIn) {
}
