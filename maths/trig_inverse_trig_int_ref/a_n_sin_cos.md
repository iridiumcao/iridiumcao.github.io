# Indefinite Integrals of $\sin^n(x)$ and $\cos^n(x)$

[Index](../index_en.md)

We begin with several basic cases:

$$
\begin{aligned}
    \int \sin(x) \,\mathrm{d}x &= -\cos(x) + C \\
    \int \cos(x) \,\mathrm{d}x &= \sin(x) + C \\
    \int \sin^2(x) \,\mathrm{d}x &= \dfrac{x}{2}  - \dfrac{\sin(2x)}{4} + C \\
    \int \cos^2(x) \,\mathrm{d}x &= \dfrac{x}{2}  + \dfrac{\sin(2x)}{4} + C
\end{aligned}
$$

([Ref 1](a1_b1.md), [Ref 2](a2.md))

together with the power-reduction identities

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
                                 &= \int \left(\dfrac{1-\cos(2x)}{2}\right)^{m} \,\mathrm{d}x
\end{aligned}
$$

and similarly

$$
\begin{aligned}
    \int \cos^n(x) \,\mathrm{d}x &= \int \cos^{2m}(x) \,\mathrm{d}x \\
                                 &= \int (\cos^2(x))^{m} \,\mathrm{d}x \\
                                 &= \int \left(\dfrac{1+\cos(2x)}{2}\right)^{m} \,\mathrm{d}x                                
\end{aligned}
$$

This reduces the power from $n$ to $m$.

By expanding the binomial expression, it produces terms involving powers of $\cos(2x)$. We then repeatedly apply the same power-reduction identities to lower the powers until we reach integrals of the form $\int 1 \,\mathrm{d}x$, $\int \cos(2x) \,\mathrm{d}x$, $\int \cos(4x) \,\mathrm{d}x$, etc. Eventually, the result is a combination of $x$ and sines/cosines of multiple angles, plus the constant $C$.

Although the above methods allow us to compute the integrals, it is often more convenient to derive a reduction formula.

## Case 2: $n$ is odd

Let $n=2m + 1$, where $m \geq 0$ is an integer.

For $\sin^n(x)$

$$
\begin{aligned}
    \int \sin^n(x) \,\mathrm{d}x &= \int \sin^{2m+1}(x) \,\mathrm{d}x \\
                                 &= \int \sin^{2m}(x)\sin(x) \,\mathrm{d}x \\
                                 &= -\int \sin^{2m}(x) \,\mathrm{d}\cos(x) \\
                                 &= -\int (\sin^2(x))^{m} \,\mathrm{d}\cos(x) \\
                                 &= -\int (1 - \cos^2(x))^{m} \,\mathrm{d}\cos(x)
\end{aligned}
$$

For $\cos^n(x)$

$$
\begin{aligned}
    \int \cos^n(x) \,\mathrm{d}x &= \int \cos^{2m+1}(x) \,\mathrm{d}x \\
                                 &= \int \cos^{2m}(x)\cos(x) \,\mathrm{d}x \\
                                 &= \int \cos^{2m}(x) \,\mathrm{d}\sin(x) \\
                                 &= \int (\cos^2(x))^{m} \,\mathrm{d}\sin(x) \\
                                 &= \int (1 - \sin^2(x))^{m} \,\mathrm{d}\sin(x)
\end{aligned}
$$

Now expand

$$
(1 - \cos^2(x))^{m} \quad or \quad (1 - \sin^2(x))^{m}
$$

and integrate term by term.

Thus, when $n$ is odd, the problem reduces to integrating a polynomial in either $\cos(x)$ or $\sin(x)$.

## Reduction Formula for $\int \sin^n(x) \,\mathrm{d}x$

Let $I_n = \int \sin^n(x) \,\mathrm{d}x$. Then

$$
\begin{aligned}
    I_0 &= \int \,\mathrm{d}x = x + C \\
    I_1 &=  \int \sin(x) \,\mathrm{d}x = -\cos(x) + C
\end{aligned}
$$

Let $n$ be an integer with $n>1$. Then

$$
\begin{aligned}
  \int \sin^n(x) \mathrm{d}x &= -\int \sin^{n-1}(x) \,\mathrm{d}\cos(x) \\
                             &= -\left(\sin^{n-1}(x)\cos(x) - \int \cos(x) \,\mathrm{d}\sin^{n-1}(x) \right) \\
                             &= -\left(\sin^{n-1}(x)\cos(x) - \int \cos(x) \cdot (n-1) \sin^{n-2}(x) \cdot \cos(x) \,\mathrm{d}x\right) \\
                             &= -\sin^{n-1}(x)\cos(x) + (n-1) \int \sin^{n-2} \cos^2(x) \,\mathrm{d}x \\
                             &= -\sin^{n-1}(x)\cos(x) + (n-1) \int \sin^{n-2} (1- \sin^2(x)) \,\mathrm{d}x \\
                             &= -\sin^{n-1}(x)\cos(x) + (n-1) \int (\sin^{n-2} - \sin^n(x)) \,\mathrm{d}x \\
                             &= -\sin^{n-1}(x)\cos(x) + (n-1) \int \sin^{n-2} \,\mathrm{d}x - (n-1) \int \sin^n(x) \,\mathrm{d}x
\end{aligned}
$$

Adding $(n-1) \int \sin^n x \, dx$ to both sides:

$$
  n\int \sin^n(x) \,\mathrm{d}x = -\sin^{n-1}(x)\cos(x) + (n-1) \int \sin^{n-2}(x) \,\mathrm{d}x
$$

Hence, 

$$
  \int \sin^n(x) \,\mathrm{d}x = -\dfrac{1}{n}\sin^{n-1}(x)\cos(x) + \dfrac{n-1}{n} \int \sin^{n-2}(x) \,\mathrm{d}x   
$$

Thus, we obtain the reduction formula

$$
I_n = -\dfrac{1}{n}\sin^{n-1}(x)\cos(x) + \dfrac{n-1}{n} I_{n-2}, \qquad n > 1
$$

## Reduction Formula for $\int \cos^n(x) \,\mathrm{d}x$

Let $I_n = \int \cos^n(x) \,\mathrm{d}x$. Then

$$
\begin{aligned}
    I_0 &= \int \,\mathrm{d}x = x + C \\
    I_1 &=  \int \cos(x) \,\mathrm{d}x = \sin(x) + C
\end{aligned}
$$

Let $n$ be an integer with $n>1$. Then

$$
\begin{aligned}
  \int \cos^n(x) \mathrm{d}x &= \int \cos^{n-1}(x) \,\mathrm{d}\sin(x) \\
                             &= \cos^{n-1}(x)\sin(x) - \int \sin(x) \,\mathrm{d}\cos^{n-1}(x) \\
                             &= \cos^{n-1}(x)\sin(x) + \int \sin(x) \cdot (n-1) \cos^{n-2}(x) \cdot \sin(x) \,\mathrm{d}x \\
                             &= \cos^{n-1}(x)\sin(x) + (n-1) \int \cos^{n-2} \sin^2(x) \,\mathrm{d}x \\
                             &= \cos^{n-1}(x)\sin(x) + (n-1) \int \cos^{n-2} (1- \cos^2(x)) \,\mathrm{d}x \\
                             &= \cos^{n-1}(x)\sin(x) + (n-1) \int (\cos^{n-2} - \cos^n(x)) \,\mathrm{d}x \\
                             &= \cos^{n-1}(x)\sin(x) + (n-1) \int \cos^{n-2} \,\mathrm{d}x - (n-1) \int \cos^n(x) \,\mathrm{d}x
\end{aligned}
$$

Adding $(n-1) \int \cos^n x \, dx$ to both sides:

$$
  n\int \cos^n(x) \,\mathrm{d}x = \cos^{n-1}(x)\sin(x) + (n-1) \int \cos^{n-2} (x)\,\mathrm{d}x
$$

Hence, 

$$
  \int \cos^n(x) \,\mathrm{d}x = \dfrac{1}{n}\cos^{n-1}(x)\sin(x) + \dfrac{n-1}{n} \int \cos^{n-2}(x) \,\mathrm{d}x                
$$

Thus, we obtain the reduction formula

$$
I_n = \dfrac{1}{n}\cos^{n-1}(x)\sin(x) + \dfrac{n-1}{n} I_{n-2}, \qquad n > 1
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