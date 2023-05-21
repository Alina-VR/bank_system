FROM maven:3.9.1-eclipse-temurin-17-focal

RUN mvn clean package

CMD ["java -jar target/bankSystem-1.0.0-jar-with-dependencies.jar"]

