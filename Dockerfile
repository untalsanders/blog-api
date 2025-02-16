FROM gradle:8.12.1-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM azul/zulu-openjdk-alpine:17
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/*.jar /opt/app/app.jar
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]
