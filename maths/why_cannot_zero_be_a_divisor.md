# 零为何不能做除数？

[返回目录](index.md)

前段时间儿子问了这个问题。儿子下学期上三年级，为了能让小学二年级刚毕业的儿子能理解这个问题，我想了一个说法，现在感觉很有意思，这里记一下。

我们知道乘法和除法是互逆的。

已知 $3 \times 0 = 0$，根据乘除法的关系，可以得到$\dfrac{0}{3} = 0$，如果允许0作除数，就可以得到 $\dfrac{0}{0} = 3$。

再举一个例子。

已知 $5 \times 0 = 0$，根据乘除法的关系，可以得到 $\dfrac{0}{5} = 0$，如果允许0作除数，就可以得到 $\dfrac{0}{0} = 5$。

类似，可以举很多同类的例子。

从上面两个式子来看，可以发现 $\dfrac{0}{0}$ 的计算结果，是不确定的，可以等于任意数。这个情况和已经学习过的数学系统不兼容。

上面的除数和被除数都是 0 的情况。

下面想办法构造一个被除数不为 0 的式子：

假如 $\dfrac{5}{0} = ?$ (因为儿子还没学方程，这里使用更直观的问号而非 x)

根据乘除互逆的性质，可以得到 $0 \times ? = 5$，这又和现有的数学系统矛盾了。根据“零乘以任何数都等于零”，$0 \times ? = 0$，而这里却等于5。这个情况和现有数学系统不兼容。

综上，干脆就规定目前的数学系统不能用0作除数。

附：

1. 本站相关页面: [Java 对零作为除数的处理](../java/zero_devide.md)
2. 这篇文章从[Google Sites](https://sites.google.com/site/iridiumsite/Home/others/mathematics/algebra/why-not-zero)转移而来，大约写于2019年上半年，算是一次对娃娃功课辅导的记录。
3. 知乎平台上这篇讲得更好：<https://www.zhihu.com/question/20785233>

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