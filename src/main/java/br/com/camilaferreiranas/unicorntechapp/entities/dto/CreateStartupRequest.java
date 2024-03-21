package br.com.camilaferreiranas.unicorntechapp.entities.dto;

import br.com.camilaferreiranas.unicorntechapp.enums.FundRoundsEnum;

import java.util.UUID;

public record CreateStartupRequest(String name, String field, String description, int quantityUsers, String website, Double valueInvested, FundRoundsEnum fundStage, String userEmail) {
}
