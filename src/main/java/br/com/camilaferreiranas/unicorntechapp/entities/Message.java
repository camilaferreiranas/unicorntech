package br.com.camilaferreiranas.unicorntechapp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String content;

    @ManyToOne
    private User user;
}
