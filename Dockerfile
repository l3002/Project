FROM openjdk

COPY target/*.jar /app/

WORKDIR /app/

CMD [ "java", "-jar", "/app/*.jar"]
