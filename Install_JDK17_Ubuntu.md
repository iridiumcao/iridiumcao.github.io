# Install JDK17 on Ubuntu

If the OS does not have any JDK versions, it can be easy installed by a single command:

```shell
$ sudo apt install openjdk-17-jdk
```

The above is all.

Comfirm the version

```shell
$ java -version
openjdk version "17-ea" 2021-09-14
OpenJDK Runtime Environment (build 17-ea+19-Ubuntu-1ubuntu1)
OpenJDK 64-Bit Server VM (build 17-ea+19-Ubuntu-1ubuntu1, mixed mode, sharing)
```

Comfirm the packaged installed:

```
$ sudo apt list --installed  | grep openjdk

WARNING: apt does not have a stable CLI interface. Use with caution in scripts.

openjdk-17-jdk-headless/hirsute-updates,hirsute-security,now 17~19-1ubuntu1 amd64 [已安装，自动]
openjdk-17-jdk/hirsute-updates,hirsute-security,now 17~19-1ubuntu1 amd64 [已安装]
openjdk-17-jre-headless/hirsute-updates,hirsute-security,now 17~19-1ubuntu1 amd64 [已安装，自动]
openjdk-17-jre/hirsute-updates,hirsute-security,now 17~19-1ubuntu1 amd64 [已安装，自动]
```

If we have already installed other versions of JDK and we want to remove them, the following is how.

1. Find the packages

```
$ sudo apt list --installed  | grep openjdk

WARNING: apt does not have a stable CLI interface. Use with caution in scripts.

openjdk-11-jre-headless/hirsute-updates,hirsute-security,now 11.0.11+9-0ubuntu2 amd64 [已安装，自动]
openjdk-11-jre/hirsute-updates,hirsute-security,now 11.0.11+9-0ubuntu2 amd64 [已安装，自动]
...
```

2. Remove them

```
$ sudo apt purge openjdk-11-jre openjdk-11-jre-headless
$ sudo apt autoremove
```

We can remove the legacy versions before or after the new installation. We can also save multiply versions in a same OS.
