# 自然常数$e$ Natural Constant

[返回目录](index.md)

自然常数来源于复利问题，假如本金为$a$, 年利率为$r$, 则一年后连本带利

$$ amount = a(1+r) $$

假如存款人和银行修改约定为一年结算2次，即半年结算一次，利息也减半为$\dfrac{r}{2}$，则一年后连本带利

$$ amount = a(1+\dfrac{r}{2})^2 $$

更进一步，假如存款人和银行修改约定为一年结算$n$次，即$\dfrac{1}{n}$年结算一次，利息也减少为$\dfrac{r}{n}$，则一年后连本带利

$$ amount = a(1+\dfrac{r}{n})^n $$

是不是$n$越大，最后得到的金额$amount$也越大呢？我们可以通过求$amount$的极限来验证

$$
amount 
= \lim_{n\to\infty} a(1+\dfrac{r}{n})^n 
= a\lim_{n\to\infty} (1+\dfrac{1}{\dfrac{n}{r}})^{\tfrac{n}{r}r}
= a[\lim_{\tfrac{n}{r}\to\infty} (1+\dfrac{1}{\dfrac{n}{r}})^{\tfrac{n}{r}}]^r
= a[\lim_{n\to\infty} (1+\dfrac{1}{n})^{n}]^r
$$

上式中$a$和$r$都是常数，我们只要计算$(1+\dfrac{1}{n})^{n}$的极限值就行：

$$\lim_{n\to\infty} (1+\dfrac{1}{n})^{n}$$

参下表，当$n$值在不断增加时，$(1+\dfrac{1}{n})^n$越来越稳定，趋近于$2.7182820\ldots$，这就是我们要得到的极限值，一般用$e$来表示，近似于2.718

| $n$           | $(1+\dfrac{1}{n})^n$   |
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
