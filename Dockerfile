FROM openjdk

COPY target/*.jar /app/

WORKDIR /app/

EXPOSE 8090

ENTRYPOINT [ "java", "-jar", "/app/*.jar"]
