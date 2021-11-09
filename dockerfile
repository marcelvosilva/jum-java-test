FROM openjdk:11
COPY target/java-0.0.1-SNAPSHOT.jar java-exercise-1.0.0.jar
ENTRYPOINT ["java","-jar","/java-exercise-1.0.0.jar"]