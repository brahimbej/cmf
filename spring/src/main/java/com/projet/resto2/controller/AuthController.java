package com.projet.resto2.controller;

import com.projet.resto2.dto.AuthenticationRequest;
import com.projet.resto2.dto.AuthenticationResponse;
import com.projet.resto2.dto.SignupRequest;
import com.projet.resto2.dto.UserDto;
import com.projet.resto2.entity.User;
import com.projet.resto2.repository.UserRepository;
import com.projet.resto2.services.auth.AuthService;
import com.projet.resto2.services.jwt.UserService;
import com.projet.resto2.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JWTUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {
        System.out.println("here");
        System.out.println(signupRequest.getEmail());
        System.out.println(signupRequest.getPassword());
        System.out.println(signupRequest.getName());
        if (authService.hasUserWithEmail(signupRequest.getEmail()))
            return new ResponseEntity<>("customer already exist with this email", HttpStatus.NOT_ACCEPTABLE);
        UserDto createdUserDto = authService.createUser(signupRequest);
        if (createdUserDto == null) return new ResponseEntity<>
                ("user not created, Come again later", HttpStatus.BAD_REQUEST);
        System.out.println("created");
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws
            BadCredentialsException,
            DisabledException,
            UsernameNotFoundException {
        System.out.println("here");
        System.out.println(authenticationRequest.getEmail());
        System.out.println(authenticationRequest.getPassword());
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));

        } catch (AuthenticationException e) {
            System.out.println(e);
            if (e instanceof LockedException) {
                // Handle locked account
                System.out.println("User account is locked");
                throw new LockedException("User account is locked");
            } else {
                // Handle other authentication failures

                System.out.println("Authentication failed: " + e.getMessage());
                throw new BadCredentialsException("Incorrect username or password");
            }
        }
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        final UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authenticationRequest.getEmail());
        Optional<User> optionalUser = userRepository.findFirstByEmail(authenticationRequest.getEmail());
//        Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
        String jwt;
        if (optionalUser.isPresent()) {
            jwt = jwtUtil.generateToken(optionalUser.get());
        }
        else
            jwt = jwtUtil.generateToken(userDetails);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        if (optionalUser.isPresent()) {
            authenticationResponse.setJwt(jwt);
            authenticationResponse.setUserId(optionalUser.get().getId());
            authenticationResponse.setUserRole(optionalUser.get().getUserRole());
        }
//        return authenticationResponse;
        return ResponseEntity.ok(authenticationResponse);
    }


}
