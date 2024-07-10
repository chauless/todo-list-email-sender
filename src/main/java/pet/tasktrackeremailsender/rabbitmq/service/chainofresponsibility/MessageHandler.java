package pet.tasktrackeremailsender.rabbitmq.service.chainofresponsibility;

import org.springframework.amqp.core.Message;

import java.io.IOException;

public interface MessageHandler {
    void setNext(MessageHandler handler);
    void handle(Message message) throws IOException;
}
