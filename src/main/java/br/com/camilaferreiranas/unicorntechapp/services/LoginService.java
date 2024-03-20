package br.com.camilaferreiranas.unicorntechapp.services;

import br.com.camilaferreiranas.unicorntechapp.entities.dto.LoginRequest;
import br.com.camilaferreiranas.unicorntechapp.entities.dto.LoginResponse;

public interface LoginService {

    LoginResponse login (LoginRequest loginRequest);
}
