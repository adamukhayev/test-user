FROM amazoncorretto:17.0.7-alpine

RUN apk --no-cache add curl jq

WORKDIR /app

COPY build/libs/test-service.jar app-service.jar

ENTRYPOINT ["java"]

CMD [ "-XX:+PrintFlagsFinal", "-XX:+UnlockExperimentalVMOptions", "-XshowSettings:vm", \
      "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app-service.jar" ]

EXPOSE 8080