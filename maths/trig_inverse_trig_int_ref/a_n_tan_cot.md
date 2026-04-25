# Indefinite Integrals of $\tan^n(x)$ and $\cot^n(x)$

[Index](../index.md)

In this article, we derive the reduction formulas for $\int \tan^n(x) \,\mathrm{d}x$ and $\int \cot^n(x) \,\mathrm{d}x$.

We will use the following identities and basic formulas.

$$
\begin{align}
    &\tan^2(x) + 1 = \sec^2(x), \quad \cot^2(x) + 1 = \csc^2(x)\\
    &\dfrac{\mathrm{d}}{\mathrm{d}x}\tan(x) = \sec^2(x), \quad  \dfrac{\mathrm{d}}{\mathrm{d}x}\cot(x) = -\csc^2(x)\\
    &\int \sec^2(x) \,\mathrm{d}x = \tan(x) + C, \quad \int \csc^2(x) \,\mathrm{d}x = -\cot(x) + C
\end{align}
$$

## tan

Let $I_n = \int \tan^n(x) \,\mathrm{d}x$. Then

$$
\begin{aligned}
    I_0 &= \int \,\mathrm{d}x = x + C \\
    I_1 &= \int \tan(x) \,\mathrm{d}x = -\ln(\vert \cos(x) \vert) + C = \ln(\vert \sec(x) \vert) + C
\end{aligned}
$$

Let $n$ be an integer with $n>1$. Then

$$
\begin{aligned}
  \int \tan^n(x) \mathrm{d}x &= \int \tan^{n-2}(x)\cdot\tan^2(x) \,\mathrm{d}x \\
                             &= \int \tan^{n-2}(x)\cdot(\sec^2(x)-1) \,\mathrm{d}x \\
                             &= \int \tan^{n-2}(x)\cdot\sec^2(x) \,\mathrm{d}x - \int \tan^{n-2}(x) \,\mathrm{d}x \\
                             &= \int \tan^{n-2}(x) \,\mathrm{d}\tan(x) - \int \tan^{n-2}(x) \,\mathrm{d}x \\
                             &= \dfrac{\tan^{n-1}(x)}{n-1} - \int \tan^{n-2}(x) \,\mathrm{d}x
\end{aligned}
$$

Thus, we obtain the reduction formula

$$
I_n = \dfrac{\tan^{n-1}(x)}{n-1} - I_{n-2}, \qquad n > 1
$$

## cot

Let $I_n = \int \cot^n(x) \,\mathrm{d}x$. Then

$$
\begin{aligned}
    I_0 &= \int \,\mathrm{d}x = x + C \\
    I_1 &= \int \cot(x) \,\mathrm{d}x = \ln(\vert \sin(x) \vert) + C =  -\ln(\vert \csc(x) \vert) + C
\end{aligned}
$$

Let $n$ be an integer with $n>1$. Then

$$
\begin{aligned}
  \int \cot^n(x) \mathrm{d}x &= \int \cot^{n-2}(x)\cdot\cot^2(x) \,\mathrm{d}x \\
                             &= \int \cot^{n-2}(x)\cdot(\csc^2(x)-1) \,\mathrm{d}x \\
                             &= \int \cot^{n-2}(x)\cdot\csc^2(x) \,\mathrm{d}x - \int \cot^{n-2}(x) \,\mathrm{d}x \\
                             &= -\int \cot^{n-2}(x) \,\mathrm{d}\cot(x) - \int \cot^{n-2}(x) \,\mathrm{d}x \\
                             &= -\dfrac{\cot^{n-1}(x)}{n-1} - \int \cot^{n-2}(x) \,\mathrm{d}x
\end{aligned}
$$

Thus, we obtain the reduction formula

$$
I_n = -\dfrac{\cot^{n-1}(x)}{n-1} - I_{n-2}, \qquad n > 1
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