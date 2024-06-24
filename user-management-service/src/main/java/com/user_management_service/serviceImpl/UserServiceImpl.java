package com.user_management_service.serviceImpl;

import com.user_management_service.dto.Request.AuthenticationRequest;
import com.user_management_service.dto.Request.UpdatePasswordResponse;
import com.user_management_service.dto.Response.AuthenticationResponse;
import com.user_management_service.dto.Request.UserRequest;
import com.user_management_service.dto.Response.UpdatePasswordRequest;
import com.user_management_service.dto.Response.UserResponse;
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
        String resetToken = UUID.randomUUID().toString();
        user.setResetPasswordToken(resetToken);

        emailService.sendEmailVerificationToken(user);

        userRepository.save(user);

        logger.info("User registered");
        return new UserResponse(
                user.getUsername(),
                user.getEmail(),
                user.getRole().toString(),
                user.isEmailVerified(),
                user.getEmailToken(),
                user.getCratedAt().toString()
        );
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
        return new AuthenticationResponse(
                user.getUsername(),
                user.getPassword()
        );
    }

    @Override
    public UpdatePasswordResponse updateUserPasswordById(UpdatePasswordRequest updatePasswordRequest) {
        User user = userRepository.findById(updatePasswordRequest.userId())
                .orElseThrow(() -> new UserNotFoundException(updatePasswordRequest.userId()));

        if (!user.getResetPasswordToken().equals(updatePasswordRequest.token())) {
            throw new InvalidResetPasswordTokenException();
        } else if (!passwordEncoder.matches(updatePasswordRequest.currentPassword(), user.getPassword())) {
            throw new IncorrectCurrentPasswordException();
        } else if (!passwordValidator.isPasswordValid(updatePasswordRequest.newPassword())){
            throw new WeakPasswordException(updatePasswordRequest.newPassword());
        }

        user.setPassword(passwordEncoder.encode(updatePasswordRequest.newPassword()));

        user.setResetPasswordToken(null);

        userRepository.save(user);

        logger.info("Password updated for user with ID: {}", user.getId());

        return new UpdatePasswordResponse(
                user.getUsername(),
                user.getEmail(),
                user.getRole().toString()
        );
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