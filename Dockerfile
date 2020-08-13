# we are extending everything from tomcat:8.0 image ...
FROM tomcat:latest
MAINTAINER Ali Rahighi
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
COPY /target/TashkilParvande.war /usr/local/tomcat/webapps/