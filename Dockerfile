FROM maven:3.8.6-openjdk-18-slim
LABEL author="Matvei Morenkov"

WORKDIR /app
COPY target/task-tracker-email-sender-0.0.1-SNAPSHOT.jar /app/task-tracker-email-sender.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "task-tracker-email-sender.jar"]