# First stage called "builder"
FROM openjdk:11-jdk as builder
WORKDIR /project
ADD . /project
RUN ./mvnw package

#Second stage
FROM openjdk:11-jre-slim
WORKDIR /app

# Copy only the Jar from the "builder" stage
COPY --from=builder /project/target/gateway.jar /app

# Run the Jar = Final image only containers Second stage
ENTRYPOINT ["java","-jar","gateway.jar"]