package pet.tasktrackeremailsender.mail.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSender {

    private final JavaMailSender emailSender;

    public void sendEmail(SimpleMailMessage mailMessage) {
        emailSender.send(mailMessage);
    }
}
