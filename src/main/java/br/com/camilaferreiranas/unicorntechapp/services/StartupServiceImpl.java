package br.com.camilaferreiranas.unicorntechapp.services;

import br.com.camilaferreiranas.unicorntechapp.entities.Startup;
import br.com.camilaferreiranas.unicorntechapp.entities.User;
import br.com.camilaferreiranas.unicorntechapp.entities.dto.CreateStartupRequest;
import br.com.camilaferreiranas.unicorntechapp.repositories.StartupRepository;
import br.com.camilaferreiranas.unicorntechapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StartupServiceImpl implements StartupService {

    private final StartupRepository startupRepository;
    private final UserRepository userRepository;
    @Override
    public Startup save(CreateStartupRequest startupRequest) {
        var startup = new Startup();
        var user = findUser(startupRequest.userEmail());
        if(user.isEmpty()) {
            throw  new RuntimeException("invalid user");
        }
        startup.setName(startupRequest.name());
        startup.setField(startupRequest.field());
        startup.setDescription(startupRequest.description());
        startup.setWebsite(startupRequest.website());
        startup.setFundStage(startupRequest.fundStage());
        startup.setValueInvested(startupRequest.valueInvested());
        user.ifPresent(startup::setUser);
        return startupRepository.save(startup);
    }

    @Override
    public List<Startup> findAll() {
        return startupRepository.findAll();
    }

    private Optional<User> findUser(String email) {
        return userRepository.findUserByEmail(email);
    }
}
