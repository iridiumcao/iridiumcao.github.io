# 用反射的方式调用main方法

[返回目录](index.md)

> 按：ChatGPT的回答是正确的，实验过程中，我也参考了其他文章，本文最后附上了链接。

问：用反射的方式调用main方法，如何操作？

## Answer from ChatGPT

可以通过Java反射机制来调用一个类的`main`方法。下面是一个示例代码：

```java
public class MainCaller {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.example.MyClass"); // 替换为实际的类名

        Method method = clazz.getDeclaredMethod("main", String[].class);
        String[] methodArgs = {"arg1", "arg2"}; // 传递给main方法的参数
        method.invoke(null, (Object) methodArgs);
    }
}
```

这个示例代码会通过反射来调用类`com.example.MyClass`的`main`方法。首先，通过`Class.forName`方法获取目标类的Class对象。然后，通过`Class.getDeclaredMethod`方法获取目标方法的`Method`对象。最后，通过`Method.invoke`方法来调用`main`方法并传递参数。

需要注意的是，`main`方法是一个静态方法，因此在调用它时不需要创建类的实例。在`invoke`方法中，第一个参数为`null`，表示调用静态方法时不需要传递任何实例对象。如果目标方法是非静态方法，第一个参数应该传递实例对象。

此外，传递给`main`方法的参数应该以字符串数组的形式传递，如上述代码中的`methodArgs`数组。

## 实验

[HelloWorld001.java](code/HelloWorld001.java)

```java
import java.lang.reflect.Method;

public class HelloWorld001 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("HelloWorld002");
        Method method = clazz.getMethod("main", String[].class);
        method.invoke(null, (Object) new String[] { "1", "2" });
    }
}
```

[HelloWorld002.java](code/HelloWorld002.java)

```java
public class HelloWorld002 {
    public static void main(String[] args) {
        System.out.println("Hello from World II");
    }
}
```

Test

```plaintext
$ javac HelloWorld001.java
$ javac HelloWorld002.java
$ java HelloWorld001
Hello from World II
```

Ref: 
* [反射，廖雪峰](https://www.liaoxuefeng.com/wiki/1252599548343744/1255945147512512)
* [用反射方式执行某个类中的main方法](https://blog.csdn.net/BruceLeeNumberOne/article/details/80905522)

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
        data-lang="zh-CN"
        crossorigin="anonymous"
        async>
</script>
