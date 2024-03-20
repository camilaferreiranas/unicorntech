package br.com.camilaferreiranas.unicorntechapp.entities;

import br.com.camilaferreiranas.unicorntechapp.enums.FundRoundsEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Startup {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String field;

    private String description;

    private long quantityUsers;

    private String website;

    private Double valueInvested;

    private FundRoundsEnum fundStage;

}
