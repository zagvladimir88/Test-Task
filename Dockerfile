#FROM mysql:8.0
#ENV MYSQL_DATABASE=user_management_db \
#    MYSQL_USER=admin \
#    MYSQL_PASSWORD=1111 \
#    MYSQL_ROOT_PASSWORD=1111
#EXPOSE 3306
FROM openjdk:11-jre
COPY ./rest-api/target/rest-api-1.0-SNAPSHOT-jar-with-dependencies.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]