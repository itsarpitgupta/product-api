# Use the official OpenJDK 17 image (matching reference style)
FROM openjdk:17

# Set working directory
WORKDIR /app

# Copy the pre-built JAR from the target folder
# This expects 'mvn clean package' to have run previously
COPY ./target/product-0.0.1-SNAPSHOT.jar /app.jar

# Expose port
EXPOSE 8080

# Command to run
CMD ["java", "-jar", "product-0.0.1-SNAPSHOT.jar"]