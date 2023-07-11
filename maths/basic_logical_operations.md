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

# 最基本的几个逻辑运算概念

[返回目录](index.md)

The basic concepts of several logical operations

逻辑运算时布尔代数的内容，是计算机学科的重要理论基础之一。与，或，非，是三个最基本的运算，另外有几个符合运算：与非，或非，以及同或，异或，与或非。

## 与 AND

在布尔代理里，也称为逻辑乘。

| 表达式  |  说明                  |
|-------------|------------------------|
| P = A ∩ B   | 一般表达               |
| P = AB      | 布尔代数习惯的表达方式 |
| P = A && B  | C系程序语言表达        |
| P = A and B | SQL表达方式            |

两个操作数必须都为 true，结果才会输出 true

| A      |  B    |  P     |
|--------|-------|--------|
|  true  | true  | true   |
|  true  | false |  false |
|  false | true  |  false |
|  false | false |  false |

## 非 NOT

| Expression | Memo                                                        |
|------------|-------------------------------------------------------------|
| P = ~A     | （通常表示为A字母头上一横，但这里打不出这个符号），一般表达 |
| P = !A     | 程序语言通常用的表达方式                                    |

| A     | P     |
|-------|-------|
|  true | false |
| false |  true |

## 或 OR

| Description   | Memo                   |
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

## 同或

相同为真，相异为假。

P = AB + (not A)(not B)   可惜打不出正常的数学符号！可以参维基百科的内容。

https://zh.wikipedia.org/wiki/%E5%90%8C%E6%88%96%E9%97%A8

## 异或

相异为真，相同为假。

P = (not A)B + A(not B)   可惜打不出正常的数学符号！

异或运算满足交换律，结合律，恒等律，归零率，自反律等，可以参维基百科的内容。

https://zh.wikipedia.org/wiki/%E9%80%BB%E8%BE%91%E5%BC%82%E6%88%96

## 与非

与了再非。

P = not (AB) = (not A) or (not B)

https://zh.wikipedia.org/wiki/%E8%B0%A2%E8%B4%B9%E5%B0%94%E7%AB%96%E7%BA%BF

## 或非 NOR

或了再非。

P = not(A or B) = (not A)(not B)

https://zh.wikipedia.org/wiki/%E9%80%BB%E8%BE%91%E6%88%96%E9%9D%9E

## 与或非

先与，再或，再非。

P = not (AB + BC)

总参：

http://course.cug.edu.cn/21cn/%CA%FD%D7%D6%B5%E7%D7%D3%BC%BC%CA%F5%BB%F9%B4%A1/800x600/web/text_web/03/03020000.htm

---

这篇文章是从[旧站](https://sites.google.com/site/iridiumsite/Home/others/mathematics/logic-oper)搬过来的。
