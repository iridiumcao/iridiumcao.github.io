# 代数数和超越数的区别和联系

[返回目录](index.md)

按：维基百科是很好的参考资料，但最好中英文版都看，它们往往有一些细微的差别，很能帮助理解。ChatGPT是很好的工具，但对专业问题回答不是很好，可能是话题小众，材料不够，再加上中文材料本来就少。凡是用ChatGPT，一定要小心它看似一本正经的错误答案。

## 定义

综合维基百科的信息，可以简单理解为，**有理系数的多项式的根为代数数，除此之外的数都是超越数**。

【代数数】

代數數指任何整係數多项式的複根。（摘录自[维基百科中文版](https://zh.wikipedia.org/wiki/%E4%BB%A3%E6%95%B8%E6%95%B8)）

An algebraic number is a number that is a root of a non-zero polynomial in one variable with integer (or, equivalently, rational) coefficients. （摘录自[维基百科英文版](https://en.wikipedia.org/wiki/Algebraic_number)）

以上来自维基百科的内容，已经讲清楚了。整数系数的根就是代数数。英文版里补充说明等价的实数系数也行，这防止有的人耍小聪明，硬说$0.1x$的系数不是整数，所以它的根不是代数数。

【超越数】

超越數（transcendental number）是指任何一個不是代數數的无理数。只要它不是任何一個有理係數代數方程的根，它即是超越數。最著名的超越數是e以及π。（摘录自[维基百科中文版](https://zh.wikipedia.org/wiki/%E8%B6%85%E8%B6%8A%E6%95%B8)）

In mathematics, a transcendental number is a number that is not algebraic—that is, not the root of a non-zero polynomial of finite degree with rational coefficients. The best known transcendental numbers are π and e. （摘录自[维基百科英文版](https://en.wikipedia.org/wiki/Transcendental_number)）

这个概念的中英文解释都差不多，中文版大概是从英文版翻译过去的吧。这里提到的多项式系数的范围的是有理数，比之前定义代数数上更简洁。

## ChatGPT

神器ChatGPT在对小众专业问题的回答上，表现不佳，特别是中文内容更要注意。

问：请简单讲一下代数数和超越数的区别和联系

答：代数数指的是可以表示为一个代数方程的根的实数或复数，也就是说，代数数是代数方程的解。例如，$2$是线性方程$2x-4=0$的根，而$\sqrt{2}$是方程$x^2-2=0$的根。

超越数则是不能表示为代数方程的根的实数或复数。例如，圆周率$π$和自然对数的底数$e$都是超越数。

代数数和超越数之间没有太多联系，它们是两种不同类型的数。一个有趣的事实是，任何代数数的集合都是可数的，而超越数的集合是不可数的。这意味着，代数数只占了所有实数或复数中的一小部分，超越数才是大多数实数或复数。

![Algebraic and Transcendental Numbers](images/algebraic_and_transcendental_numbers_chatgpt.png)

点评：

ChatGPT的回答很有问题，因为代数方程对应多项式的系数范围比有理数大，如此，整个说法就是错误的。重要的事情再说一遍，小众的专业问题，不能轻信ChatGPT。

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