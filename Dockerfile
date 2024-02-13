FROM openjdk:19
COPY build/libs/ms-auth-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java","-Dspring.profiles.active=prod", "-jar", "app.jar"]