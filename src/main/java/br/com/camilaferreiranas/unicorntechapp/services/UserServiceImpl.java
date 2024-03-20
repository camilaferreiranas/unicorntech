package br.com.camilaferreiranas.unicorntechapp.services;

import br.com.camilaferreiranas.unicorntechapp.entities.User;
import br.com.camilaferreiranas.unicorntechapp.entities.dto.CreateUserRequest;
import br.com.camilaferreiranas.unicorntechapp.enums.UserEnum;
import br.com.camilaferreiranas.unicorntechapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public User save(CreateUserRequest user) {
        var userToSave = new User();
        userToSave.setUsername(user.username());
        userToSave.setEmail(user.email());
        userToSave.setPassword(passwordEncoder.encode(user.password()));
        userToSave.setUserType(UserEnum.BASIC);
        return userRepository.save(userToSave);
    }
}
