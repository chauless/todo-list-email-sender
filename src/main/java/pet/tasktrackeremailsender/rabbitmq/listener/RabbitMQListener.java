package pet.tasktrackeremailsender.rabbitmq.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;
import pet.tasktrackeremailsender.rabbitmq.service.MessageProcessorService;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class RabbitMQListener implements MessageListener {

    private final MessageProcessorService messageProcessorService;

    @Override
    public void onMessage(Message message) {
        try {
            messageProcessorService.processMessage(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
