FROM eclipse-temurin:17.0.3_7-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8082
CMD ["java", "-jar", "app.jar"]
