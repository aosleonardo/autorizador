# Build Stage
FROM maven:3.9.7-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests -Dmaven.test.skip=true -Dmaven.build.dest=/app/target

# Final Stage
FROM openjdk:21
WORKDIR /app
COPY --from=build /app/target/autorizador-0.0.1-SNAPSHOT.jar /app/app.jar
COPY src/main/resources/application-docker.properties /app/application-docker.properties
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]