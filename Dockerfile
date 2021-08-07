FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /usr/src/myapp/app.jar

WORKDIR /usr/src/myapp
ENTRYPOINT ["java","-jar","app.jar"]