# Use the official OpenJDK 17 image (matching reference style)
FROM public.ecr.aws/amazoncorretto/amazoncorretto:17

# Set working directory
WORKDIR /app

# Copy the pre-built JAR from the target folder
COPY ./target/product-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose port
EXPOSE 8080

# Command to run - using the correct filename
CMD ["java", "-jar", "app.jar"]