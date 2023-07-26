package pet.tasktrackeremailsender.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pet.tasktrackeremailsender.rabbitmq.listener.RabbitMQListener;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {

    private final RabbitMQListener emailSendingListener;
    @Bean
    MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory ) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueues(emailSenderQueue());
        simpleMessageListenerContainer.setMessageListener(emailSendingListener);
        return simpleMessageListenerContainer;

    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }

    @Bean
    public Queue emailSenderQueue(){
        return new Queue(QueueName.EMAIL_SENDER_TASKS.toString(), false);
    }
}

