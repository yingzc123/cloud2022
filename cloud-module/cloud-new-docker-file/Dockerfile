# 基础镜像使用java
FROM openjdk:17
#作者
MAINTAINER sanz
#把当前的jar 复制到当前目录下的app.jar
COPY target/*.jar  /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
