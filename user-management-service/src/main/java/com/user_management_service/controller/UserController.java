package com.user_management_service.controller;

import com.user_management_service.dto.Request.AuthenticationRequest;
import com.user_management_service.dto.Request.UpdatePasswordResponse;
import com.user_management_service.dto.Response.AuthenticationResponse;
import com.user_management_service.dto.Request.UserRequest;
import com.user_management_service.dto.Response.UpdatePasswordRequest;
import com.user_management_service.exception.EmailHasNotBeenConfirmed;
import com.user_management_service.exception.PasswordIsIncorrect;
import com.user_management_service.exception.UsernameDoesNotExist;
import com.user_management_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest) {
        try {
            userService.registerUser(userRequest);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to register user: " + e.getMessage());
        }
    }

    @GetMapping("/confirm-email")
    public ResponseEntity<?> confirmEmail(@RequestParam("token") String token) {
        try {
            userService.confirmEmail(token);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid email confirmation token");
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            AuthenticationResponse authenticationResponse = userService.authenticateUser(authenticationRequest);
            return ResponseEntity.ok(authenticationResponse);
        } catch (UsernameDoesNotExist e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        } catch (PasswordIsIncorrect e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        } catch (EmailHasNotBeenConfirmed e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<UpdatePasswordResponse> resetPassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        UpdatePasswordResponse updatePasswordResponse = userService.updateUserPasswordById(updatePasswordRequest);
        return ResponseEntity.ok(updatePasswordResponse);
    }

}
