FROM openjdk:17-jdk-slim

EXPOSE 5050

COPY target/cloudservice-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]