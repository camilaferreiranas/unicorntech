package br.com.camilaferreiranas.unicorntechapp.entities;

import br.com.camilaferreiranas.unicorntechapp.enums.FundRoundsEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
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

    @OneToOne
    private User user;

}
