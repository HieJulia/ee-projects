FROM payara/server-full
MAINTAINER Hien Nguyen<hienminhnguyen711@gmail.com>
COPY cargo-tracker.war /opt/payara41/glassfish/domains/domain1/autodeploy
EXPOSE 8080
CMD $PAYARA_PATH/bin/asadmin start-domain --verbose
