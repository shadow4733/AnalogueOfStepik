package com.user_management_service.service;

import com.user_management_service.dto.Request.AuthenticationRequest;
import com.user_management_service.dto.Request.UpdatePasswordResponse;
import com.user_management_service.dto.Response.AuthenticationResponse;
import com.user_management_service.dto.Request.UserRequest;
import com.user_management_service.dto.Response.UpdatePasswordRequest;
import com.user_management_service.dto.Response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {
    UserResponse registerUser(UserRequest userRequest);
    AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest);
    UpdatePasswordResponse updateUserPasswordById(UpdatePasswordRequest updatePasswordRequest);
    UserResponse updateUserEmailById(UserRequest userRequest);
    void deleteUser(UUID id);
    void confirmEmail(String token);
    UserRequest getUser(UUID id);
    List<UserRequest> getAllUsers();
}
