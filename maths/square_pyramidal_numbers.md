# 平方和公式推导

[返回目录](index.md)

平方和(Square pyramidal numbers)公式有很多证明和推导的方法。如果只是证明这个公式，直接用数学归纳法即可，但这样就掩盖了公式的来源。本文借助排列组合相关的工具推导该公式。

公式的排版参考了[这篇文章](https://blog.csdn.net/weixin_46233323/article/details/104538187)。

$$
\sum_{i=1}^n i^2 = \frac{n(n+1)(2n+1)}{6}
$$

推导过程如下：

$$
\begin{align}
  \because& 
    \hspace{0.5 em} n^2 = n^2 - n + n = n(n-1) + n = 2{n\choose 2} + n, when\hspace{0.5 em}n > 1 \\  
  
  \therefore& \hspace{0.5 em} \sum_{i=1}^n i^2 = 1^2 + 2^2 + 3^2 + \cdots + n^2 \\ 
    &\hspace{3 em}= 1 + 2\left[{2\choose 2} + {3\choose 2} + \cdots + {n\choose 2}\right] + (2 + 3 + \cdots + n) \\ 
    &\hspace{3 em}= 2\left[{2\choose 2} + {3\choose 2} + \cdots + {n\choose 2}\right] + (1 + 2 + 3 + \cdots + n) \\ 
    &\hspace{3 em}= 2\left[{2\choose 2} + {3\choose 2} + \cdots + {n\choose 2}\right] + \frac{n(n+1)}{2} \\  
  
  \because& 
    \hspace{0.5 em} {2\choose 2} = {3\choose 3} = 1 \\
  
  \therefore& 
    \hspace{1.5 em} {2\choose 2} + {3\choose 2} + \cdots + {n\choose 2} \\ 
    &= {3\choose 3} + {3\choose 2} + \cdots + {n\choose 2} \\ 
    &= {4\choose 3} + {4\choose 2} + \cdots + {n\choose 2} \\ 
    & \cdots \\ 
    &= {n+1\choose 3} \\ 
  
  \therefore& \hspace{0.5 em}\sum_{i=1}^n i^2 = 2{n+1\choose 3} + \frac{n(n+1)}{2} \\ 
    &\hspace{3 em}= \frac{2(n+1)n(n-1)}{3!} + \frac{n(n+1)}{2} \\ 
    &\hspace{3 em}= \frac{n(n+1)(2n+1)}{6} \\
\end{align}
$$

---

本文从[CSDN blog](https://blog.csdn.net/caoi/article/details/128460103)搬迁而来，CSDN虽然也支持数学公式，但对编辑工作很不友好。

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
