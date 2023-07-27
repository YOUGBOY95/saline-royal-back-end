# Start with a base image containing Java runtime
FROM adoptopenjdk:17-jdk-hotspot

# Set the working directory inside the container
WORKDIR /

# Copy the packaged JAR file into the container
COPY target/saline-API-0.0.1.jar saline-API-0.0.1.jar

# Expose the port that the application will run on
EXPOSE 8080

# Specify the command to run the application
CMD ["java", "-jar", "saline-API-0.0.1.jar"]