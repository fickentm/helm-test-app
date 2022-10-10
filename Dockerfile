# Building on top of this base image
FROM openjdk:11-jre-slim
COPY target/helm-test-app*.jar /usr/bin/helm-test-app.jar
CMD ["java", "-jar", "/usr/bin/helm-test-app.jar"]
