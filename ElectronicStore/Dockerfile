# Use the official Maven image to build the app
FROM openjdk:17-alpine



# Argument for the JAR file location
ARG JAR_FILE=target/*.jar

# Copy the JAR file to the container
COPY ${JAR_FILE} app.jar



# Entry point for the application
ENTRYPOINT ["java", "-jar", "/app.jar"]

