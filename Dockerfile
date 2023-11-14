FROM openjdk:11-jdk
ARG JAR_URL
EXPOSE 8089
ADD $JAR_URL nouha_benyacoub_5erpbi3_achat_1.jar
ENTRYPOINT ["java","-jar","/nouha_benyacoub_5erpbi3_achat_1.jar"]