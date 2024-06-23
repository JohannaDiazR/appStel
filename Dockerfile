FROM amazoncorretto:17-alpine-jdk // DE QUE iganen se parte

MAINTAINER //autoit
COPY  target/appStel-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java", "-war","/app.war"]