FROM openjdk:8-jdk-alpine
COPY ./target/gs-spring-boot-docker-0.1.0.jar /usr/src/gs-spring-boot-docker/
WORKDIR /usr/src/gs-spring-boot-docker
EXPOSE 8080
CMD ["java", "-jar", "gs-spring-boot-docker-0.1.0.jar"]