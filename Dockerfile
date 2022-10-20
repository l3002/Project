FROM openjdk:11
COPY src/main/java/com/app/* /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac GuessNum.java
CMD ["java", "GuessNum"]
