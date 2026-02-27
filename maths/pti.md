# Pythagorean Trigonometric Identities — beyond sin² + cos² = 1

[Index](index_en.md)

Everyone knows the identity:

$$
\sin^2\theta + \cos^2\theta = 1
$$

It implies two equivalent identities:

$$
\begin{aligned}
    \tan^2\theta + 1 = \sec^2\theta \\
    1 + \cot^2\theta = \csc^2\theta
\end{aligned}
$$

Rewriting and factoring gives

$$
\begin{aligned}
    \sec^2\theta - \tan^2\theta = (\sec\theta - \tan\theta)(\sec\theta + \tan\theta) = 1 \\
    \csc^2\theta - \cot^2\theta = (\csc\theta - \cot\theta)(\csc\theta + \cot\theta) = 1  
\end{aligned}
$$

So whenever defined,

- $(\sec\theta - \tan\theta)$ and $(\sec\theta + \tan\theta)$ are reciprocals.
- $(\csc\theta - \cot\theta)$ and $(\csc\theta + \cot\theta)$ are reciprocals.

It looks straightforward and perhaps useless at first glance. In fact, this reciprocal relationship allows us to multiply by a convenient form of 1 when evaluating $\int\sec(x)\,\mathrm(d)x$ and $\int\csc(x)\,\mathrm(d)x$. [ref](trig_inverse_trig_int_ref/a1_b1.md).

$$
\begin{aligned}
    \int \sec(x) \,\mathrm{d}x = \ln(\vert \sec(x)+\tan(x) \vert) + C = - \ln(\vert \sec(x)-\tan(x) \vert) + C \\
    \int \csc(x) \,\mathrm{d}x = -\ln(\vert \csc(x)+\cot(x) \vert) + C = \ln(\vert \csc(x)-\cot(x) \vert) + C
\end{aligned}
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