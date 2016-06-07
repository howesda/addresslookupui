FROM tomcat:8-jre8

RUN rm -rf /usr/local/tomcat/webapps/ROOT

COPY target/addresslookup.war /usr/local/tomcat/webapps/ROOT.war

ENV ADDRESS_SERVICE_URI=http://camel:8091
