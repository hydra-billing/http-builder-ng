FROM gradle:4.3.1-jdk8
USER gradle
COPY --chown=gradle . /app/

WORKDIR /app

RUN gradle build --no-daemon
