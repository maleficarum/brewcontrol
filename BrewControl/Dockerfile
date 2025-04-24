FROM openjdk:21-jdk

LABEL maintainer "Malleus Maleficarum <ivan@sinformex.com>"

WORKDIR /etc/application

ENV SPRING_PROFILES_ACTIVE=dev
#ENV CATALINA_OPTS="-Xms1024m -Xmx4096m -XX:MetaspaceSize=512m -	XX:MaxMetaspaceSize=512m -Xss512k -Dspring.profiles.active=prod"

COPY ./build/libs/BrewControl-0.0.1-SNAPSHOT.jar .

EXPOSE 80

CMD ["java", "-jar", "-Dserver.port=80", "jobseeker-0.0.1-SNAPSHOT.jar"]