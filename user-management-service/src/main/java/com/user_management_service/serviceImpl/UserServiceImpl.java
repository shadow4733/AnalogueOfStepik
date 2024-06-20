package com.user_management_service.serviceImpl;

import com.user_management_service.dto.AuthenticationRequest;
import com.user_management_service.dto.AuthenticationResponse;
import com.user_management_service.dto.UserRequest;
import com.user_management_service.dto.UserResponse;
import com.user_management_service.exception.*;
import com.user_management_service.model.User;
import com.user_management_service.model.enums.Role;
import com.user_management_service.repository.UserRepository;
import com.user_management_service.service.UserService;
import com.user_management_service.serviceImpl.utils.PasswordValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EmailServiceImpl emailService;
    private final PasswordEncoder passwordEncoder;
    private final PasswordValidator passwordValidator;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public UserResponse registerUser(UserRequest userRequest) {
        User user = new User();
        if(userRepository.existsByUsername(userRequest.username())){
            throw new UsernameAlreadyExistsException(userRequest.username());
        } else if (userRepository.existsByEmail(userRequest.email())) {
            throw new EmailAlreadyExistsException(userRequest.email());
        } else if (!userRequest.password().equals(userRequest.passwordConfirm())){
            throw new PasswordMissmatchException();
        } else if (!passwordValidator.isPasswordValid(userRequest.password())){
            throw new WeakPasswordException(userRequest.password());
        }
        user.setUsername(userRequest.username());
        user.setEmail(userRequest.email());
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        user.setRole(Role.USER);
        user.setEmailVerified(false);
        user.setCratedAt(LocalDateTime.now());
        String emailToken = UUID.randomUUID().toString();
        user.setEmailToken(emailToken);

        emailService.sendEmailVerificationToken(user);

        userRepository.save(user);

        logger.info("User registered");
        return null;
    }

    @Override
    public void confirmEmail(String token) {
        User user = userRepository.findByEmailToken(token);
        user.setEmailVerified(true);
        user.setEmailToken(null);
        userRepository.save(user);
        logger.info("User email confirmed");
    }

    @Override
    public AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest) {
        User user = userRepository.findByUsername(authenticationRequest.username());

        if(user == null){
            throw new UsernameDoesNotExist(authenticationRequest.username());
        } else if(!passwordEncoder.matches(authenticationRequest.password(),user.getPassword())){
            throw new PasswordIsIncorrect();
        } else if(!user.isEmailVerified()){
            throw new EmailHasNotBeenConfirmed();
        }

        logger.info("User authenticated");
        return null;
    }

    @Override
    public UserResponse updateUserPasswordById(UserRequest userRequest) {
        logger.info("Password updated");
        return null;
    }

    @Override
    public UserResponse updateUserEmailById(UserRequest userRequest) {
        logger.info("Email updated");
        return null;
    }

    @Override
    public void deleteUser(UUID id) {
        logger.info("User deleted");

    }

    @Override
    public UserRequest getUser(UUID id) {
        logger.info("User retrieved");
        return null;
    }

    @Override
    public List<UserRequest> getAllUsers() {
        logger.info("All users retrieved");
        return List.of();
    }
}