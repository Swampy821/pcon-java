FROM niaquinto/gradle:latest

COPY ./build/libs /app/build/libs
COPY ./public /app/public

WORKDIR /app
ENTRYPOINT [ "java", "-jar" ]
CMD [ "build/libs/gs-rest-service-0.1.0.jar"]