# 用 Tomcat 部署 Webapp 的一些说明

[Index](index.md)

按：本文原本是从旧站搬迁过来的，原先是基于 Tomcat 6 或 7 写的，目前最新版已经是11版了，旧的内容有一些已经不适用了，因此我又按 Tomcat 10 和 11 的情况编辑一遍，再发布。(2025.07.29)

Tomcat 支持两种方式部署 webapp，详述如下。

## 1. 部署到默认目录

目录位置：`{tomcat home}/webapps/`

这种部署方式很简单，可以把 webapp 的 war 包直接丢在这个目录下，tomcat 启动後会自动解压为同名文件夹，使应用正常运行。Tomcat 启动时会扫描 webapps 目录并加载应用，如果 WAR 文件或文件夹名称与已有应用冲突，可能导致部署失败。WAR 文件的命名应该避免特殊字符，推荐用小写字母。

也可以不打包，把结构良好的 webapp 手工放到 tomcat 目录下，tomcat 启动後，应用正常运行。

## 2. 部署到非默认目录

很多时候，webapp 需要部署到 tomcat 的外部目录，那么这时就需要对 tomcat 进行配置才能使 webapp 正常运行了。

假定 webapp 的目录是 `/home/iridium/deploy/helloworld`

有两种方法可以达到目的，示例如下：

### 2.1 创建单独的配置文件

在 `{tomcat home}/conf/Catalina/localhost/` 目录下创建一个 XML 文件，文件名称决定应用的虚拟路径（如 `helloworld.xml` 对应 `/helloworld`），内容如下：

```xml
<?xml version='1.0' encoding='utf-8'?>
<Context docBase="/home/iridium/deploy/helloworld"/>
```

配置文件的名称对应的是应用启动後的访问路径名称。如上，应用启动後，访问路径是：`http://localhost:8080/helloworld`, `/helloworld` 这个名称就来源于 `helloworld.xml` 这个文件的名称。

### 2.2 使用软连接

还有一个更简单的方法，就是通过软连接把外部目录 link 到 `tomcat/webapps` 下的子目录。**主要在 Linux 上使用**，Windows 系统需启用符号链接并设置 allowLinking='true' (实验结果表明 Tomcat 11 on Linux 默认支持)

```bash
cd tomcat/webapps
ln -s /home/iridium/deploy/helloworld demo
```

启动 Tomcat 后，可以通过浏览器访问 `http://localhost:8080/demo`

## 3. 其他

再举一个例子：

```xml
<Context displayName="CMVideo System"
         docBase="D:\cmvideo\webapp"
         workDir="work\Catalina\localhost\helloworld" 
         reloadable="true"
         allowLinking="true">
</Context>
```

参数说明：

| 参数 | 说明 |
| --- | --- |
| `workDir` |工作目录，默认位置是 `{tomcat home}/work/Catalina/localhost/{appName}`, 一般也不用怎么设置的，就默认的好了。|
| `allowLinking="true"` | 软连接的开关。启用符号链接，设为 `true` 时支持软连接（默认 `false`）|
| `reloadable` | 热部署开关。是指更新 Java class 文件後，是否自动加载。这个功能只对放在 `WEB-INF/classes` 或 `lib` 下的资源有效，不会自动重新加载 JSP、静态文件。Tomcat 对热部署支持很差，会大大增加服务器的开销。**在生产环境中，用 Tomcat，应该放弃热部署**，也就是将 `reloadable` 设置为 `false`。|
