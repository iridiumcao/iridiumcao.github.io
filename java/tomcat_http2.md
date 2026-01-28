# Tomcat 10 HTTP/2 Configuration

[Index](index_en.md)

## Configuring HTTP/2 in Tomcat 10

To enable HTTP/2 in Tomcat 10, configure the `{tomcat home}/conf/server.xml` file as follows:

```xml
<Connector port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol" maxThreads="150" SSLEnabled="true" maxParameterCount="1000">
    <UpgradeProtocol className="org.apache.coyote.http2.Http2Protocol" />
    <SSLHostConfig>
        <Certificate certificateKeystoreFile="conf/keystore.jks" certificateKeystorePassword="..." type="RSA" />
    </SSLHostConfig>
</Connector>
```

The `<UpgradeProtocol className="org.apache.coyote.http2.Http2Protocol" />` element enables HTTP/2 support in Tomcat 10 when HTTPS is properly configured. HTTP/2 in Tomcat 10 requires HTTPS to be properly configured. Refer to the [Tomcat 10 SSL/TLS Configuration Guide](https://tomcat.apache.org/tomcat-10.0-doc/ssl-howto.html) for details.

After enabling HTTP/2 in Tomcat 10, developers may encounter issues with JSP code that relies on the HTTP/1.1 `Host` header.

## Handling HTTP/2 Headers in JSP

The following JSP snippet will return `null`:

```jsp
<%= request.getHeader("host") %><br />
```

### Solution

Replace the snippet with

```jsp
<%= request.getServerName() + ":" + request.getServerPort() %>
```

To retrieve the equivalent information, use `request.getServerName() + ":" + request.getServerPort()`, which returns the server name and port derived from the request's metadata.

### Reason

In HTTP/2, the `:authority` pseudo-header replaces the HTTP/1.1 `Host` header, causing `request.getHeader("host")` to return `null` in JSP code. The `:authority` pseudo-header includes the authority portion of the target URI ([RFC 7540, Section 8.1.2.3](https://datatracker.ietf.org/doc/html/rfc7540#section-8.1.2.3)), used in place of the HTTP/1.1 `Host` header ([RFC 7540](https://datatracker.ietf.org/doc/html/rfc7540)).

<script src="https://giscus.app/client.js"
        data-repo="iridiumcao/iridiumcao.github.io"
        data-repo-id="MDEwOlJlcG9zaXRvcnkyOTUwNTIyODQ="
        data-category="Announcements"
        data-category-id="DIC_kwDOEZYj_M4Cxfqj"
        data-mapping="pathname"
        data-strict="0"
        data-reactions-enabled="1"
        data-emit-metadata="0"
        data-input-position="bottom"
        data-theme="preferred_color_scheme"
        data-lang="en"
        crossorigin="anonymous"
        async>
</script>
