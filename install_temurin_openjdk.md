# Install Eclipse Adoptium Temurin OpenJDK

## CentOS 7

### Temurin OpenJDK 8

Add file ``/etc/yum.repos.d/adoptium.repo`` and write the following content

```text
[Adoptium]
name=Adoptium
baseurl=https://packages.adoptium.net/artifactory/rpm/centos/7/x86_64/
enabled=1
gpgcheck=1
gpgkey=https://packages.adoptium.net/artifactory/api/gpg/key/public
```

Install

```text
yum update # update if you haven't already
yum install temurin-8-jdk
# java -version
openjdk version "1.8.0_322"
OpenJDK Runtime Environment (Temurin)(build 1.8.0_322-b06)
OpenJDK 64-Bit Server VM (Temurin)(build 25.322-b06, mixed mode)
```

### Temurin OpenJDK 17

Add file ``/etc/yum.repos.d/adoptium.repo`` and write the following content

```text
[Adoptium]
name=Adoptium
baseurl=https://packages.adoptium.net/artifactory/rpm/centos/8/x86_64/
enabled=1
gpgcheck=1
gpgkey=https://packages.adoptium.net/artifactory/api/gpg/key/public
```

Install

```text
# yum update # update if you haven't already
# yum install temurin-17-jdk
# java -version
```

---

Ref:

1. <https://github.com/adoptium/website-v2/blob/main/src/asciidoc-pages/installation/linux.adoc>
