package com.projet.resto2.services.auth;


import com.projet.resto2.dto.SignupRequest;
import com.projet.resto2.dto.UserDto;
import com.projet.resto2.entity.User;
import com.projet.resto2.enums.UserRole;
import com.projet.resto2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;




    public void createAdminAccount() {
        User adminAccount = userRepository.findByUserRole(UserRole.ADMIN);
        if (adminAccount == null) {
            User newAdminAccount = new User();
            newAdminAccount.setName("ADMIN");
            newAdminAccount.setEmail("admin@gmail.com");
            newAdminAccount.setPassword(new BCryptPasswordEncoder().encode("admin"));
            newAdminAccount.setUserRole(UserRole.ADMIN);
            userRepository.save(newAdminAccount);
            System.out.println("admin account created successfully");
        }


    }

    @Override
    public UserDto createUser(SignupRequest signupRequest) {
         User user= new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setUserRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);
        UserDto UserDto = new UserDto();
        UserDto.setId(createdUser.getId());



        return UserDto;

    }

    @Override
    public UserDto createUser(User userRequest) {
        User user= new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userRequest.getPassword()));
        user.setUserRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);
        UserDto UserDto = new UserDto();
        UserDto.setId(createdUser.getId());



        return UserDto;

    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
