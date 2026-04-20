FROM eclipse-temurin:17

WORKDIR /app

COPY . .

RUN chmod +x mvnw && ./mvnw clean install -DskipTests

CMD ["java", "-jar", "target/*.jar"]
