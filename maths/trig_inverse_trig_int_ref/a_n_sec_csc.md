# Indefinite Integrals of $\sec^n(x)$ and $\csc^n(x)$

[Index](../index_en.md)

In this article, we derive the reduction formulas for $\int \sec^n(x) \,\mathrm{d}x$ and $\int \csc^n(x) \,\mathrm{d}x$.

We will use the following identities and derivatives.

$$
\begin{align}
    &\tan^2(x) + 1 = \sec^2(x), \quad \cot^2(x) + 1 = \csc^2(x)\\
    &\dfrac{\mathrm{d}}{\mathrm{d}x}\tan(x) = \sec^2(x), \quad  \dfrac{\mathrm{d}}{\mathrm{d}x}\cot(x) = -\csc^2(x)\\
    &\dfrac{\mathrm{d}}{\mathrm{d}x}\sec(x) = \sec(x)\tan(x), \quad  \dfrac{\mathrm{d}}{\mathrm{d}x}\csc(x) = -\csc(x)\cot(x)\\
    &\int \sec^2(x) \,\mathrm{d}x = \tan(x) + C, \quad \int \csc^2(x) \,\mathrm{d}x = -\cot(x) + C
\end{align}
$$

## sec

Let $I_n = \int \sec^n(x) \,\mathrm{d}x$. Then

$$
\begin{aligned}
    I_0 &= \int \,\mathrm{d}x = x + C \\
    I_1 &=  \int \sec(x) \,\mathrm{d}x = \ln(\vert \sec(x)+\tan(x) \vert) + C = - \ln(\vert \sec(x)-\tan(x) \vert) + C
\end{aligned}
$$

Let $n$ be an integer with $n>1$. Then

$$
\begin{aligned}
  \int \sec^n(x) \mathrm{d}x &= \int \sec^{n-2}(x)\cdot\sec^2(x) \,\mathrm{d}x \\
                             &= \int \sec^{n-2}(x)\,\mathrm{d}\tan(x) \\
                             &= \sec^{n-2}(x)\tan(x) - \int \tan(x) \,\mathrm{d}\sec^{n-2}(x) \\
                             &= \sec^{n-2}(x)\tan(x) - \int \tan(x) \cdot (n-2) \sec^{n-3}(x)\cdot\sec(x)\tan(x)\,\mathrm{d}x \\
                             &= \sec^{n-2}(x)\tan(x) - (n-2)\int \sec^{n-2}(x)\tan^2(x) \,\mathrm{d}x \\
                             &= \sec^{n-2}(x)\tan(x) - (n-2)\int \sec^{n-2}(x)(\sec^2(x)-1) \,\mathrm{d}x \\
                             &= \sec^{n-2}(x)\tan(x) - (n-2)\int \sec^{n}(x) \,\mathrm{d}x + (n-2)\int \sec^{n-2}(x)\,\mathrm{d}x
\end{aligned}
$$

Hence,

$$
\begin{aligned}
  (n - 1)\int \sec^n(x) \mathrm{d}x &= \sec^{n-2}(x)\tan(x) + (n-2)\int \sec^{n-2}(x)\,\mathrm{d}x \\
  \int \sec^n(x) \mathrm{d}x &= \dfrac{\sec^{n-2}(x)\tan(x)}{n-1} + \dfrac{n-2}{n-1}\int \sec^{n-2}(x)\,\mathrm{d}x
\end{aligned}
$$

Thus, we obtain the reduction formula

$$
I_n = \dfrac{\sec^{n-2}(x)\tan(x)}{n-1} + \dfrac{n-2}{n-1} I_{n-2}, \qquad n > 1
$$

## csc

Let $I_n = \int \csc^n(x) \,\mathrm{d}x$. Then

$$
\begin{aligned}
    I_0 &= \int \,\mathrm{d}x = x + C \\
    I_1 &=   \int \csc(x) \,\mathrm{d}x = -\ln(\vert \csc(x)+\cot(x) \vert) + C = \ln(\vert \csc(x)-\cot(x) \vert) + C
\end{aligned}
$$

Let $n$ be an integer with $n>1$. Then

$$
\begin{aligned}
  \int \csc^n(x) \mathrm{d}x &= \int \csc^{n-2}(x)\cdot\csc^2(x) \,\mathrm{d}x \\
                             &= -\int \csc^{n-2}(x)\,\mathrm{d}\cot(x) \\
                             &= -\left(\csc^{n-2}(x)\cot(x) - \int \cot(x) \,\mathrm{d}\csc^{n-2}(x)\right) \\
                             &= -\csc^{n-2}(x)\cot(x) - \int \cot(x) \cdot (n-2) \csc^{n-3}(x)\cdot\csc(x)\cot(x)\,\mathrm{d}x \\
                             &= -\csc^{n-2}(x)\cot(x) - (n-2)\int \csc^{n-2}(x)\cot^2(x) \,\mathrm{d}x \\
                             &= -\csc^{n-2}(x)\cot(x) - (n-2)\int \csc^{n-2}(x)(\csc^2(x)-1) \,\mathrm{d}x \\
                             &= -\csc^{n-2}(x)\cot(x) - (n-2)\int \csc^{n}(x) \,\mathrm{d}x + (n-2)\int \csc^{n-2}(x)\,\mathrm{d}x
\end{aligned}
$$

Hence,

$$
\begin{aligned}
  (n - 1)\int \csc^n(x) \mathrm{d}x &= -\csc^{n-2}(x)\cot(x) + (n-2)\int \csc^{n-2}(x)\,\mathrm{d}x \\
  \int \csc^n(x) \mathrm{d}x &= -\dfrac{\csc^{n-2}(x)\cot(x)}{n-1} + \dfrac{n-2}{n-1}\int \csc^{n-2}(x)\,\mathrm{d}x
\end{aligned}
$$

Thus, we obtain the reduction formula

$$
I_n = -\dfrac{\csc^{n-2}(x)\cot(x)}{n-1} + \dfrac{n-2}{n-1} I_{n-2}, \qquad n > 1
$$

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
        data-lang="en"
        crossorigin="anonymous"
        async>
</script>