FROM openjdk:8-jre-slim

ARG http_proxy
ARG https_proxy
ENV HTTP_PROXY=$http_proxy
ENV HTTPS_PROXY=$https_proxy
ENV http_proxy=$HTTP_PROXY
ENV https_proxy=$HTTPS_PROXY

COPY simulator-0.0.1-SNAPSHOT.jar /simulator-0.0.1-SNAPSHOT.jar
COPY startup.sh /
RUN chmod 700 /startup.sh

ENTRYPOINT [ "sh", "-c", "/startup.sh"]

