FROM amazoncorretto:8-alpine3.17-jre

EXPOSE 8080

COPY ./target/java-maven-app-*.jar /usr/app/
WORKDIR /usr/app

<<<<<<< HEAD
CMD java -jar java-maven-app-*.jar
=======
ENTRYPOINT ["java", "-jar", "java-maven-app-1.0-SNAPSHOT.jar"]
>>>>>>> df26e1c46abb21e5fa10cdabc092a38270fdaf3e
