package com.projet.resto2.services.auth;

import com.projet.resto2.dto.SignupRequest;
import com.projet.resto2.dto.UserDto;
import com.projet.resto2.entity.User;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);
    UserDto createUser(User user);
    boolean hasUserWithEmail(String email);
    void createAdminAccount();
}
