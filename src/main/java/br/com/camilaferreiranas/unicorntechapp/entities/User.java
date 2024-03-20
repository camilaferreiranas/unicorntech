package br.com.camilaferreiranas.unicorntechapp.entities;

import br.com.camilaferreiranas.unicorntechapp.enums.UserEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    @Column(unique = true)
    private String email;

    private String password;

    private UserEnum userType;

    @OneToOne
    private Startup startup;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Message> messages;

}
