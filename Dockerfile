FROM amazoncorretto:17.0.7-alpine

MAINTAINER "Test"

ENV POSTGRES_IMAGE postgres:12.2-alpine

RUN apk --no-cache add curl jq

WORKDIR /app

COPY build /app

ENTRYPOINT ["java"]

CMD [ "-XX:+PrintFlagsFinal", "-XX:+UnlockExperimentalVMOptions", "-XshowSettings:vm", \
      "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app-service.jar" ]

EXPOSE 8080