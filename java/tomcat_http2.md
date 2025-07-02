# Tomcat 10 Supports HTTP/2

[Index](index.md)

In Tomcat 10 configuration file `{tomcat home}/conf/server.xml`, it contains

```xml
<Connector port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol" maxThreads="150" SSLEnabled="true" maxParameterCount="1000">
    <UpgradeProtocol className="org.apache.coyote.http2.Http2Protocol" />
    <SSLHostConfig>
        <Certificate certificateKeystoreFile="conf/keystore.jks" certificateKeystorePassword="..." type="RSA" />
    </SSLHostConfig>
</Connector>
```

It contains

```xml
    <UpgradeProtocol className="org.apache.coyote.http2.Http2Protocol" />
```

which implicts that Tomcat 10 suports HTTP/2 by default.

Assume that we have configured HTTPS for Tomcat.

## HTTP Header "host" is `null`

The following JSP snippet will gets `null`

```jsp
<%= request.getHeader("host") %><br />
```

Solution. Replace the snippet to

```jsp
<%= request.getServerName() + ":" + request.getServerPort() %>
```

## Why

The :authority pseudo-header field includes the authority portion of the target URI [Section 8.1.2.3](https://tools.ietf.org/html/rfc7540#section-8.1.2.3). This field is used in place of the HTTP/1.1 Host header field. (Ref: [RFC 7540: Hypertext Transfer Protocol Version 2 (HTTP/2)](https://datatracker.ietf.org/doc/html/rfc7540))