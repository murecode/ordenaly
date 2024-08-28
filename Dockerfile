# JDK OFFICIAL IMAGE
FROM eclipse-temurin:21.0.4_7-jdk

# CONTAINER PORT (informative only)
EXPOSE 8081

# SET CONTAINER WORKDIRECTORY
WORKDIR /root

# COPY ORIGINAL CONFIG FILES AND PUT INSIDE CONTAINER
COPY ./pom.xml /rootgit
COPY ./.mvn /root/mvn
COPY ./mvnw /root

# DOWNLOAD THE NECESSARY DEPENDENCIES
RUN ./mvnw dependency:go-offline

# COPY RESOURCE CODE INSIDE CONTAINER
COPY ./src /root/src

# RUN COMMAND FOR BUILD APP
RUN ./mvnw clean install -DskipTests

# SET THE COMMAND TO ALWAYS START THE APPLICATION WHEN THE CONTAINER HAS STARTED
ENTRYPOINT ["java", "-jar", "/root/target/ordenaly-0.0.1-SNAPSHOT.jar"]

