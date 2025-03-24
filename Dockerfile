FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/gasolinera-0.0.1.jar
COPY ${JAR_FILE} app_gasolinera.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_gasolinera.jar"]