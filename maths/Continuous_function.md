# 连续函数 Continuous Function

[返回目录](index.md)

本文仅限于一元函数的情况。

已知函数 $f$ 和点 $x_0$，如果

- $f$ 在 $x_0$ 有定义
- $\lim_{x \to x_0^+} f(x) = \lim_{x \to x_0^-} f(x) = f(x_0)$ （左极限和右极限都存在，且相等，并等于该点的函数值）

则函数在这个点连续。如果函数在该点无定义，则函数自然不连续。

如果一个函数在某个区间的所有**定义点**都连续，则称函数在该区间上连续。

- 对于开区间 $(𝑎,𝑏)$，只需在内部点讨论连续性。
- 对于闭区间 $[a,b]$，还需满足：

$$
\begin{aligned}
  \lim_{x \to a^+} &= f(a) \\
  \lim_{x \to b^-} &= f(b)
\end{aligned}
$$

---

* [维基百科·连续函数](https://zh.wikipedia.org/wiki/%E8%BF%9E%E7%BB%AD%E5%87%BD%E6%95%B0)

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
