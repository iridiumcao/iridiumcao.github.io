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

# Probability Axioms 概率論公理

[返回目录](index.md)

## 三条公理

1. 任一事件的概率都可以用0到1区间上的一个实数来表示。
2. 整体样本集合中的某个基本事件发生的概率为1。更加明确地说，在样本集合之外已经不存在基本事件了。
3. 不相交子集的并的事件集合的概率为那些子集的概率的和。如果存在子集间的重叠，这一关系不成立。

## 引理

$$ P(A\cup B)=P(A)+P(B)-P(A\cap B) $$

$$ P(\Omega -E)=1-P(E) $$

$$ P(A\cap B)=P(A)\cdot P(B\vert A) $$

可以得出A和B是独立的当且仅当

$$ P(A\cap B)=P(A)\cdot P(B) $$

还可以推出贝叶斯定理

$${\displaystyle P(A|B)={\frac {P(B|A)P(A)}{P(B)}}}$$

參考資料

* [維基百科·機率公設](https://zh.wikipedia.org/wiki/%E6%A9%9F%E7%8E%87%E5%85%AC%E8%A8%AD)
