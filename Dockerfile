FROM openjdk:11-jre
COPY ./rest-api/target/rest-api-1.0-SNAPSHOT-jar-with-dependencies.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]