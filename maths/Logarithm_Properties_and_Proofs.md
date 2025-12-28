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

# 对数的三个基本运算性质

[Index](index.md)

假设 $a \in \mathbb{R}, M \in \mathbb{R}, N \in \mathbb{R}, n \in \mathbb{R}, a > 0, a \neq 1, M > 0, N > 0$,
以下三个等式恒成立：

- 性质一 $\log_{a}{(MN)} = \log_{a}{M} + \log_{a}{N}$
- 性质二 $\log_{a}{M^n} = n\log_{a}{M}$
- 性质三 $\log_{a}{\dfrac{M}{N}} = \log_{a}{M} - \log_{a}{N}$

## 证明性质一

【证明一】：

假设 $\log_{a}{M} = p, \log_{a}{N} = q$

则 $M = a^p, N = a^q$

所以 $MN = a^p a^q = a^{p+q}$

所以 $p+q = \log_{a}{(MN)}$

即 $\log_{a}{M} + \log_{a}{N} = \log_{a}{(MN)}$

【证明二】：

$\log_{a}{(MN) = \log_{a}{a^pa^q}} = log_{a}{a^{p+q}} = p+q = \log_{a}{M} + \log_{a}{N}$

## 证明性质二

假设 $\log_{a}{M} = p$

则 $M=a^p$

所以 $M^n = {(a^p)}^{n} = a^{np}$

所以 $\log_{a}{M^n} = \log_{a}{a^{np}} = np = n\log_{a}{M}$

## 证明性质三

性质三并不是独立的，它可以由性质一和性质二直接推出。

根据性质一，有 $\log_{a}{\dfrac{M}{N}} = \log_{a}{MN^{-1}} = \log_{a}{M} + \log_{a}{N^{-1}}$

再根据性质二，有 $\log_{a}{N^{-1}} = -\log_{a}{N}$

所以 $\log_{a}{\dfrac{M}{N}} = \log_{a}{M} - \log_{a}{N}$

## 后记

这三个对数运算性质，分别对应以下指数运算规律：

- $a^p a^q = a^{p+q}$
- $(a^p)^n = a^{pn}$
- $\dfrac{a^p}{a^q} = a^{p-q}$

从这个角度看，对数的运算性质本质上是指数运算规律的“翻译”。

本文中提到的几个对数的运算性质非常基础，甚至可以通过它对应的指数形式很直观地得到它的这些形式，但证明还是有必要的。直觉让人能熟练使用这些性质，但证明能让使用更加可靠。

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