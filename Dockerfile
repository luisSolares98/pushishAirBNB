FROM maven:3.6.3-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY . .
RUN mvn package -DskipTests


FROM openjdk:17-alpine
COPY --from=build /app/api/target/*.jar api.jar

RUN apk add --no-cache --update tzdata
ENV TZ=America/La_Paz

RUN cp /usr/share/zoneinfo/America/La_Paz /etc/localtime

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/api.jar", "--server.port=8080"]

