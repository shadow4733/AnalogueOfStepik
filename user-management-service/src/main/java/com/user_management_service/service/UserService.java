package com.user_management_service.service;

import com.user_management_service.dto.AuthenticationRequest;
import com.user_management_service.dto.AuthenticationResponse;
import com.user_management_service.dto.UserRequest;
import com.user_management_service.dto.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {
    UserResponse registerUser(UserRequest userRequest);
    AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest);
    UserResponse updateUserPasswordById(UserRequest userRequest);
    UserResponse updateUserEmailById(UserRequest userRequest);
    void deleteUser(UUID id);
    void confirmEmail(String token);
    UserRequest getUser(UUID id);
    List<UserRequest> getAllUsers();
}
