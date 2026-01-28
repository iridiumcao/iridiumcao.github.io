# 矩阵的行秩等于列秩

[返回目录](index.md)

_2024.02.14 农历正月初五_

矩阵的行秩等于列秩，是线性代数中的非常非常基础和重要的结论，这个秩也就是矩阵的秩。

- 行秩：矩阵的行向量组的秩
- 列秩：矩阵的列向量组的秩

假设 $\mathcal{A}$ 是一个 $m \times n$ 矩阵，再假设它的行秩是 $r$.

根据前面的假设，假设 $\mathcal{A}$ 的行向量组一个最大无关组（基）是

$$
\mathcal{C} = \begin{bmatrix}
    c_{1} \\
    c_{2} \\
    \vdots \\
    c_{r}
\end{bmatrix}
$$

其中，$c_{1}, c_{2}, ..., c_{k}$ 是 $n$ 维行向量，$C$ 是一个 $r \times n$ 矩阵。

$\mathcal{A}$ 的所有行向量都可以用 $C$ 线性表出，存在存在一个 $m \times r$ 矩阵 $R$，使

$$\mathcal{A}_{m \times n} = \mathcal{R}_{m \times r}\mathcal{C}_{r \times n}$$

根据[矩阵的乘法](matrix_multiplication.md)，$\mathcal{A}$ 除了可以看着是 $\mathcal{C}$ 的行向量的线性组合，还可以看作是 $\mathcal{R}$ 的列向量的线性组合。

既然 $\mathcal{A}$ 是 $\mathcal{R}$ 的列向量的线性组合，那么

$$\mathcal{A} 的列秩 \le \mathcal{R} 的列秩$$

又因为 $\mathcal{R}$ 的列数是 $r$，所以 

$$\mathcal{R} 的列秩 \le r$$

所以

$$\mathcal{A} 的列秩 \le \mathcal{R} 的列秩 \le r = \mathcal{A} 的行秩$$

即得到

$$
\begin{equation}
  \begin{split}
    \mathcal{A} 的列秩 \le \mathcal{A} 的行秩
  \end{split}
\end{equation}
$$

同理可以证明

$$\mathcal{A}^T 的列秩 \le \mathcal{A}^T 的行秩$$

又因为 

$$\mathcal{A}^T 的列秩 = \mathcal{A} 的行秩， \mathcal{A}^T 的行秩 = \mathcal{A} 的列秩$$

所以

$$
\begin{equation}
  \begin{split}
    \mathcal{A} 的行秩 \le \mathcal{A} 的列秩
  \end{split}
\end{equation}
$$

由(1), (2)两式可得

$$\mathcal{A} 的行秩 = \mathcal{A} 的列秩$$

证毕。

## 后记

这次重学线性代数时，我当然晓得这个结论，但对证明过程却很陌生。所以花了时间反复阅读证明，终于搞清楚了，但往往第二天起来又忘了，这个情况已经反复几次了。是可忍熟不可忍，还是用自己的话记下来吧。

马同学也提供了一种证明，参[这里](https://www.matongxue.com/parts/2247/)，它是从列向量出发。我这里有意使用行向量来证，其实结果都是一样的——都证妥了。

要证明这个结论，必须把矩阵相乘理解透，尤其是如何从行或列运算的角度去理解。

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