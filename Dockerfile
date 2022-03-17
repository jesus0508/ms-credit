FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/ms-credit-*-SNAPSHOT.jar
COPY ${JAR_FILE} ms-credit.jar
RUN addgroup -S bootcampgroup && adduser -S bootcampuser -G bootcampgroup
RUN mkdir -p /opt/logs/ms-credits
RUN chown -R bootcampuser:bootcampgroup /opt/logs/ms-credits
USER bootcampuser:bootcampgroup
ENTRYPOINT ["java", "-jar", "/ms-credit.jar"]