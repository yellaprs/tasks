FROM java:8-jre
MAINTAINER Sailendra <sqshq@sqshq.com>

ADD ./target/task-microservice.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/task-microservice.jar"]

EXPOSE 8080