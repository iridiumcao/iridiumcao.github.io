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

# 极限 Limit

考虑到ChatGPT的回答质量不高，这次以维基百科的资料作为学习起点。

## 生活体验

极限，从生活体验上讲，往往指某个方面的最大，最小，最高，最低，最多，最少的某个量，是一个无法超越的量，比如

* 张三一顿最多吃碗，换句话说，张三吃饭的**极限**（上限）是3碗，不能再多了。
* 李四最短能跑5公里，换句话说，李四跑步距离起步的**极限**（下限）是5公里，不能再少了。
* 王五最近遇到很多事，快到心理承受**极限**了，不能再烦他了，否则可能会出问题。

## 定义

参[维基百科·极限](https://zh.wikipedia.org/wiki/%E6%9E%81%E9%99%90)中列出的相关条目。有关[拓扑学](https://zh.wikipedia.org/wiki/%E7%B6%B2_(%E6%95%B8%E5%AD%B8)#%E7%B6%B2%E7%9A%84%E6%A5%B5%E9%99%90)和[范畴论](https://zh.wikipedia.org/wiki/%E6%9E%81%E9%99%90_(%E8%8C%83%E7%95%B4%E8%AE%BA))的中的极限定义，我现在几乎完全不能理解，这里先不强行记录了（不献丑）。

### 極限

極限分為描述一个序列的下標愈來越大时的趋势（序列極限），或是描述函数的自变量接趨近某個值時的函数值的趋势（函數極限）([参](https://zh.wikipedia.org/wiki/%E6%9E%81%E9%99%90_(%E6%95%B0%E5%AD%A6)))

In mathematics, a limit is the value that a function (or sequence) approaches as the input (or index) approaches some value. ([Ref](https://en.wikipedia.org/wiki/Limit_(mathematics)))

### 函数极限 Limit of a function

函數極限描述函數在接近某一給定自變量時的特徵。
函數$f$於$a$的極限為$L$，直觀上意為當$x$無限接近$a$時，$f(x)$便無限接近$L$。([参](https://zh.wikipedia.org/wiki/%E5%87%BD%E6%95%B8%E6%A5%B5%E9%99%90))

(ε, δ)-definition of limit ([Ref](https://en.wikipedia.org/wiki/Limit_of_a_function#(%CE%B5,_%CE%B4)-definition_of_limit)) (这是函数极限的严格定义)

Suppose ${\displaystyle f:\mathbb {R} \rightarrow \mathbb {R} }$ is a function defined on the real line, and there are two real numbers $p$ and $L$. One would say that the limit of $f$, as $x$ approaches $p$, is $L$ and written

 ${\displaystyle \lim _{x\to p}f(x)=L}$, 
 
 or alternatively, say ${\textstyle {\boldsymbol {f(x)}}}$ tends to ${\textstyle {\boldsymbol {L}}}$ as ${\textstyle {\boldsymbol {x}}}$ tends to ${\textstyle {\boldsymbol {p}}}$, and written:

${\displaystyle f(x)\to L\;\;{\text{as}}\;\;x\to p}$,

if the following property holds: for every real $ε > 0$, there exists a real $δ > 0$ such that for all real $x$, $0 < |x − p| < δ$ implies $|f(x) − L| < ε$. Symbolically,

$$
{\displaystyle (\forall \varepsilon >0)\,(\exists \delta >0)\,(\forall x\in \mathbb {R} )\,(0<|x-p|<\delta \implies |f(x)-L|<\varepsilon )}.
$$

### 极限 (数列)

極限為某些數列才擁有的特殊值，當數列的下標越來越大的時候，數列的值也就越接近那個特殊值。（[参](https://zh.wikipedia.org/wiki/%E6%A5%B5%E9%99%90_(%E6%95%B8%E5%88%97))）

In mathematics, the limit of a sequence is the value that the terms of a sequence "tend to", and is often denoted using the ${\displaystyle \lim _{n\to \infty }a_{n}}$.([Ref](https://en.wikipedia.org/wiki/Limit_of_a_sequence))

