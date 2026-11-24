# Java 的运算符

[Index](index_zh.md)

| 运算符 | 英文名称 | 说明 |
| --- | --- | --- |
| + | Addition or String concatenation | Java 的 + 既是加法运算符，也是字符串连接的运算符 |
| - | Subtraction or Negation | 减号 - 还可以做求负的符号 |
| % | Modulo | 进行求余运算 % 的两个数不必都是整数，如果为浮点数 float or double, 除剩下的即为余数，如果除数为0，则余数为 NaN |
| ++ | Increment | ++可以用于整数或浮点数 |
| = | Assignment | 赋值运算符。a = 3; 是一个赋值表达式，这个赋值表达式本身也是有值的，它的值就是右边被赋的值，即3. 因为这个特性，可以一次为多个变量赋值，如：int a, b, c;a = b = c = 3; //不推荐这么写 |
| & | Bitwise AND, Conditional AND | 位运算符 与, 不短路与 |
| \| | Bitwise OR, Conditional OR | 位运算符 或, 不短路或 |
| ~ | Bitwise NOT | 位运算符 否 |
| ^ | Bitwise XOR | 位运算符 异或 |
| << | Left shift | 位运算符 << move to left |
| >> | Arithmetic right shift | 位运算符 >> move to right 右移後，高位用符号位填充 |
| >>> | Logical right shift | 位运算符 >>> shift right with zero fill 右移後，高位总是用0填充 |
| == | Equality | 如果两个操作数都是数值类型，即使它们的类型不同，只要值相等，就返回 `true`。例如，`97 == 'a'` 返回 `true`。对可比较的引用，`==` 检查它们是否指向同一对象，或者是否都为 `null`。 |
| && | AND | 与 |
| \|\| | OR | 或 |
| ! | Logical NOT | ！ |
| ^ | Logical XOR | ^ |

## 补充说明

### 1. +

```plaintext
1 + 2 + "hello" -> 3hello
"hello" + 1 + 2 -> hello12
```

问题

```plaintext
a = a + b;
a += b;
```

上面两个式子的底层实现方式有什么区别？

### 2. 位移运算

位运算时，低于 `int` 的类型(`byte`, `short`, `char`)的操作数总是先自动转成`int`後再移位。

如果 `a` 是 `int`，`a >> b` 只取 `b` 的低 5 位作为位移量。例如，`a >> 33` 相当于 `a >> 1`。

如果 `a` 是 `long`，则只取 `b` 的低 6 位。例如，`a >> 65` 相当于 `a >> 1`。

### 3. 操作符类型

如果两个操作数都是数值类型，即使它们的类型不同，只要值相等，就返回 `true`
如 `97 == 'a'` 返回 `true`
对可比较的引用，`==` 检查它们是否指向同一对象，或者是否都为 `null`。

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
