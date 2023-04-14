FROM openjdk:11-slim AS builder
WORKDIR /project
ADD . /project
RUN .mvnw clean package

FROM openjdk:11-jre-slim
WORKDIR /app

COPY --from=builder /project/target/flight-search.jar /app

ENTRYPOINT ["java","-jar","flight-search.jar"]
