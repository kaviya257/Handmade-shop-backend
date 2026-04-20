FROM eclipse-temurin:17

WORKDIR /app

COPY . .

RUN chmod +x mvnw && ./mvnw clean install -DskipTests

CMD ["sh", "-c", "java -jar target/*.jar"]
