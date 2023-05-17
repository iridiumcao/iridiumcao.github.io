# Boolean 的构造器

[返回目录](index.md)

这是一个比较古怪的知识点，本身算不了什么。可能是这个构造器太过古怪，从 Java 9 开始，这个构造期已经标记为 `@Deprecated` 了，相应地，可以使用 `Boolean.parseBoolean(String s)` 来实现此功能，两个方法都支持 `null` 参数。

```java
Boolean b = new Boolean("abcd");
```

上面这句代码看起来好像不正常，但其实是「正常」的，但执行后，b 的值是 `false` or `true`?

查 API 文档，原来 Boobean 确实有这么个构造器，而且，当字串为 "true"（大小写无关）时，值为 `true`，其余情况，皆为 `false`。具体的 API 资料抄录如下：

public Boolean(String s)

Allocates a `Boolean` object representing the value `true` if the string argument is not `null` and is equal, ignoring case, to the string "true". Otherwise, allocate a `Boolean` object representing the value `false`. Examples:

`new Boolean("True")` produces a Boolean object that represents `true`.

`new Boolean("yes")` produces a Boolean object that represents `false`.

Parameters:

s - the string to be converted to a `Boolean`.

这个构造器直到 Java 19 还在，参[这里](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Boolean.html):

```plaintext
Boolean(String s)

Deprecated, for removal: This API element is subject to removal in a future version.
It is rarely appropriate to use this constructor.
```
