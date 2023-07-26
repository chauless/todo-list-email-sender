package pet.tasktrackeremailsender.mail.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import pet.tasktrackeremailsender.dto.EmailDto;
import pet.tasktrackeremailsender.mail.sender.EmailSender;

@Service
@RequiredArgsConstructor
public class EmailSenderService {

    private final EmailSender emailSender;
    private final String senderEmail = "noreply@tasktracker.com";

    public void sendEmail(EmailDto emailDto) {
            SimpleMailMessage email = new SimpleMailMessage();
            email.setFrom(senderEmail);
            email.setTo(emailDto.getReceiverEmail());
            email.setSubject(emailDto.getSubject());
            email.setText(emailDto.getBody());

            emailSender.sendEmail(email);
    }
}
