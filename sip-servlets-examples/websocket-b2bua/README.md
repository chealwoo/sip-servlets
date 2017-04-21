# SIP - Kurento Connection

### compile
mvn clean compile war:war

### Demo
* Open https://www.doubango.org/sipml5/call.htm?svn=250 and fill fields with the following.
```
Display Name: web01
Private Identity*: web01
Public Identity*: sip:web01@10.22.111.87
Password:
Realm*:10.22.111.87
```
* Click on Expert mode then fill out them. 
```
WebSocket Server URL[2]: ws://10.22.111.87:5082
SIP outbound Proxy URL[3]: udp://10.22.111.87:5080
```
* On second 
```
Display Name: web02
Private Identity*: web02
Public Identity*: sip:web02@10.22.111.87
Password:
Realm*:10.22.111.87
```

* Then Click on LogIn,

** Error: SecurityError: Failed to construct 'WebSocket': An insecure WebSocket connection may not be initiated from a page loaded over HTTPS.
> @andreinitescu do you see a shield icon in the address bar?
> - Click on shield and allow loading.






## Configuration
### Tomcat
#### Enable SSL (https) at 8443
* build .keystore (https://tomcat.apache.org/tomcat-7.0-doc/ssl-howto.html)
* Change /conf/server.xml
```
	<!-- Define a SSL Coyote HTTP/1.1 Connector on port 8443 -->
<Connector
           protocol="org.apache.coyote.http11.Http11NioProtocol"
           port="8443" maxThreads="200"
           scheme="https" secure="true" SSLEnabled="true"
           keystoreFile="${user.home}/.keystore" keystorePass="password"
           clientAuth="false" sslProtocol="TLS"/>
```

#### Add remote debugging

### Reference
* (https://doc-kurento.readthedocs.io/en/latest/_static/langdoc/javadoc/org/kurento/client/package-summary.html)


### Concepts need to understand

#### WebSocket
* [How to build Java WebSocket Applications Using the JSR 356 API] (https://blog.openshift.com/how-to-build-java-websocket-applications-using-the-jsr-356-api/)
* [Tomcat example source] (http://svn.apache.org/viewvc/tomcat/trunk/webapps/examples/)
#### Kurento
* [Kurento document] (http://doc-kurento.readthedocs.io/en/stable/index.html)
* [Kurento room] (http://doc-kurento-room.readthedocs.io/en/stable/index.html)
* [elasticRTC Tutorial] (https://www.elasticrtc.com/docs/stable/tutorials.html)
* [kurento › RTP to WebRTC] (https://groups.google.com/forum/#!topic/kurento/CJV2lNnlDtE)
#### Kurento Local System
* [WebCall Player] (https://10.22.111.87:8442/)

