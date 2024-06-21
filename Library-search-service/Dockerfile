FROM openjdk:21
LABEL authors="abdulaxad"

COPY . .
COPY ./target/library-search-service.jar library-search-service.jar
EXPOSE 8070
CMD ["java","-jar","library-search-service.jar"]