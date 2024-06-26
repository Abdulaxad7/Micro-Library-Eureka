FROM openjdk:21
LABEL authors="abdulaxad"
WORKDIR usr/local/app
COPY . .
COPY ./target/service-v.jar service-v.jar
EXPOSE 8761
CMD ["java","-jar","service-v.jar"]