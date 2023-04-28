FROM gradle:7-jdk11 AS build


COPY . /app
WORKDIR /app

RUN gradle build --no-daemon

FROM openjdk:11-jre-slim

WORKDIR /app
COPY --from=build /app/transformation/build/lib/transformation-all.jar atol.jar

CMD ["java", "-jar", "atol.jar"]
