# Problem Set 1.1

[Index](index.md)

---

- [Problem Set 1.1](#problem-set-11)
  - [Problem 1, Page 6](#problem-1-page-6)
  - [Problem 2, Page 6](#problem-2-page-6)
  - [Problem 3, Page 6](#problem-3-page-6)

---

_Page 6 ~ 8_

## Problem 1, Page 6

Under what conditions on $a$, $b$, $c$, $d$ is
$\begin{bmatrix}
c \\
d
\end{bmatrix}$
a mulitiple $m$ of
$\begin{bmatrix}
a \\
b
\end{bmatrix}$?
Start with the two equations $c=ma$ and $d=mb$. By eliminating $m$, find one equation connecting $a$, $b$, $c$, $d$. You can assume no zeros in these numbers.

**Solution**

We are given
$$
c = ma, \qquad d = mb.
$$

Since $a \neq 0$ and $b \neq 0$, we may solve for the scalar $m$:

$$
m = \frac{c}{a} = \frac{d}{b}.
$$
Equating the two expressions for $m$ yields
$$
\frac{c}{a} = \frac{d}{b}.
$$
Cross-multiplying then gives the desired relation
$$
ad = bc.
$$

## Problem 2, Page 6

Going around a triangle from (0, 0) to (5, 0) to (0, 12) to (0, 0), what are those vectors $\vec{u}$， $\vec{v}$， $\vec{w}$? What is $\vec{u} + \vec{v} + \vec{w}$? What are their lengths $\lVert \vec{u} \rVert$ and $\lVert \vec{v} \rVert$ and $\lVert \vec{w} \rVert$? The length squared of a vector $\vec{u} = (u_1, u_2)$ is $\lVert \vec{u} \rVert^2 = u_1^2 + u_2^2$.

**Solution**

Each vector is found by subtracting the coordinates of its starting point from those of its endpoint:

$$
\begin{aligned}
    \vec{u} &= (5,0)-(0,0)=(5,0),\\
    \vec{v} &= (0,12)-(5,0)=(-5,12),\\
    \vec{w} &= (0,0)-(0,12)=(0,-12).
\end{aligned}
$$

The three vectors, placed head-to-tail, form a closed loop, so their sum is the zero vector:

$$
\vec{u}+\vec{v}+\vec{w}
=(5,0)+(-5,12)+(0,-12)
=(0,0)=\vec{0}.
$$

Their lengths are

$$
\begin{aligned}
\lVert\vec{u}\rVert &= \sqrt{5^2+0^2}=5,\\
\lVert\vec{v}\rVert &= \sqrt{(-5)^2+12^2}=13,\\
\lVert\vec{w}\rVert &= \sqrt{0^2+(-12)^2}=12.
\end{aligned}
$$

## Problem 3, Page 6

TODO

<script>
MathJax = {
  tex: {
    inlineMath: [['$', '$'], ['\$', '\$']]
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
