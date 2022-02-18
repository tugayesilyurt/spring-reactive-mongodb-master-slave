FROM maven:3.6.3 AS maven
LABEL MAINTAINER="htyesilyurt@gmail.com"

WORKDIR /opt/spring-mongo-example
COPY . /opt/spring-mongo-example
RUN mvn clean install 

# For Java 11, 
FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=spring-mongo-example.jar

WORKDIR /opt/spring-mongo-example

COPY --from=maven /opt/spring-mongo-example/target/${JAR_FILE} /opt/spring-mongo-example/

ENTRYPOINT ["java","-jar","spring-mongo-example.jar"]