FROM gradle:jdk17-alpine AS build


COPY . /app
WORKDIR /app

RUN gradle build --no-daemon

FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=build /app/transformation/build/libs/transformation-all.jar yamtl-java.jar

CMD ["java", "-jar", "yamtl-java.jar"]
