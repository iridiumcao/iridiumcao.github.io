# 几个比较基础的逻辑运算概念

[返回目录](index.md)

The basic concepts of several logical operations

逻辑运算时布尔代数的内容，是计算机学科的重要理论基础之一。与，或，非，是三个最基本的运算，另外有几个符合运算：与非，或非，以及同或，异或，与或非。

## 与 AND

在布尔代理里，也称为逻辑乘。

| Expression  |  Description           |
|-------------|------------------------|
| P = A ∩ B   | 一般表达                |
| P = AB      | 布尔代数习惯的表达方式   |
| P = A && B  | C系程序语言表达         |
| P = A and B | SQL表达方式             |

两个操作数必须都为 true，结果才会输出 true

| A      |  B    |  P     |
|--------|-------|--------|
|  true  | true  | true   |
|  true  | false |  false |
|  false | true  |  false |
|  false | false |  false |

## 非 NOT

| Expression             | Description                                    |
|------------------------|-----------------------------------------|
| $P = \neg A$           | 专业表达                                 |
| $P = \overline{A}$     | 不少数学书中的表达，源自集合论中的表达方式  |
| P = !A                 | 程序语言通常用的表达方式                  |

| A     | P     |
|-------|-------|
|  true | false |
| false |  true |

## 或 OR

| Expression   | Description                   |
|---------------|------------------------|
| P = A ∪ B     | 一般表达               |
| P = A + B     | 布尔代数习惯的表达方式 |
| P = A \|\| B  | C系程序语言表达        |
| P = A or B    | SQL表达方式            |

两个操作数只要一个为 true，结果就会输出 true

|  A     |  B    |  P      |
|--------|-------|---------|
|  true  | true  |  true   |
|  true  | false |   true  |
|  false | true  |   true  |
|  false | false |  false  |

## 同或 XNOR

相同为真，相异为假。

$P = AB + \neg A\neg B$

可以参[维基百科的内容](https://zh.wikipedia.org/wiki/%E5%90%8C%E6%88%96%E9%97%A8).

## 异或 XOR

相异为真，相同为假。

$P = (\neg A)B + A(\neg B) = A \oplus B$

异或运算满足交换律，结合律，恒等律，归零率，自反律等，可以参[维基百科的内容](https://zh.wikipedia.org/wiki/%E9%80%BB%E8%BE%91%E5%BC%82%E6%88%96)。

## 与非 NAND

与了再非。

$P = \neg (AB) = (\neg A) \vee (\neg B)$

参[维基百科的内容](https://zh.wikipedia.org/wiki/%E8%B0%A2%E8%B4%B9%E5%B0%94%E7%AB%96%E7%BA%BF)。

## 或非 NOR

或了再非。

$P = \neg (A \vee B) = (\neg A)(\neg B)$

参[维基百科的内容](https://zh.wikipedia.org/wiki/%E9%80%BB%E8%BE%91%E6%88%96%E9%9D%9E)

## 与或非

先与，再或，再非。

$P = \neg (AB + BC)$

---

这篇文章是从[旧站](https://sites.google.com/site/iridiumsite/Home/others/mathematics/logic-oper)搬过来的。


<script>
MathJax = {
  tex: {
    inlineMath: [['$', '$'], ['\\(', '\\)']]
  }
};
</script>
<script id="MathJax-script" async
  src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-chtml.js">
</script>