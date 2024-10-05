# java版本，最好使用openjdk，而不是类似于Java:1.8 这种。
# 原因我也不知。
FROM openjdk:21
#署名
MAINTAINER lynz

COPY *.jar /app.jar
# 执行创建app.jar
EXPOSE 9001
# 向外暴露的接口，最好与项目yml文件中的端口一致
ENTRYPOINT ["java","-jar","app.jar"]
# 执行启动命令java -jar
