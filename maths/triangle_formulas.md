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

# 三角公式

[返回目录](index.md)
## 0. 常见的特殊角的三角函数值

|   | $0$ | $\frac{1}{6}\pi$ | $\frac{1}{4}\pi$ | $\frac{1}{3}\pi$ | $\frac{1}{2}\pi$ | $1\pi$ | $\frac{3}{2}\pi$ |
| --- | --- | --- | --- | --- | --- | --- | --- |
| $\sin$ | $0$ | $\frac{1}{2}$ | $\frac{\sqrt{2}}{2}$ | $\frac{\sqrt{3}}{2}$ | $1$ | $0$ | $-1$ |
| $\cos$ | $1$ | $\frac{\sqrt{3}}{2}$ | $\frac{\sqrt{2}}{2}$ | $\frac{1}{2}$ | $0$ | $-1$ | $0$ |
| $\tan$ | $0$ | $\frac{\sqrt{3}}{3}$ | $1$ | $\sqrt{3}$ | undefined | $0$ | undefined |
| $\cot$ | undefined | $\sqrt{3}$ | $1$ | $\frac{\sqrt{3}}{3}$ | $0$ | undefined | $0$ |
| $\sec$ | $1$ | $\frac{2\sqrt{3}}{3}$ | $\sqrt{2}$ | $2$ | undefined | $-1$ | undefined |
| $\csc$ | undefined | $2$ | $\sqrt{2}$ | $\frac{2\sqrt{3}}{3}$ | $1$ | undefined | $-1$ |

## 1. 六边形

![三角函数的关系](images/triangle_function_relation.png)

* $\sin\alpha \csc\alpha = 1$
* $\cos\alpha \sec\alpha = 1$
* $\tan\alpha \cot\alpha = 1$

毕达哥拉斯三角恒等式

* $\sin^2\alpha + \cos^2\alpha = 1$
* $\tan^2\alpha + 1 = \sec^2\alpha$
* $1 + \cot^2\alpha = \csc^2\alpha$

## 2. 和差恒等式

![](images/800px-AngleAdditionDiagramSine.svg.png)
![](images/800px-AngleAdditionDiagramTangent.svg.png)

* 正弦 $\sin(\alpha \pm \beta )=\sin \alpha \cos \beta \pm \cos \alpha \sin \beta$
* 余弦 $\cos(\alpha \pm \beta )=\cos \alpha \cos \beta \mp \sin \alpha \sin \beta$
* 正切 $\tan(\alpha \pm \beta )={\dfrac  {\tan \alpha \pm \tan \beta }{1\mp \tan \alpha \tan \beta}}$
* 余切 $\cot(\alpha \pm \beta )={\dfrac  {\cot \alpha \cot \beta \mp 1}{\cot \beta \pm \cot \alpha }}$
* 正割 $\sec(\alpha \pm \beta )={\dfrac  {\sec \alpha \sec \beta }{1\mp \tan \alpha \tan \beta }}$
* 余割 $\csc(\alpha \pm \beta )={\dfrac  {\csc \alpha \csc \beta }{\cot \beta \pm \cot \alpha }}$

这里的两个图形证明非常不错，想当年我的老师可能也是不晓得的。我现在40岁了，也才第一次了解。朝闻道，夕可死也。

Ref: [维基百科·三角恒等式](https://zh.wikipedia.org/wiki/%E4%B8%89%E8%A7%92%E6%81%92%E7%AD%89%E5%BC%8F)