# Reduction Formulas for Powers of Trigonometric Functions $trig^n(x)$

[Index](../index_en.md)

This article summarizes **reduction formulas** for the indefinite integrals of powers of trigonometric functions. All formulas are valid for **integer powers** $n \geq 0$ (or $n \geq 1$ for the reduction formulas), with $I_0$ and $I_1$ as base cases.

## sin

$$
  \int \sin^n(x) \,\mathrm{d}x = -\dfrac{1}{n}\sin^{n-1}(x)\cos(x) + \dfrac{n-1}{n} \int \sin^{n-2}(x) \,\mathrm{d}x, \qquad n > 1              
$$

Let $I_n = \int \sin^n(x) \,\mathrm{d}x$, then

$$
I_n = -\dfrac{1}{n}\sin^{n-1}(x)\cos(x) + \dfrac{n-1}{n} I_{n-2}, \qquad n > 1
$$

Base cases:

$$
\begin{aligned}
    I_0 &= \int \,\mathrm{d}x = x + C \\
    I_1 &=  \int \sin(x) \,\mathrm{d}x = -\cos(x) + C
\end{aligned}
$$

Ref: [Indefinite Integrals of $\sin^n(x)$ and $\cos^n(x)$](a_n_sin_cos.md)

## cos

$$
  \int \cos^n(x) \,\mathrm{d}x = \dfrac{1}{n}\cos^{n-1}(x)\sin(x) + \dfrac{n-1}{n} \int \cos^{n-2}(x) \,\mathrm{d}x, \qquad n > 1                
$$

Let $I_n = \int \cos^n(x) \,\mathrm{d}x$, then

$$
I_n = \dfrac{1}{n}\cos^{n-1}(x)\sin(x) + \dfrac{n-1}{n} I_{n-2}, \qquad n > 1
$$

Base cases:

$$
\begin{aligned}
    I_0 &= \int \,\mathrm{d}x = x + C \\
    I_1 &=  \int \cos(x) \,\mathrm{d}x = \sin(x) + C
\end{aligned}
$$

Ref: [Indefinite Integrals of $\sin^n(x)$ and $\cos^n(x)$](a_n_sin_cos.md)

## tan

$$
\int \tan^n(x) \mathrm{d}x = \dfrac{\tan^{n-1}(x)}{n-1} - \int \tan^{n-2}(x) \,\mathrm{d}x, \qquad n > 1
$$

Let $I_n = \int \tan^n(x) \,\mathrm{d}x$, then

$$
I_n = \dfrac{\tan^{n-1}(x)}{n-1} - I_{n-2}, \qquad n > 1
$$

Base cases:

$$
\begin{aligned}
    I_0 &= \int \,\mathrm{d}x = x + C \\
    I_1 &= \int \tan(x) \,\mathrm{d}x = -\ln(\vert \cos(x) \vert) + C = \ln(\vert \sec(x) \vert) + C
\end{aligned}
$$

Ref: [Indefinite Integrals of $\tan^n(x)$ and $\cot^n(x)$](a_n_tan_cot.md)

## cot

$$
\int \cot^n(x) \mathrm{d}x = -\dfrac{\cot^{n-1}(x)}{n-1} - \int \cot^{n-2}(x) \,\mathrm{d}x, \qquad n > 1
$$

Let $I_n = \int \cot^n(x) \,\mathrm{d}x$, then

$$
I_n = -\dfrac{\cot^{n-1}(x)}{n-1} - I_{n-2}, \qquad n > 1
$$

Base cases:

$$
\begin{aligned}
    I_0 &= \int \,\mathrm{d}x = x + C \\
    I_1 &= \int \cot(x) \,\mathrm{d}x = \ln(\vert \sin(x) \vert) + C =  -\ln(\vert \csc(x) \vert) + C
\end{aligned}
$$

Ref: [Indefinite Integrals of $\tan^n(x)$ and $\cot^n(x)$](a_n_tan_cot.md)

## sec

$$
\int \sec^n(x) \mathrm{d}x = \dfrac{\sec^{n-2}(x)\tan(x)}{n-1} + \dfrac{n-2}{n-1}\int \sec^{n-2}(x)\,\mathrm{d}x, \qquad n > 1
$$

Let $I_n = \int \sec^n(x) \,\mathrm{d}x$, then

$$
I_n = \dfrac{\sec^{n-2}(x)\tan(x)}{n-1} + \dfrac{n-2}{n-1} I_{n-2}, \qquad n > 1
$$

Base cases:

$$
\begin{aligned}
    I_0 &= \int \,\mathrm{d}x = x + C \\
    I_1 &=  \int \sec(x) \,\mathrm{d}x = \ln(\vert \sec(x)+\tan(x) \vert) + C = - \ln(\vert \sec(x)-\tan(x) \vert) + C
\end{aligned}
$$

Ref: [Indefinite Integrals of $\sec^n(x)$ and $\csc^n(x)$](a_n_sec_csc.md)

## csc

$$
\int \csc^n(x) \mathrm{d}x = -\dfrac{\csc^{n-2}(x)\cot(x)}{n-1} + \dfrac{n-2}{n-1}\int \csc^{n-2}(x)\,\mathrm{d}x, \qquad n > 1
$$

Let $I_n = \int \csc^n(x) \,\mathrm{d}x$, then

$$
I_n = -\dfrac{\csc^{n-2}(x)\cot(x)}{n-1} + \dfrac{n-2}{n-1} I_{n-2}, \qquad n > 1
$$

Base cases:

$$
\begin{aligned}
    I_0 &= \int \,\mathrm{d}x = x + C \\
    I_1 &=   \int \csc(x) \,\mathrm{d}x = -\ln(\vert \csc(x)+\cot(x) \vert) + C = \ln(\vert \csc(x)-\cot(x) \vert) + C
\end{aligned}
$$

Ref: [Indefinite Integrals of $\sec^n(x)$ and $\csc^n(x)$](a_n_sec_csc.md)

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