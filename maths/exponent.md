# 指数范围的扩充过程

[Index](index_zh.md)

2026.08.08

最初我们接触指数运算时，指数通常是自然数，它表示多个相同因数相乘的简写形式，比如 $5\times 5 \times 5 = 5^3$，但后来指数并不限于自然数，而是扩充到分数，无理数，实数，甚至复数。本文将简述指数的范围的扩充过程（不包括复数）。

## 1. 自然数指数——重复乘法

指数最早出现的时候，是为了简化相同因数的乘法，比如5个2相乘：

$$
2\times2\times2\times2\times2
$$

用指数方式记作 $2^5$. 这里很自然就定义了自然数的指数：

$$
a^n := \underbrace{aa \cdots a}_{n \text{ times}}, \qquad n \in \mathbb{N}^+
$$

依据定义，很容易得到指数的两条运算规律：

$$
\boxed{
    a^m\cdot a^n=a^{m+n} \qquad (a^m)^n=a^{mn}
}
$$

在扩充指数范围时，我们希望原有的指数运算规律继续成立，这也是后面各种定义的主要出发点和“公理”要求。

## 2. 零指数

依据

$$
a^m a^n=a^{m+n}
$$

令

$$
m=3,\quad n=0
$$

我们构造了一个包含零指数的等式：

$$
a^3a^0=a^3
$$

但零指数前面没有定义，对于 $a \neq 0$，为了让 $a^{m}a^n=a^{m+n}$ 在 $n=0$ 时仍然成立，我们必须定义：

$$
\boxed{
    a^0:=1, \qquad a \neq 0
}
$$

到这里，为了让$a^m a^n=a^{m+n}$对零指数也成立，保持定义的一致性（consistency），我们增加一个新的定义：$a^0:=1$

## 3. 负整数指数

我们再继续推演，当 $a \neq 0$ 时，令

$$
a^3a^{-3}=a^0=1
$$

那么只能有

$$
a^{-3}=\frac1{a^3}
$$

于是我们再定义

$$
\boxed{
    a^{-n}:=\frac1{a^n}, \qquad a \neq 0
}
$$

这里我们再增加一条指数定义：如果指数为负数，则它的值等于指数为正数时的倒数。

我们并不是随意规定负指数的含义，而是要求原来的指数规律继续成立。于是负指数的定义被“逼”了出来。

## 4. 分数指数（有理数指数）

我们先看一个简单的例子：$2^{\frac{1}{2}}$，
我们希望在扩充指数的范围时，依然遵循前面的规律。

$$
(2^{\frac{1}{2}})^2 = 2^{\frac{1}{2}\times 2}=2
$$

因此

$$
2^{\frac{1}{2}} = \sqrt{2}
$$

更一般地，若

$$
x=a^{\frac{1}{n}}
$$

就要求

$$
x^n=a
$$

> 注：为了简化讨论，本节内容限定 $a \gt 0, x \in \mathbb{R}$，对于 $a \lt 0$ 的情况，这里略过。

因此我们定义

$$
\boxed{
    a^{\frac{1}{n}}:=\sqrt[n]{a}, \qquad a \gt 0
}
$$

我们再进一步考察 $a^{\frac{m}{n}}$，有

$$
\boxed{
    a^{\frac{m}{n}} = (a^{\frac{1}{n}})^m=\sqrt[n]{a^m}, \qquad a \gt 0
}
$$

这能扩展到有理数，还是因为要**保持指数运算规律不变**的原因。

## 5. 实数指数

前面的推导已经适合所有有理数，但如果指数的范围扩大实数，即还需包含无理数，上面的方法就都失效了。比如$2^\pi$的值应该是多少呢？我们这里可以考虑用有理数无限逼近 $\pi$:

$$
3 \quad 3.1 \quad 3.14 \quad 3.141 \quad \cdots
$$

于是可以通过计算

$$
2^3 \quad 2^{3.1} \quad 2^{3.14} \quad 2^{3.141} \quad \cdots
$$

来逼近 $2^\pi$. 我们希望当指数 $x$ 越来越接近 $\pi$ 时，函数 $2^x$ 对应的值也越来越接近某个固定数，于是定义

$$
2^\pi := \lim_{q\to\pi}2^q, \qquad q \in \mathbb{Q}
$$

这里要求函数必须连续，实数指数其实是有理数指数连续延拓得到的。

再一般一点即可定义：

$$
\boxed{
    a^{x} := \lim_{n\to\infty} a^{x_n},\quad\text{where }x_n\in\mathbb{Q}\text{ and }x_n\to x
}
$$

只要这个极限存在，而且与逼近方式无关，定义就是合理的。这就是实数指数。

{% comment %}
## 6. 复数指数

TODO

## 7. $0^0$

参考：

- https://gemini.google.com/app/cbde5eed0919038d
- https://chatgpt.com/c/6a77559e-bc64-83ec-b443-22ba83ede302
- https://chatgpt.com/c/6a72ca61-1764-83ec-b5cd-dcbaf7ba20f6
- https://chatgpt.com/c/6a775589-aa90-83ec-96c9-10f245c4e456
- https://x.com/i/grok?conversation=2086225805185896567
- https://www.doubao.com/chat/38437019434760706?channel=NsMfD

{% endcomment %}

指数范围的每一次扩充，本质上都是在已有定义的基础上，要求原有的运算规律继续成立，并寻找一个与已有定义相容的新定义。

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