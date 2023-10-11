FROM openjdk:8-jre
ENV APP_PATH=/apps
WORKDIR $APP_PATH
COPY yingxue-category-1.0-SNAPSHOT.jar $APP_PATH/app.jar
EXPOSE 8981
ENTRYPOINT ["java","-jar"]
CMD ["app.jar"]