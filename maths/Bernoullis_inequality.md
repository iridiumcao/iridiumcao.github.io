# 伯努利不等式(Bernoulli's inequality)

[Index](index.md)

伯努利不等式是一个非常著名的不等式，在证明 $e$ 的收敛性中也有用到。

## 基本形式

如果 $x$ 是不小于 -1 的实数，$n$ 是任意非负整数，则 $(1+x)^n ≥ 1+nx$.

也可以用符号的方式表述如下：

> $$
\forall x \ge -1,\; \forall n \in \mathbb{N}_0,\quad (1+x)^n \ge 1+nx
$$

对不等式左边用二项式定理展开

$$
(1+x)^n = 1 + nx + \binom{n}{2}x^2 + \cdots
$$

如果此时 $x \geq 0$，则不等式显然成立，但是，伯努利公式的条件是 $x \geq -1$，真不知伯努利是怎么想到的，真是个天才。

## 证明

这个不等式可以采用数学归纳法证明，以下是证明过程。

**奠基步骤**

先考察 $n=0$ 或 $n=1$ 的情况，此时不等式显然成立。

|       | $(1+x)^n$ | $1+nx$ | 不等式成立 |
|-------|-----------|--------|------------|
| $n=0$ | 1         | 1      | Yes        |
| $n=1$ | $1+x$     | $1+x$  | Yes        |

**归纳假设**

假设不等式在 $n = k, k>1$ 时也成立，即：

$$
(1+x)^k ≥ 1+kx, \quad k>1
$$

**归纳步骤**

考虑 $n=k+1$，由于 $x \geq -1$，有 $1+x \geq 0$，故

$$
\begin{aligned}
    (1+x)^{k+1}
    &= (1+x)(1+x)^k \\
    &\geq (1+x)(1+kx) \\
    &= 1 + (k+1)x + kx^2 \\
    &\geq 1 + (k+1)x \\
\end{aligned}
$$

因此不等式对 $n=k+1$ 也成立。

**结论**

由数学归纳法，不等式对所有非负整数 $n$ 成立。

## 扩展版（实数指数）

伯努利不等式的指数还可以扩展到实数范围：

$$
\begin{aligned}
    x \gt -1, r \in (-\infty, 0] \cup [1, +\infty)
    &\implies (1+x)^r \geq 1+rx \\

    x \gt -1, r \in [0, 1]
    &\implies (1+x)^r \leq 1+rx \\
\end{aligned}
$$

> 注意：当指数扩展到实数时，为保证 
> $(1+x)^r$ 的实数意义，需要要求 $x \gt -1$

证明留待将来再写。

---

参考：[维基百科·伯努利不等式](https://en.wikipedia.org/wiki/Bernoulli%27s_inequality)

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