package br.com.camilaferreiranas.unicorntechapp.services;

import br.com.camilaferreiranas.unicorntechapp.entities.dto.LoginRequest;
import br.com.camilaferreiranas.unicorntechapp.entities.dto.LoginResponse;
import br.com.camilaferreiranas.unicorntechapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final UserRepository userRepository;
    private final JwtEncoder jwtEncoder;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        var user = userRepository.findUserByEmail(loginRequest.email());
        if(user.isEmpty()) {
            throw new BadCredentialsException("user is invalid");
        }

        var now = Instant.now();
        var expiresIn = now.plusSeconds(3000L);

        var claims = JwtClaimsSet.builder()
                .issuer("unicornapp")
                .subject(user.get().getUsername())
                .issuedAt(now)
                .expiresAt(expiresIn)
                .build();
        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        return new LoginResponse(jwtValue, expiresIn);

    }
}
