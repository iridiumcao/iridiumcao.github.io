# JVM Options of JDK 11

[Index](index_en.md)

2023-06-15

There are three main types of JVM options.

* Standard: Basic startup options such as -classpath that are common across HotSpot JVM implementations.
* -X: Nonstandard options used to configure common properties of the HotSpot JVM such as controlling the maximum heap size (-Xmx); these are not guaranteed to be supported on all HotSpot JVM implementations.
* -XX: Advanced options used to configure advanced properties of the HotSpot JVM. According to the documentation, these are subject to change without notice, but the Java team has a well-managed process for removing them.

(Copy from [here](https://blogs.oracle.com/javamagazine/post/the-best-hotspot-jvm-options-and-switches-for-java-11-through-java-17)).

> If you apply an advanced option, you always precede the option with -XX:. Similarly if you’re using a non-standard option, you’ll use -X. Standard options don’t prepend anything to the option. [Ref](https://www.jrebel.com/blog/jvm-options-cheat-sheet)

Full list JVM options of JDK11: [English](java11_en.txt), [Simplified Chinese](java11_zh_CN.txt)

## Example

```plaintext
# ps -ef | grep java
tomcat       520       1  2 Jun06 ?        00:02:21 /usr/lib/jvm/temurin-jdk/bin/java -Djava.util.logging.config.file=/usr/local/tomcat/conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager -Djdk.tls.ephemeralDHKeySize=2048 -Djava.protocol.handler.pkgs=org.apache.catalina.webresources -Dorg.apache.catalina.security.SecurityListener.UMASK=0027 -server -Xms512m -Xmx1536m -XX:+UseG1GC -verbose:gc -Dorg.apache.el.parser.SKIP_IDENTIFIER_CHECK=true -Djava.net.preferIPv4Stack=true -Dcom.sun.management.config.file=/usr/lib/jvm/temurin-jdk/jre/lib/management/management.properties -Dorg.apache.jasper.compiler.Parser.STRICT_QUOTE_ESCAPING=false -Dorg.jboss.logging.provider=jdk -Dlog4j2.is.webapp=true -Dlog4j2.garbagefreeThreadContextMap=true -Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/usr/local/tomcat/logs/heapdump.hprof -XX:MinHeapFreeRatio=10 -XX:MaxHeapFreeRatio=20 -Djava.locale.providers=JRE,SPI -Dignore.endorsed.dirs= -classpath /usr/local/tomcat/bin/bootstrap.jar:/usr/local/tomcat/bin/tomcat-juli.jar -Dcatalina.base=/usr/local/tomcat -Dcatalina.home=/usr/local/tomcat -Djava.io.tmpdir=/usr/local/tomcat/temp org.apache.catalina.startup.Bootstrap start
root        7273    6247  0 01:27 pts/0    00:00:00 grep --color=auto java
```

Tidy the JVM options as follows:

```plaintext
 -Djava.util.logging.config.file=/usr/local/tomcat/conf/logging.properties 
 -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager 
 -Djdk.tls.ephemeralDHKeySize=2048 
 -Djava.protocol.handler.pkgs=org.apache.catalina.webresources 
 -Dorg.apache.catalina.security.SecurityListener.UMASK=0027 
 -server 
 -Xms512m 
 -Xmx1536m 
 -XX:+UseG1GC 
 -verbose:gc 
 -Dorg.apache.el.parser.SKIP_IDENTIFIER_CHECK=true 
 -Djava.net.preferIPv4Stack=true 
 -Dcom.sun.management.config.file=/usr/lib/jvm/temurin-jdk/jre/lib/management/management.properties 
 -Dorg.apache.jasper.compiler.Parser.STRICT_QUOTE_ESCAPING=false 
 -Dorg.jboss.logging.provider=jdk 
 -Dlog4j2.is.webapp=true 
 -Dlog4j2.garbagefreeThreadContextMap=true 
 -Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector 
 -XX:+HeapDumpOnOutOfMemoryError 
 -XX:HeapDumpPath=/usr/local/tomcat/logs/heapdump.hprof 
 -XX:MinHeapFreeRatio=10 
 -XX:MaxHeapFreeRatio=20 
 -Djava.locale.providers=JRE,SPI 
 -Dignore.endorsed.dirs= 
 -classpath /usr/local/tomcat/bin/bootstrap.jar:/usr/local/tomcat/bin/tomcat-juli.jar 
 -Dcatalina.base=/usr/local/tomcat 
 -Dcatalina.home=/usr/local/tomcat 
 -Djava.io.tmpdir=/usr/local/tomcat/temp
```

## Some Changes from JDK 9 to JDK 11

`-XX:+UseG1GC` can be removed when using Java 11

> Starting from Java 9, the default garbage collector (GC) was changed from Parallel GC to G1 (see JEP 248). [Ref](https://docs.gigaspaces.com/rn/java11-guidelines.html)

Another Reference. [Best practice for JVM Tuning with G1 GC](https://backstage.forgerock.com/knowledge/kb/article/a75965340)

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
