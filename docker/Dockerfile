FROM adoptopenjdk/openjdk11:latest
MAINTAINER rmartinus
RUN mkdir -p /opt/app
WORKDIR /opt/app
COPY ./target/producer-0.0.1-SNAPSHOT.jar /opt/app
CMD ["java", "-Dspring.profiles.active=docker", "-jar", "/opt/app/producer-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
