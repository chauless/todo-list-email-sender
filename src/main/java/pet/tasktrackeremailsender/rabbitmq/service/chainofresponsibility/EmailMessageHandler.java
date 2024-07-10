package pet.tasktrackeremailsender.rabbitmq.service.chainofresponsibility;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import pet.tasktrackeremailsender.dto.EmailDto;
import pet.tasktrackeremailsender.mail.service.EmailSenderService;

import java.io.IOException;

public class EmailMessageHandler extends AbstractMessageHandler {

    private final EmailSenderService emailSenderService;
    private final ObjectMapper objectMapper;

    public EmailMessageHandler(EmailSenderService emailSenderService, ObjectMapper objectMapper) {
        this.emailSenderService = emailSenderService;
        this.objectMapper = objectMapper;
    }

    @Override
    public void handle(Message message) throws IOException {
        if (isEmailMessage(message)) {
            EmailDto emailDto = objectMapper.readValue(message.getBody(), EmailDto.class);
            emailSenderService.sendEmail(emailDto);
        } else {
            passToNext(message);
        }
    }

    private boolean isEmailMessage(Message message) {
        return message.getBody() != null;
    }
}

