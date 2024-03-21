package br.com.camilaferreiranas.unicorntechapp.repositories;

import br.com.camilaferreiranas.unicorntechapp.entities.User;
import br.com.camilaferreiranas.unicorntechapp.enums.UserEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByEmail(String email);

    List<User> findUserByUserType(UserEnum userType);
}
