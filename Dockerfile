FROM openjdk:17-jdk-slim
ADD target/restau2-0.0.1-SNAPSHOT.jar restau2-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "restau2-0.0.1-SNAPSHOT.jar"]