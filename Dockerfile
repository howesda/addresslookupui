FROM tomcat:8-jre8

# Create app directory
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

RUN rm -rf /usr/local/tomcat/webapps/ROOT

COPY target/addresslookup.war /usr/local/tomcat/webapps/ROOT.war

COPY docker/app.props /usr/src/app/app.props

COPY docker/setenv.sh /usr/local/tomcat/bin/setenv.sh
