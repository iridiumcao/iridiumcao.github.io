## 等比数列的求和公式

[返回目录](index.md)

如果一个数列，从第二项起每项对它的前项的比是一样的，这个数列就是**等比数列**。假设有一个数列

$a_1, a_2, a_3, ..., a_{n-1}, a_n$ 满足 $\dfrac{a_2}{a_1} = \dfrac{a_3}{a_2} = \cdots =\dfrac{a_n}{a_{n-1}}$

则它为等比数列。不妨设

$q = \dfrac{a_2}{a_1}$

$q$ 一般称为这个等比数列的**公比**。

如此数列也可以表示为

$a_1, a_1q, a_1q^2, ..., a_{1}q^{n-2}, a_{1}q^{n-1}$

数列的和可以直接表示为：

$S_n = a_{1}(1+q+q^2+\cdots+q^{n-2}+q^{n-1})$ -- (1)

两边同时乘以公比 $q$ 得

$qS_n = a_{1}(q+q^2+\cdots+q^{n-2}+q^{n-1}+q^{n})$ -- (2)

上面两式相减，(1) - (2)，得

$(1-q)S_n = a_{1}(1-q^{n})$

所以，当 $q \neq 1$ 时

$S_n = a_{1}\dfrac{1-q^{n}}{1-q}$

而当 $q = 1$ 时

$S_n = na_{1}$

以上最后两个式子就是**等比数列的求和公式**。

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