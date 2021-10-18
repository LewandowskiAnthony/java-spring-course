FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#Command to run this dockerfile
#docker run -p 9000:9000 springio/gs-spring-boot-docker