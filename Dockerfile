FROM openjdk:21
WORKDIR usr/local/app
COPY . .
COPY ./target/Library-0.0.1-SNAPSHOT.jar.jar Library-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","Library-0.0.1-SNAPSHOT.jar"]
