FROM openjdk:11
COPY backend/target/dslearn-0.0.1-SNAPSHOT.jar /app/dslearn.jar
CMD ["java","-jar","/app/dslearn.jar"]