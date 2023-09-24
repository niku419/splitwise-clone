FROM eclipse-temurin:17-jdk-jammy
EXPOSE 8080
VOLUME /tmp
COPY target/splitwise-backend-docker.jar splitwise-backend-docker.jar
ENTRYPOINT ["java","-jar","/splitwise-backend-docker.jar"]