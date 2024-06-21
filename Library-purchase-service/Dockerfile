FROM openjdk:21
LABEL authors="abdulaxad"
WORKDIR usr/local/app
COPY . .
COPY ./target/library-purchase-service.jar library-purchase-service.jar
EXPOSE 8090
CMD ["java","-jar","library-purchase-service.jar"]