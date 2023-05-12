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

# 无理数和有理数谁更多 Which is more abundant: Irrational numbers or Rational numbers?

[返回目录](index.md)

## 1. 相关定义

这里自然数集合定义为正整数集合 {1, 2, 3, 4, ...}.

集合中元素的个数，称为集合的**基数**或**势**。如果两个集合的元素是一一对应的，则认为它们的**势**相等。自然数集合的势叫做$\aleph_0$。凡是势为$\aleph_0$的集合，为**可数集合**(countable set)，又称[可列集](http://zh.wikipedia.org/wiki/%E5%8F%AF%E6%95%B8%E9%9B%86)或可数无穷集合。

可数集合指可与自然数集合建立一一对应关系的无穷集合。

## 2. 前导，两个例子

非负偶数集合{0, 2, 4, 6, 8, ...}可以通过函数$f(x)=\dfrac{x}{2}$映射到{0, 1, 2, 3, 4, ...}，再通过函数$f(x)=x+1$映射到{1, 2, 3, 4, 5, ...}，这里的映射都是一一对应，所以它们的势相等，都是$\aleph_0$. 通俗地讲，所有非负偶数的个数和所有自然数的个数是相等的。

前面这个例子，能明确地找到映射函数，但有的可数集合无法找到明确的映射函数，只能通过语言描述。如，偶数集 {..., -6, -4, -2, 0, 2, 4, 6, ...} 不存在一个直接到自然数集的映射函数。但我们可以这样理解：

1. 先变形，将偶数集表示为：{0, 2, -2, 4, -4, 6, -6, ...}
2. 从第一个元素开始数，无论上面集合中的哪个元素，都有一个确定的自然数与之对应，同样，任意一个自然数，在上面的集合中，有且仅有一个确定的元素与之对应。

两者的势一一对应关系，所以偶数集和自然数即的势相等，都是$\aleph_0$. 通俗地讲，所有偶数的个数和所有自然数的个数是相等的。

{0, 2, -2, 4, -4, 6, -6, ...} 中的元素也可以这么去数，任意选中一个这个集合中的一个数，它之前的数是有限的，因此很自然地可以用自然数编号，这样，所有的元素都能用一个自然数标记。

## 3. 有理数的个数

有理数就是两个整数的比例数，可以表示为

$$\dfrac{p}{q}, p \in \mathbb{Z}, q \in \mathbb{Z}$$

这里为了方便，不妨设 $p > 0$, 则可以通过$p+\lvert q \rvert$的值来构造有理数序列。

1. 当$p+\lvert q \rvert = 1$时，$p = 0$，这时能构造出的有理数是0
2. 当$p+\lvert q \rvert = 2$时，这时能构造出的有理数是${\dfrac{0}{2}, \dfrac{1}{1}, \dfrac{-1}{1}}$
3. 当$p+\lvert q \rvert = 3$时，这时能构造出的有理数是${\dfrac{0}{3}, \dfrac{1}{2}, \dfrac{-1}{2}, \dfrac{2}{1}, \dfrac{-2}1{}}$
  
... ...

4. 当$p+\lvert q \rvert = n$时，这时能构造出的有理数是${\dfrac{0}{n}, \dfrac{1}{n-1}, \dfrac{-1}{n-1}, ..., \dfrac{n-1}{1}, \dfrac{-(n-1)}1{}}$

任何一个有理数，都可以在上面的序列中找到，如果从第一个开始编号，每个有理数都将有唯一的编号。如此，有理数的势也是$\aleph_0$.

## 4. 无理数的个数

假设无理数是可数的，可以构造一个可数数列，但我们还能构造一个数和这个数列中的每个数都不相等(参[无理数和有理数哪个多？](https://www.zhihu.com/question/24819394))。这个矛盾说明无理数不可数，并且比$\aleph_0$大，我们一般把无理数的势记为$\aleph_1$，很显然

$$\aleph_1 > \aleph_0$$

据说康托尔算出 $\aleph_1 = 2^{\aleph_0}$，这个我目前还解释不了。

## 5. ChatGPT错了

如果轻信ChatGPT，可能会走入错误的深渊。

![无理数和有理数谁更多？](images/rational_vs_irrational_number.png)