# 费马引理

[返回目录](index.md)

费马引理（Fermat's theorem on stationary points / Interior extremum theorem）是微积分中的一个基本结论：

> 如果函数 $f$ 在点$x_0$的某邻域内有定义，并且在 $x_0$ 处取得局部极值，且在该点可导，则 $f'(x_0)=0$。

需要注意的是，费马定理并不保证导数为零的点一定是极值点，也就是说，导数为零只是极值点的必要条件，但不是充分条件。因此，在确定极值点时，还需要进一步的推导分析。比如 $f(x)=x^3$ 在 $x=0$ 时导数为 0，但并无极值。

## 证明

按：这个证明来源于[维基百科·费马引理](https://en.wikipedia.org/wiki/Interior_extremum_theorem)

假设 $x_0$ 是一个局部极大值（局部极小值类似），在 $x_0$ 的去心邻域里有 $f(x_0) \geq f(x)$.

如果 $x \gt x_0$，则有

$$
f'_+(x_0) =
\lim_{x \to x_0^+}
\frac{
      f(x)-f(x_0)
    }{
      x-x_0} 
\leq 0
$$

类似地，如果 $x \lt x_0$，则有

$$
f'_-(x_0) =
\lim_{x \to x_0^-}
\frac{
      f(x)-f(x_0)
    }{
      x-x_0} 
\geq 0
$$

又因为 $f$ 在 $x_0$ 是可导的，所以 $f'_+(x_0) = f'_-(x_0) = f'(x_0)$。

所以 $f'(x_0) = f'_+(x_0) \leq 0$ 且 $f'(x_0) = f'_-(x_0) \geq 0$，

所以 $f'(x_0) = 0$.

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
