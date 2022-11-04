FROM onap/integration-java11:10.0.0

WORKDIR /home/onap

USER onap

COPY --chown=onap:onap ./simulator-0.0.1*jar /home/onap/simulator-0.0.1.jar
COPY --chown=onap:onap ./startup.sh /home/onap/startup.sh

RUN chmod 700 /home/onap/startup.sh

ENTRYPOINT [ "sh", "-c", "/home/onap/startup.sh"]
