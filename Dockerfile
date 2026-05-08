FROM eclipse-temurin:25-jre-alpine
EXPOSE 8080
ADD target/banking-application.jar banking-application.jar
ENTRYPOINT ["java", "-jar", "banking-application.jar"]