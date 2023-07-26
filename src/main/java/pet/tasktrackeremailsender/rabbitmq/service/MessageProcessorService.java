package pet.tasktrackeremailsender.rabbitmq.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Message;
import pet.tasktrackeremailsender.dto.EmailDto;
import pet.tasktrackeremailsender.mail.service.EmailSenderService;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MessageProcessorService {

    private final EmailSenderService emailSenderService;
    private final ObjectMapper objectMapper;

    public void processMessage(Message message) throws IOException {
        EmailDto emailDto = objectMapper.readValue(message.getBody(), EmailDto.class);
        emailSenderService.sendEmail(emailDto);
    }
}
