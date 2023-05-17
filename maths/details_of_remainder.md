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

# 余数详情 Details of Remainder

[返回目录](index.md)

数学中的余数概念一般限定在整数范围，因为实数范围的余数在数学上用处有限，但程序语言的实现往往都是实数范围，引入了不小的复杂性，在编写代码时如果有用到余数的特性，一定要留心，一定要测试实际的实现方式。

## 定义

有关余数的定义，一般就局限于正整数范围。实际上，这个问题是属于实数域的，这点，可查看版维基百科的[余数](https://zh.wikipedia.org/wiki/%E4%BD%99%E6%95%B0)或 [Remainder](https://en.wikipedia.org/wiki/Remainder) 词条。综合维基百科的说法，这里给一个实数域的一般定义：

```plaintext
假定 a ∈ R, d ∈ R, d ≠ 0,  那么余数 r 满足这样的关系：
a = qd + r, q ∈ Z，且 0 ≤ |r| < |d|
以上，按传统方式，a 可称为被除数，d 可称为除数，q 可称为商。
按照以上定义，余数可以有一正一负两个，比如：
```

除法式子 (-42) / (-5) 的可以表达为

    -42 = 9×(-5) + 3  或   -42 = 8×(-5) + (-2)

即余数可能是3或-2。余数的这种不明确的特性，可能造成程序处理时的困惑，事实上，不同软件的处理确有不一样，参[Puzzle 01: Oddity](https://sites.google.com/site/iridiumsite/it/java/java-lang/book-java-puzzlers/puzzle-01-oddity)所附的表即可知。

## C, Java

在 C 和 Java 中，求余运算符号都是 %，但在 C 中，求余运算的范围是整数，而在 Java 中，扩展到了实数。这点详情参 [JLS 的说明](https://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.17.3)。（TODO 这里需要记录对 JLS 这部分的阅读笔记 以及 http://en.wikipedia.org/wiki/Modulo_operation）

附

* 维基百科中文版中关于普通整数和实数的部分是我在2009年1月翻译的（今天查看历史记录，吓了我一跳，原来是我自己翻的，时间过得太快了！）
* [Puzzle 01: Oddity](https://sites.google.com/site/iridiumsite/it/java/java-lang/book-java-puzzlers/puzzle-01-oddity)
* Modulo operation: <http://en.wikipedia.org/wiki/Modulo_operation>
* 本文自[Google Sites](https://sites.google.com/site/iridiumsite/it/algorithms/details-of-remainder)转移而来
