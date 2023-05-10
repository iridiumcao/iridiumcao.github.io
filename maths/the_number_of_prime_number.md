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

# 素数的个数为什么是无限的

本文曾于 2007-07-03 01:17:00 发布在[CSDN blog](https://blog.csdn.net/caoi/article/details/1676223)上

按，并无新意，记录一下别人的想法而已。

如果素数是有限的，设从小到大依次是$p_0, p_1, ..., p_n (p_0 < p_1 < ... < p_n)$

设 $p = p_0 * p_1 * ... * p_n + 1$

显然 $p \neq p_i ( 0 \leq i \leq n)$

依据假设，$p$在素数集合之外，即为合数。

而 $p\hspace{0.5 em} mod\hspace{0.5 em} p_i = 1$

即$p$无法被任何素数整除，那么因为$p$本身不是素数，它就一定能被除1和其本身之外的一个数整除，既然这个数不能是素数，那么就是另外一个合数，而合数即能分解出素数因子，即$p$含有素数因子，和前面的推断“$p$无法被任何素数整除”的假定矛盾，故假设素数是有限个数的说法是错误的。

所以，素数的个数是无限的。
