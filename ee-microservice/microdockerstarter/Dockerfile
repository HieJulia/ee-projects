FROM payara/micro
WORKDIR /opt
MAINTAINER Hien nguyen <hienminhnguyen711@gmail.com>
EXPOSE 8087
ADD app.war application.war
ENTRYPOINT java -jar /opt/payara/payara-micro.jar --deploy application.war





