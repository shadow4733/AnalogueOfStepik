package com.user_management_service.service;

import com.user_management_service.model.User;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendEmailVerificationToken(User user);

}
