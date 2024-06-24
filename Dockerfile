FROM amazoncorretto:17-alpine-jdk


COPY  target/appStel-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar","/app.jar"]
