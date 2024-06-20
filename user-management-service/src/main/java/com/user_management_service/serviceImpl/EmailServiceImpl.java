package com.user_management_service.serviceImpl;

import com.user_management_service.model.User;
import com.user_management_service.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl {

    private final JavaMailSender mailSender;

    public void sendEmailVerificationToken(User user){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Подтверждение адреса электронной почты");
        message.setText("Для подтверждения адреса электронной почты перейдите по ссылке: " +
                "http://localhost:8080/api/v1/user/confirm-email?token=" + user.getEmailToken());
        mailSender.send(message);
    }

    public void sendAccountDeletionNotification(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Уведомление об удалении аккаунта");
        String text = "Уважаемый " + user.getUsername() + ",\n\n" +
                "Ваш аккаунт успешно удален.\n\n" +
                "Если вы не инициировали удаление аккаунта, обратитесь к администратору.\n\n" +
                "С уважением,\n" +
                "Ваша команда приложения";
        message.setText(text);
        mailSender.send(message);
    }
}