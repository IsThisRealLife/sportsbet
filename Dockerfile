FROM maven:3.6.3-openjdk-11-slim as BUILDER
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src
RUN mvn clean package -DskipTests
FROM openjdk:11.0.8-jre-slim
WORKDIR /sportsbet/
COPY --from=BUILDER /build/target/sportsbet-0.0.1-SNAPSHOT.jar /sportsbet/
CMD java -jar /sportsbet/sportsbet-0.0.1-SNAPSHOT.jar
