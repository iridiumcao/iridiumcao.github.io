# 两数之积不大于两数之和一半的平方

[返回目录](index.md)

星期六(2023.07.16)在和Charles讨论某个问题时，他产生了一个猜想，经过我的证明，它是成立的。此文即记录此猜想和证明。

猜想：如果两数之和为某数的两倍，则这两数之积不大于某数的平方。

用代数的方式表达，即：

前提：问题限定在实数域。

已知： $x+y=2z, x \neq 0, y \neq 0$

则：$xy \leq z^2$

证明：

$x+y=2z$

$\therefore z = \dfrac{x+y}{2}$

要证 $xy \leq z^2$

即要证 $xy \leq (\dfrac{x+y}{2})^2$

展开右边得 $xy \leq \dfrac{x^2+y^2+2xy}{4}$

两边同乘以4得 $4xy \leq x^2+y^2+2xy$

移项得 $0 \leq x^2+y^2-2xy$

即 $0 \leq (x-y)^2$

此式在实数域恒成立，前述假设得证。

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
