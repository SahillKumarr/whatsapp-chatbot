# Use Java 21
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy all files
COPY . .

# Fix permission on mvnw
RUN chmod +x mvnw

# Build the app
RUN ./mvnw clean package -DskipTests

# Run the jar
EXPOSE 8080
CMD ["java", "-jar", "target/WhatsappChatbotApplication-0.0.1-SNAPSHOT.jar"]