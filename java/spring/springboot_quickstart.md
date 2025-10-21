# Quick SpringBoot

To write a stub Spring Boot is so easy. It does not make sense, but it does make sense for verify if the environment supports Spring Boot.

## Environment

The enironment is simple, it just needs JDK, maven and IDE.

### JDK

```plaintext
$ java --version
openjdk 25 2025-09-16 LTS
OpenJDK Runtime Environment Temurin-25+36 (build 25+36-LTS)
OpenJDK 64-Bit Server VM Temurin-25+36 (build 25+36-LTS, mixed mode, sharing)
```

#### Maven

```plaintext
$ mvn --version
Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: D:\Programs\apache-maven-3.9.9
Java version: 25, vendor: Eclipse Adoptium, runtime: D:\Programs\jdk-25+36
Default locale: zh_CN, platform encoding: UTF-8
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
```

### IDE: VS Code

An IDE or an code editor is needed too. For a quick demo, I use VS Code here.

Install the following tools after your VS Code is installed.

- https://spring.io/tools
- https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack


## Create the project following the Tutorial

Tutorial: https://spring.io/quickstart

### Step 1

https://start.spring.io/

```bash
mvn clean compile
mvn spring-boot:run
```

http://localhost:8080/hello