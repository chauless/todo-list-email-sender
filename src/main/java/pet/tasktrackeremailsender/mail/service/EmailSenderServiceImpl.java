package pet.tasktrackeremailsender.mail.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import pet.tasktrackeremailsender.dto.EmailDto;
import pet.tasktrackeremailsender.mail.sender.EmailSender;

@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {

    private final EmailSender emailSender;
    private String senderEmail = "no-reply@tasktracker.com";

    public void sendEmail(EmailDto emailDto) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(senderEmail);

        mailMessage.setTo(emailDto.getReceiverEmail());
        mailMessage.setSubject(emailDto.getSubject());
        mailMessage.setText(emailDto.getBody());

        emailSender.sendEmail(mailMessage);
    }
}
