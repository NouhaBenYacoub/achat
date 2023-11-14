FROM openjdk:11-jdk
ARG JAR_URL
EXPOSE 8089
ADD $JAR_URL nouhabenyacoub-5erpbi3-achat.jar
ENTRYPOINT ["java","-jar","/nouhabenyacoub-5erpbi3-achat.jar"]