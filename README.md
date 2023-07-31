# todo-list-email-sender

Spring Boot application with two modules - Spring Mail and Spring AMQP.

With Spring AMQP, the application connects to RabbitMQ and creates a queue, then subscribes to messages received from the scheduler and backend service.

For each received message, whose contents are deserialized into a model instance, the Spring Mail module is used to send an email.
