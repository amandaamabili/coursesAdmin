FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/courses-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

#
#FROM openjdk:11-jre-slim-buster
#ARG JAR_FILE=build/libs/sales-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]