package br.com.camilaferreiranas.unicorntechapp.services;

import br.com.camilaferreiranas.unicorntechapp.entities.User;
import br.com.camilaferreiranas.unicorntechapp.entities.dto.CreateUserRequest;
import org.springframework.stereotype.Service;


public interface UserService {

User save(CreateUserRequest user);
}
