package pet.tasktrackeremailsender.rabbitmq.service.chainofresponsibility;

import org.springframework.amqp.core.Message;

import java.io.IOException;

public abstract class AbstractMessageHandler implements MessageHandler {

    private MessageHandler nextHandler;

    @Override
    public void setNext(MessageHandler handler) {
        this.nextHandler = handler;
    }

    protected void passToNext(Message message) throws IOException {
        if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}
