# 排列组合

[Index](index_zh.md)

2026.08.07

## 排列(Permutation)

从 $n$ 个不同元素中取出 $m$ 个，按照一定顺序排列，得到的每一种结果都叫做一个**排列**。不同排列的总数即**排列数**。

比如从5个不同颜色的小球中取两个，它的排列数是 $5 \times 4$，因为第一个位置的球有5种取法，而第二个位置的球只剩下4个取法，总共就是$5 \times 4$种取法。

扩展一下，假如从 $n$ 个不同颜色的球中挑 $m$ 个，

- 第一个位置可以放 $n$ 个球中的任意一个，共有 $n$ 种挑法
- 第二个位置的球有 $(n-1)$ 种挑法
- ……
- 第 $m$ 个位置的球有 $(n-m+1)$ 种挑法

它的排列数就是

$$
\begin{aligned}
&n(n-1)\cdots(n-m+1)\\
=&\frac{n(n-1)\cdots(n-m+1)(n-m)\cdots1}
{(n-m)\cdots1}\\
=&\frac{n!}{(n-m)!}
\end{aligned}
$$

### 全排列

这是排列的一个特例，即集合中所有元素都参与排列，它的排列数就是元素个数的阶乘:

$$
n(n-1)(n-2) \dots 1 = n!
$$

### 排列数的符号

英语中常用 `Permutation` 表示排列；在一些教材和地区，也会使用 `Arrangement` 一词。因此排列数的记号并不完全统一，常见的有 $P$ 或 $A$ 等。以下的符号都表示 $\dfrac{n!}{(n-m)!}$：

- $A_n^m$ / $A_m^n$
- ${}_n P_r$ / $P_n^m$ / $P(n, r)$
- $n^{\underline{m}}$ （[下降阶乘](https://en.wikipedia.org/wiki/Falling_and_rising_factorials)）

中国大陆用 $A_n^m$ 和 $P_n^m$ 比较多，为了表述简单无歧义，本站以后将使用下降阶乘 $n^{\underline{m}}$ 表示排列数。

## 组合(Combination)

组合就是从一个集合中挑几个元素，不考虑顺序，放在一起。不同组合的数量就是组合数。

从 $n$ 个元素中挑 $m$ 个元素，不考虑它们的顺序，得到的每一种结果都叫做一个**组合**。用 $\binom{n}{m}$ 表示组合的个数，其中每个组合都有 $m!$ 种不同的排列，所以 $n^{\underline{m}} = \binom{n}{m}m!$，即 $\boxed{\text{排列数}=\text{组合数}\times\text{每个组合的排列数}}$，所以组合数 $\binom{n}{m} = \dfrac{n^{\underline{m}}}{m!}$。这里就得到组合数公式：

$$
\binom{n}{m} = \dfrac{n^{\underline{m}}}{m!} = \dfrac{n!}{m!(n-m)!}
$$

### 组合数的符号

“组合”的术语是 `Combination`，所以好几种组合的符号都用 $C$.

- $\binom{n}{m}$ / $\binom{m}{n}$
- $C_n^m$
- ${}_n C_m$ / $C(n, m)$

中国大陆用 $C_n^m$ 比较普遍，不过为了查阅资料和交流方便，本站以后将使用更流行的 $\binom{n}{m}$。

## 综合理解

将 $n$ 个元素分两段，前半段的元素个数是: $m$，后半段元素个数是 $n-m$

现在将 $n$ 个元素做全排列，

- 第一步，从 $n$ 个元素中挑 $m$ 个元素放入前半段，有 $\binom{n}{m}$ 种选择。
- 第二步，对前半段的 $m$ 个元素全排列，有 $m!$ 种排法
- 第三步，对后半段的 $n-m$ 个元素全排列，有 $(n-m)!$ 种排法

综上可以得到这 $n$ 个元素的全排列是：$\binom{n}{m}m!(n-m)!$

从之前的定义已知 $n$ 个元素的全排列数是 $n!$

所以，

$$
n! = \binom{n}{m}m!(n-m)!
$$

所以这里也能推出组合数公式：

$$
\binom{n}{m}= \dfrac{n!}{m!(n-m)!}
$$

再观察上面的第一步和第二步，我们可以得到排列数

$$
n^{\underline{m}} = \binom{n}{m}m! = \dfrac{n!}{m!(n-m)!} \cdot m! = \dfrac{n!}{(n-m)!}
$$

再观察上面的第一步和第三步，我们可以得到排列数

$$
n^{\underline{n-m}} = \binom{n}{n-m}(n-m)! = \dfrac{n!}{m!(n-m)!} \cdot (n-m)! = \dfrac{n!}{m!}
$$

我们还可以重新设计步骤，先排列后半段：

- 新第一步，从 $n$ 个元素中挑 $n-m$ 个元素放入后半段，有 $\binom{n}{n-m}$ 种选择。
- 新第二步，对后半段的 $n-m$ 个元素全排列，有 $(n-m)!$ 种排法
- 新第三步，对前半段的 $m$ 个元素全排列，有 $m!$ 种排法

综上可以得到这 $n$ 个元素的全排列是：$\binom{n}{n-m}(n-m)!m!$

已知 $n$ 个元素的全排列数是 $n!$

所以,

$$
n! = \binom{n}{n-m}(n-m)!m!
$$

再联系前面的等式 $n! = \binom{n}{m}m!(n-m)!$

所以，

$$
\binom{n}{n-m}(n-m)!m! = \binom{n}{m}m!(n-m)!
$$

化简可得：

$$
\binom{n}{n-m} = \binom{n}{m}
$$

这个代数方式顺理成章，但还有一个更直接的理解方式，即，从 $n$ 个元素中挑 $m$ 个，每挑出的一个组合，就对应剩下的一个组合，两者是一一对应的关系，数量上自然也相等，所以，很自然就能得到 $\binom{n}{n-m} = \binom{n}{m}$。

组合不考虑顺序，所以挑出的 $m$ 个和每挑出的 $n−m$ 个之间存在一一对应；排列考虑顺序，所以两者一般不是同一个数量。

参考：

- [维基百科·下降阶乘](https://en.wikipedia.org/wiki/Falling_and_rising_factorials)(En)
- [维基百科·排列](https://zh.wikipedia.org/wiki/%E6%8E%92%E5%88%97)
- [维基百科·组合](https://zh.wikipedia.org/wiki/%E7%B5%84%E5%90%88)

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