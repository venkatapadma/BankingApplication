FROM openjdk:8
Expose 8080
ADD target/banking-application.jar banking-application.jar
ENTRYPOINT ["java", "-jar", "banking-application.jar"]