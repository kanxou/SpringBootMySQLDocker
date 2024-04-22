# Use a recent, slim Java 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy your compiled JAR file (assuming target/your-app.jar)
COPY target/*.jar app.jar

# Expose the port your Spring Boot application listens on (replace 8080 with your actual port)
EXPOSE 8080

# Command to run your Spring Boot application
CMD ["java", "-jar", "app.jar","--spring.profiles.active=docker"]
