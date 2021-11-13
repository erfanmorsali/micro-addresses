FROM openjdk
ADD target/micro-addresses-0.0.1-SNAPSHOT.jar  micro-addresses-0.0.1-SNAPSHOT.jar
EXPOSE 8002

ENTRYPOINT ["java" , "-jar" , "micro-addresses-0.0.1-SNAPSHOT.jar"]