# Problem Set 1.2

[Index](index.md)

---

- [Problem Set 1.2](#problem-set-12)
  - [Problem 1, Page 15](#problem-1-page-15)
  - [Problem 2, Page 15](#problem-2-page-15)
  - [Problem 3, Page 15](#problem-3-page-15)
  - [Problem 4, Page 15](#problem-4-page-15)
  - [Problem 5, Page 15](#problem-5-page-15)
  - [Problem 6, Page 15](#problem-6-page-15)
  - [Problem 7, Page 15](#problem-7-page-15)
  - [Problem 8, Page 15](#problem-8-page-15)
  - [Problem 9, Page 15](#problem-9-page-15)

---

_Page 15 ~ 17_

## Problem 1, Page 15

## Problem 2, Page 15

## Problem 3, Page 15

## Problem 4, Page 15

## Problem 5, Page 15

## Problem 6, Page 15

## Problem 7, Page 15

## Problem 8, Page 15

## Problem 9, Page 15

The slopes of the arrows from $(0, 0)$ to $(v_1, v_2)$ and $(w_1, w_2)$ are $\dfrac{v_2}{v_1}$ and $\dfrac{w_2}{w_1}$. Suppose the product $\dfrac{v_2 w_2}{v_1 w_1}$ of those slopes are $-1$. Show that $\vec{v}\cdot\vec{w} = 0$ and the vectors are perpendicular.

**Analysis**

$$
\begin{aligned}
    &\vec{v} \perp \vec{w} \\
    \Leftrightarrow &\vec{v}\cdot\vec{w} = 0 \\
    \Leftrightarrow &
        \begin{bmatrix}
        v_1 \\
        v_2
        \end{bmatrix}
        \cdot
        \begin{bmatrix}
        w_1 \\
        w_2
        \end{bmatrix}
        = v_1 w_1 + v_2 w_2 = 0 \\
    \Leftrightarrow &\dfrac{v_2 w_2}{v_1 w_1} = -1
\end{aligned}
$$

**Proof**

Since both slopes are defined, $v_1 \ne 0$ and $w_1 \ne 0$. By assumption,

$$
\frac{v_2w_2}{v_1w_1}=-1.
$$

Multiplying both sides by $v_1w_1$ gives

$$
v_2w_2=-v_1w_1.
$$

Therefore,

$$
\vec v\cdot\vec w=v_1w_1+v_2w_2=0.
$$

Let $\theta$ be the angle between $\vec v$ and $\vec w$. Since both vectors are nonzero,

$$
\cos\theta
=\frac{\vec v\cdot\vec w}{\|\vec v\|\,\|\vec w\|}
=0.
$$

Thus $\theta=\pi/2$, so $\vec v$ and $\vec w$ are perpendicular. $\square$

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
