copy websocket-dar.properties C:\bin\restcomm-sip-servlets-3.1.773-apache-tomcat-7.0.64\conf\dars\mobicents-dar.properties
rmdir C:\bin\restcomm-sip-servlets-3.1.773-apache-tomcat-7.0.64\webapps\my-sipapp /s /q
copy target\websockets-sip-servlet-3.0.0-SNAPSHOT.war C:\bin\restcomm-sip-servlets-3.1.773-apache-tomcat-7.0.64\webapps\websockets-sip-servlet.war