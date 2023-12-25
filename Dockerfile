FROM openjdk:17-jdk-slim
MAINTAINER abdul12527
COPY target/SATStudentDetailsMannger-0.0.1-SNAPSHOT.jar SATStudentDetailsMannger-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "SATStudentDetailsMannger-0.0.1-SNAPSHOT.jar"]