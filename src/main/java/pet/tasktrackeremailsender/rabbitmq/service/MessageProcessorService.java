package pet.tasktrackeremailsender.rabbitmq.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Message;
import pet.tasktrackeremailsender.dto.EmailDto;
import pet.tasktrackeremailsender.mail.service.EmailSenderService;
import pet.tasktrackeremailsender.rabbitmq.service.chainofresponsibility.EmailMessageHandler;
import pet.tasktrackeremailsender.rabbitmq.service.chainofresponsibility.MessageHandler;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MessageProcessorService {

    private final EmailSenderService emailSenderService;
    private final ObjectMapper objectMapper;

    private MessageHandler buildChain() {
        MessageHandler emailHandler = new EmailMessageHandler(emailSenderService, objectMapper);

        return emailHandler;
    }

    public void processMessage(Message message) throws IOException {
        MessageHandler handlerChain = buildChain();
        handlerChain.handle(message);
    }
}
