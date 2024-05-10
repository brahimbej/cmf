package com.projet.resto2.controller;

import com.projet.resto2.dto.UserDto;
import com.projet.resto2.entity.Incident;
import com.projet.resto2.entity.User;
import com.projet.resto2.repository.IncidentRepository;
import com.projet.resto2.repository.UserRepository;
import com.projet.resto2.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final AuthService authService;

    @PostMapping("/add")
    public ResponseEntity<?> creerUser(@RequestBody User user) {

        if (authService.hasUserWithEmail(user.getEmail()))
            return new ResponseEntity<>("customer already exist with this email", HttpStatus.NOT_ACCEPTABLE);
        UserDto createdUserDto = authService.createUser(user);
        if (createdUserDto == null) return new ResponseEntity<>
                ("user not created, Come again later", HttpStatus.BAD_REQUEST);
        System.out.println("created");
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User userRequest) {

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());

            // Update other fields as needed
             userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>
                    ("user not found", HttpStatus.BAD_REQUEST);
        }


    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {

        System.out.println("deleting user id"+userId);
        Optional<User> optionalUser = userRepository.findById(userId);
        System.out.println();
        if (optionalUser.isPresent()) {

            System.out.println("deleting user");
            System.out.println(optionalUser.get().getEmail());
            userRepository.deleteById(userId);
            return new ResponseEntity<>(userId, HttpStatus.OK);
        } else {
            System.out.println("deleting user error");
            return new ResponseEntity<>
                    ("user not found", HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("/all")
    public ResponseEntity<?> getUsers() {
        System.out.println("getUsers");
        List<User> users = userRepository.findAll();

        System.out.println(users);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
