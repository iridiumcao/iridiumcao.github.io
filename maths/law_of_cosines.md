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

# Law of Cosines 余弦定理

[返回目录](index.md)

**已知**：$\triangle{ABC}$中, $\angle{A}$, $\angle{B}$, $\angle{C}$对应的三条边分别是a, b, c

**求证**：

* $a^2 = b^2 + c^2 -2bc\cos{\angle A}$
* $b^2 = a^2 + c^2 -2ac\cos{\angle B}$
* $c^2 = a^2 + b^2 -2ab\cos{\angle C}$

**分析**：

设有一三角形如图所示

![](images/triangle_law_of_cosine_1.png)

$AD \perp BC$，AD是BC上的高, 记为h.

由勾股定理可得：

$b^2=a_1^2+h^2, c^2=a_2^2+h^2$

$\therefore b^2+c^2=a_1^2+a_2^2+2h^2$

$\because a^2 = (a_1 + a_2)^2 = a_1^2+a_2^2+2a_1a_2$

$\therefore b^2+c^2-a^2=2(h^2-a_1a_2)$ 式(1)

欲证 $a^2 = b^2 + c^2 -2bc\cos{\angle A}$

即证 $b^2+c^2-a^2=2bc\cos{\angle A}$ 式(2)

如果式(1)式(2)两式右边相等即得证

即证 $bc\cos{\angle A}=h^2-a_1a_2$

即证 $\cos{\angle A}=\dfrac{h^2-a_1a_2}{bc}$ 式(3)

下面尝试计算 $\cos{\angle A}$

$\cos{\angle A}=cos(\alpha + \beta)=\cos\alpha\cos\beta - \sin\alpha\sin\beta\
               =\dfrac{h}{b}\cdot\dfrac{h}{c} - \dfrac{a_1}{b}\cdot\dfrac{a_2}{c}\
               =\dfrac{h^2-a_1a_2}{bc}$

式(3)得证，所以 $a^2 = b^2 + c^2 -2bc\cos{\angle A}$ 成立，同理可证另外两式。

以上分析过程本身也可以作为证明过程，但也可以整理为更简单的证明形式，如下：

**证明**：

$\because \cos{\angle A}=...=\dfrac{h^2-a_1a_2}{bc}$

$\therefore b^2 + c^2 -2bc\cos{\angle A}\
=b^2+c^2-2(h^2-a_1a_2)\
=(a_1^2+h^2) + (a_2^2+h^2) - 2(h^2-a_1a_2)\
=a_1^2+a_2^2+2a_1a_2\
=(a_1+a_2)^2\
=a^2$

当$\angle{A} \geq \dfrac{\pi}{2}$可以用上面的证明，而当$\angle{A}$为锐角时，即$\angle{A} \lt \dfrac{\pi}{2}$时，则需要下面的证明过程：

![](images/triangle_law_of_cosine_2.png)

由图可知：$a=a_1-a_2$, $\angle{A}=\alpha - \beta$

$\therefore b^2 + c^2 -2bc\cos{\angle A}=b^2 + c^2 -2bc\cos{(\alpha - \beta)}\
=b^2 + c^2 - 2bc(\cos\alpha\cos\beta+\sin\alpha\sin\beta)\
=b^2 + c^2 - 2bc(\dfrac{h}{b}\cdot\dfrac{h}{c} + \dfrac{a_1}{b}\cdot\dfrac{a_2}{c})\
=(a_1^2+h^2) + (a_2^2 + h^2) - 2bc\cdot\dfrac{h^2+a_1a_2}{bc}$

$=...\
=(a_1-a_2)^2\
=a^2$

综上，$a^2 = b^2 + c^2 -2bc\cos{\angle A}$得证，另外两种情况类似可证。

---

后记，我的证明过程，用到了三角函数，而且分了两种情况，显得太简洁，对知识量要求也比较高，刚上初中的娃娃应该不太容易看懂。这个网站也有一个[证明](https://www.mathopenref.com/lawofcosinesproof.html)，它只证了相当于我这里的第一种情况，证明过程中也用到三角函数，但要简单一些。