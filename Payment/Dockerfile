# First stage called "builder"
FROM openjdk:11-slim AS builder
WORKDIR /project
ADD . /project
RUN .mvnw clean package

#Second Stage
FROM openjdk:11-jre-slim
WORKDIR /app

# Copy only the Jar from the "builder" stage
COPY --from=builder /project/target/payment.jar /app 

# Run the Jar = Final image only containers Second stage
ENTRYPOINT ["java","-jar","payment.jar"]