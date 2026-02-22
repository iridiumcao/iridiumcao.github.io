# 自然常数$e$ (Natural Constant)

[返回目录](index.md)

自然常数来源于复利问题，假如本金为$a$, 年利率为$r$, 则一年后连本带利

$$ amount = a(1+r) $$

假如存款人和银行修改约定为一年结算2次，即半年结算一次，利息也减半为$\dfrac{r}{2}$，则一年后连本带利

$$ amount = a\left(1+\dfrac{r}{2}\right)^2 $$

更进一步，假如存款人和银行修改约定为一年结算$n$次，即$\dfrac{1}{n}$年结算一次，利息也减少为$\dfrac{r}{n}$，则一年后连本带利

$$ amount = a\left(1+\dfrac{r}{n}\right)^n $$

是不是$n$越大，最后得到的金额$amount$也越大呢？我们可以通过求$amount$的极限来验证

$$
amount 
= \lim_{n\to\infty} a\left(1+\dfrac{r}{n}\right)^n 
= a\lim_{n\to\infty} \left(1+\dfrac{1}{\dfrac{n}{r}}\right)^{\tfrac{n}{r}r}
= a\left[\lim_{\tfrac{n}{r}\to\infty} \left(1+\dfrac{1}{\dfrac{n}{r}}\right)^{\tfrac{n}{r}}\right]^r
= a\left[\lim_{n\to\infty} \left(1+\dfrac{1}{n}\right)^{n}\right]^r
$$

上式中$a$和$r$都是常数，我们只要计算$\left(1+\dfrac{1}{n}\right)^{n}$的极限值就行：

$$\lim_{n\to\infty} \left(1+\dfrac{1}{n}\right)^{n}$$

参下表，当$n$值在不断增加时，$\left(1+\dfrac{1}{n}\right)^n$越来越稳定，趋近于$2.7182820\ldots$，这就是我们要得到的极限值，一般用$e$来表示，近似于2.718

| $n$           | $\left(1+\dfrac{1}{n}\right)^n$   |
|-------------|-------------|
|           1 |           2 |
|          10 |  2.59374246 |
|         100 | 2.704813829 |
|        1000 | 2.716923932 |
|       10000 | 2.718145927 |
|      100000 | 2.718268237 |
|     1000000 | 2.718280469 |
|    10000000 | 2.718281694 |
|   100000000 | 2.718281798 |
|  1000000000 | 2.718282052 |
| 10000000000 | 2.718282053 |

所以，回到前面提到的问题，假如本金为$a$, 年利率为$r$，则一年后连本带利最多可以得到的金额是

$$ amount = a \cdot e^r$$

## 证明 $\left(1+\dfrac{1}{x}\right)^x$ 是收敛的

> 函数单调且有上界，则这个函数是收敛的。

先证函数 $f(x) = \left(1+\dfrac{1}{x}\right)^x$ 是递增的，比较 $f(n)$ 和 $f(n+1)$ 的大小即可。

$$
\begin{aligned}
  f(n) &= \left(1+\dfrac{1}{n}\right)^n \\
       &= \sum_{k=0}^n\binom{n}{k}\dfrac{1}{n^k} \\
       &= 1 + 1 + \dfrac{1}{2!}\left(1-\dfrac{1}{n} \right) + + \dfrac{1}{3!}\left(1-\dfrac{1}{n} \right)\left(1-\dfrac{2}{n} \right) + \cdots \\

  f(n+1) &= \left(1+\dfrac{1}{n+1}\right)^{n+1} \\
       &= \sum_{k=0}^{n+1}\binom{n+1}{k}\dfrac{1}{(n+1)^k} \\
       &= 1 + 1 + \dfrac{1}{2!}\left(1-\dfrac{1}{n+1} \right) + + \dfrac{1}{3!}\left(1-\dfrac{1}{n+1} \right)\left(1-\dfrac{2}{n+1} \right) + \cdots
\end{aligned}
$$

对  $f(n)$ 和 $f(n+1)$ 的展开式逐项比较，可知 $f(n) < f(n+1)$.

再证明 $f(x)$ 有上界：

$$
\begin{align}
  f(n) &= 1 + 1 + \dfrac{1}{2!}\left(1-\dfrac{1}{n} \right) + \dfrac{1}{3!}\left(1-\dfrac{1}{n} \right)\left(1-\dfrac{2}{n} \right) + \cdots \\
       &< 1 + 1 + \dfrac{1}{2!} + \dfrac{1}{3!} + \cdots \\
       &< 1 + 1 + \dfrac{1}{2} + \dfrac{1}{4} + \cdots \\
       &= 3
\end{align}
$$

以上(2)到(3)的比较中用到了 $k!=1⋅2⋅3⋯k≥1⋅2⋅2⋯2=2^{k−1}$ 这个不等式。

这里至少说明3是它的上界，虽然离2.7有点远，但确实是个上界。这个证明不算多严谨，不过比较形象好懂。

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