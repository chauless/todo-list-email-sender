package pet.tasktrackeremailsender.rabbitmq.service;

import org.springframework.amqp.core.Message;

import java.io.IOException;

public interface MessageProcessorService {
    /**
     * Processes the given message.
     *
     * This method builds a chain of responsibility for handling the message and then passes the message to it.
     * The chain of responsibility is built using the private buildChain() method.
     *
     * @param message the message to be processed
     * @throws IOException if an I/O error occurs during message processing
     */
    void processMessage(Message message) throws IOException;
}
