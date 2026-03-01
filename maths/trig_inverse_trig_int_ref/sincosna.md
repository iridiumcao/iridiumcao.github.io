# Indefinite Integrals of $sin^n(x)$ and $cos^n(x)$

[Index](../index_en.md)

We know the basic cases:

$$
\begin{aligned}
    \int \sin(x) \,\mathrm{d}x &= -\cos(x) + C \\
    \int \cos(x) \,\mathrm{d}x &= \sin(x) + C \\
    \int \sin^2(x) \,\mathrm{d}x &= \dfrac{x}{2}  - \dfrac{\sin(2x)}{4} + C \\
    \int \cos^2(x) \,\mathrm{d}x &= \dfrac{x}{2}  + \dfrac{\sin(2x)}{4} + C \\

\end{aligned}
$$

([Ref 1](a1_b1.md), [Ref 2](a2.md))

and the power-reduction identities
$$
    \sin^2(x) = \dfrac{1-\cos(2x)}{2}, \quad 
    \cos^2(x) = \dfrac{1+\cos(2x)}{2} \\
$$

We now consider how to compute

$$
\int\sin^n(x)\,\mathrm{d}x \quad and \quad \int\cos^n(x)\,\mathrm{d}x
$$

## Case 1: $n$ is even

Let $n=2m$, where $m$ is a positive integer.

Then

$$
\begin{aligned}
    \int \sin^n(x) \,\mathrm{d}x &= \int \sin^{2m}(x) \,\mathrm{d}x \\
                                 &= \int (\sin^2(x))^{m} \,\mathrm{d}x \\
                                 &= \int \left(\dfrac{1-\cos(2x)}{2}\right)^{m} \,\mathrm{d}x \\
\end{aligned}
$$

and similarly

$$
\begin{aligned}
    \int \cos^n(x) \,\mathrm{d}x &= \int \cos^{2m}(x) \,\mathrm{d}x \\
                                 &= \int (\cos^2(x))^{m} \,\mathrm{d}x \\
                                 &= \int \left(\dfrac{1+\cos(2x)}{2}\right)^{m} \,\mathrm{d}x \\                                 
\end{aligned}
$$

This reduces the power from $n$ to $m$.

By expanding the binomial expression, it produces terms involving powers of $\cos(2x)$. We then repeatedly apply the same power-reduction identities to lower the powers until we reach integrals of the form $\int 1 \,\mathrm{d}x$, $\int \cos(2x) \,\mathrm{d}x$, $\int \cos(4x) \,\mathrm{d}x$, etc. Eventually, the result is a combination of $x$ and sines/cosines of multiple angles, plus the constant $C$.

## Case 2: $n$ is odd

Let $n=2m + 1$, where $m \geq 0$ is an integer.

For $\sin^n(x)$

$$
\begin{aligned}
    \int \sin^n(x) \,\mathrm{d}x &= \int \sin^{2m+1}(x) \,\mathrm{d}x \\
                                 &= \int \sin^{2m}(x)\sin(x) \,\mathrm{d}x \\
                                 &= -\int \sin^{2m}(x) \,\mathrm{d}\cos(x) \\
                                 &= -\int (\sin^2(x))^{m} \,\mathrm{d}\cos(x) \\
                                 &= -\int (1 - \cos^2(x))^{m} \,\mathrm{d}\cos(x) \\
\end{aligned}
$$

For $\cos^n(x)$

$$       
\begin{aligned}
    \int \cos^n(x) \,\mathrm{d}x &= \int \cos^{2m+1}(x) \,\mathrm{d}x \\
                                 &= \int \cos^{2m}(x)\cos(x) \,\mathrm{d}x \\
                                 &= \int \cos^{2m}(x) \,\mathrm{d}\sin(x) \\
                                 &= \int (\cos^2(x))^{m} \,\mathrm{d}\sin(x) \\
                                 &= \int (1 - \sin^2(x))^{m} \,\mathrm{d}\sin(x) \\
\end{aligned}
$$

Now expand

$$
(1 - \cos^2(x))^{m} \quad or \quad (1 - \sin^2(x))^{m}
$$

and integrate term by term.

Thus, when $n$ is odd, the problem reduces to integrating a polynomial in either $\cos(x)$ or $\sin(x)$.

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