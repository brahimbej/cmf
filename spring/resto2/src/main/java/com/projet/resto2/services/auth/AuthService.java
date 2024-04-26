package com.projet.resto2.services.auth;

import com.projet.resto2.dto.SignupRequest;
import com.projet.resto2.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);
    boolean hasUserWithEmail(String email);
    void createAdminAccount();
}
