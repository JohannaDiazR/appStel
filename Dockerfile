FROM amazoncorretto:17-alpine-jdk


COPY  target/appStel-0.0.1-SNAPSHOT.Jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]