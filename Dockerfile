FROM openjdk:8-jre-alpine

LABEL maintainer="jian.tan@daocloud.io"

ENV DIST_NAME=product \
    APP_VERSION=0.0.1-SNAPSHOT

COPY target/"$DIST_NAME-$APP_VERSION.jar" /"$DIST_NAME.jar"

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

EXPOSE 18080

ENTRYPOINT java -XX:+PrintFlagsFinal -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap $JAVA_OPTS -jar /$DIST_NAME.jar
