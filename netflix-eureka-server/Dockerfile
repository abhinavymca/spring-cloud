FROM openjdk:11
LABEL authors="abhgarg6"
COPY  build/libs/netflix-eureka-server.jar /usr/src/myapp/app.jar
WORKDIR /usr/src/myapp
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
