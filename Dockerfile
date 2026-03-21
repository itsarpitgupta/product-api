# Use OpenJDK 17 as base image
FROM eclipse-temurin:17-jre-alpine

# Create app directory
WORKDIR /app

# Copy the JAR file
COPY target/*.jar app.jar

# Expose port (change if your app uses different port)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]