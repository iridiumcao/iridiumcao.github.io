# 素数的个数为什么是无限的

[返回目录](index.md)

按：这篇文章并无新意，只是记录一下欧几里得两千多年前的证明而已。

【**定义**】素数（也称质数）是指在大于1的自然数中，除了1和此整数自身外，无法被其他自然数整除的数（也可定义为只有1和本身两个因数的数）。

【**求证**】素数有无限多个

【**证明**】

如果素数是有限的，设从小到大依次是$p_0, p_1, ..., p_n (p_0 < p_1 < ... < p_n)$

设 $p = p_{0}p_{1}...p_{n} + 1$

显然 $p \neq p_i ( 0 \leq i \leq n)$

依据假设，$p$在素数集合之外，即为合数。

而 $p\hspace{0.5 em} mod\hspace{0.5 em} p_i = 1$

即$p$无法被任何素数整除，那么因为$p$本身不是素数，它就一定能被除1和其本身之外的一个数整除，既然这个数不能是素数，那么就是另外一个合数，而合数即能分解出素数因子，即$p$含有素数因子，和前面的推断“$p$无法被任何素数整除”的假定矛盾，故假设素数是有限个数的说法是错误的。

所以，素数的个数是无限的。

参考：[维基百科·素数](https://zh.wikipedia.org/wiki/%E8%B4%A8%E6%95%B0), [Prime Number (Wikipedia)](https://en.wikipedia.org/wiki/Prime_number)

---

本文曾于 2007-07-03 01:17:00 发布在[CSDN blog](https://blog.csdn.net/caoi/article/details/1676223)上
![history on CSDN](images/history2023-06-16-065353.png)

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