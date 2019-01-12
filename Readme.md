./mvnw clean install dockerfile:build

$ docker-machine ip
192.168.99.100

$ docker run -p 8080:8080 -t springio/gs-spring-boot-docker

$ docker run -e "SPRING_PROFILES_ACTIVE=dev" -p 8080:8080 -t springio/gs-spring-boot-docker