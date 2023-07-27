package pet.tasktrackeremailsender.mail.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import pet.tasktrackeremailsender.dto.EmailDto;
import pet.tasktrackeremailsender.mail.sender.EmailSender;

@Service
@RequiredArgsConstructor
public class EmailSenderService {

    private final EmailSender emailSender;
    @Value("${spring.mail.sender.email}")
    private String senderEmail;

    public void sendEmail(EmailDto emailDto) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(senderEmail);

        mailMessage.setTo(emailDto.getReceiverEmail());
        mailMessage.setSubject(emailDto.getSubject());
        mailMessage.setText(emailDto.getBody());

        emailSender.sendEmail(mailMessage);
    }
}
