FROM maven:3.9.16-amazoncorretto-25-alpine AS build

WORKDIR /app

COPY pom.xml .
COPY user-service/pom.xml user-service/pom.xml
RUN mvn -B -ntp dependency:go-offline -pl user-service -am

COPY user-service/src user-service/src
RUN mvn clean package -B -ntp -pl user-service -am -DskipTests -Dmaven.source.skip=true -Dmaven.javadoc.skip=true

FROM eclipse-temurin:25-jre-alpine

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /app

COPY --from=build --chown=appuser:appgroup /app/user-service/target/*.jar app.jar

EXPOSE 8080
USER appuser

ENTRYPOINT ["java", "-jar", "app.jar"]
