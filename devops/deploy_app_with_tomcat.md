# 用 Tomcat 部署 Webapp 的两种方式

[Index](index.md)

Tomcat 支持两种方式部署 webapp，详述如下。

## 1. 部署到默认目录

目录位置：`{tomcat home}/webapps/`
这种部署方式很简单，可以把 webapp 的 war 包直接丢在这个目录下，tomcat 启动後会自动解压为同名文件夹，使工程正常运行。也可以不打包，把结构良好的 webapp 手工放到 tomcat 目录下，tomcat 启动後，工程正常运行。

## 2. 部署到非默认目录

很多时候，webapp 需要部署到 tomcat 的外部目录，那么这时就需要对 tomcat 进行配置才能使 webapp 正常运行了。
配置示例如下：
假定 webapp 的目录是 `/home/iridium/deploy/helloworld`
编辑 `{tomcat home}/conf/server.xml`，在 Host 元素之内添加如下内容：

```xml
<Context path="/helloworld" docBase="/home/iridium/deoply/helloworld"/>
```

当然，也可以不修改 server.xml，那么就需要在 `{tomcat home}/conf/Catalina/localhost/` 建立一个以虚拟路径名命名的 XML 文件，如：`helloworld.xml`，内容如下：

```xml
<?xml version='1.0' encoding='utf-8'?>
<Context path="/helloworld" docBase="/home/iridium/deoply/helloworld"/>
```

文件名要和 path 的值一致。如果 `{tomcat home}/conf/Catalina/localhost/` 目录不存在，新建一下即可。

其中，path 是工程启动後的访问路径名称，如上，工程启动後，访问路径可能是：`http://localhost:8080/helloworld`

附1：软连接及热部署

如果要支持软连接，则需要在 Context 增加一个属性 `allowLinking="true"`，即：

```xml
<Context path="/helloworld" docBase="/home/iridium/deoply/helloworld" allowLinking="true"/>
```

Tomcat 默认是不支持软连接的，需要时，必须设置 `allowLinking` 的值。

再举一个在 Windows 中的例子：

```xml
<Context displayName="CMVideo System"
    docBase="D:\cmvideo\webapp" path="/helloworld" reloadable="true"  workDir="work\Catalina\localhost\helloworld" allowLinking="true">
</Context>
```

这里有两个参数 `reloadable` 和 `workDir` 前面没有提到。`reloadable` 是指更新 class 文件後，是否自动加载，即所谓的热部署，但 Tomcat 对热部署支持极不友好，即使增加属性 `reloadable="true"` 也不理想，我的经验是效果很差，可能是开发机配置比较低，不过这个功能如果打开，会增大服务器开销，一般还是不要好了——本来效果也不好么，呵呵。在生产环境中，用 tomcat，应该放弃热部署，也就是将 reloadable 设置为 false. 对于 workDir，一般也不用怎么设置的，就默认的好了。

关于让 Tomcat 支持软连接，还可以参考这里：<http://blog.csdn.net/kongxx/archive/2010/10/19/5951228.aspx>

附2：增量部署

对 Web 应用，如果修改了少量几个类，可以将编译後的 class 文件直接更新到 `{web app home}/WEB-INF/classes` 对应目录下，然後重启 Tomcat. 如果是 JSP 文件，更新後，不用重启 Tomcat.
