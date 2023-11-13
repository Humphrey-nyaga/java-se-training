
#FROM quay.io/wildfly/wildfly:28.0.0.Final-jdk17
#LABEL authors="hum"
#ADD  ./target/
# Use the official Maven image as the build stage


# Build Stage
FROM maven:3.9-amazoncorretto-17 AS build
LABEL authors="Humphrey Nyaga"
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn clean compile package

# Final Stage
FROM maven:3.9-amazoncorretto-17
WORKDIR /app
COPY --from=build /app/target/java-se-training-1.0.0.jar java-se-training-1.0.0.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "java-se-training-1.0.0.jar"]

