FROM openjdk:8-jdk-alpine
COPY ./target/ab-short-url-0.1.0.jar /usr/src/ab-short-url/
WORKDIR /usr/src/ab-short-url
EXPOSE 8080
CMD ["java", "-jar", "ab-short-url-0.1.0.jar"]