FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

ADD target/AuthorizationService-0.0.1-SNAPSHOT.jar AuthorizationService.jar

ENTRYPOINT ["java","-jar","/myapp.jar"]