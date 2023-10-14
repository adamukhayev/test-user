FROM amazoncorretto:17.0.1-alpine

WORKDIR /app

COPY "test-service.jar" "app-service.jar"

CMD ["java", "-jar", "app-service.jar"]