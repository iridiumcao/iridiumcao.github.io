# 计算集合中元素的个数

[返回目录](index.md)

按：本文从Google Sites的旧站搬迁而来。

集合元素的个数，叫「势」，英文名叫「Cardinality」。集合 A 的「势」记做$\vert A \vert$或 card(A). 本文记录「[排容原理(Inclusion–exclusion_principle)](https://zh.wikipedia.org/wiki/%E6%8E%92%E5%AE%B9%E5%8E%9F%E7%90%86)」的一个应用记录。

## 实例

我们可以从网站的「用户登录表」中查到任意时间段中登录的用户集。如果不借用数据库支持的集合操作，我们能查到如下数据：

（这里假定四、五、六月登录的用户集合分别是：A, B, C）

| 用户集合 | 业务含义 |
|-------|----------------------------------|
| A     | 四月份登录网站的用户集合A        |
| B     | 五月份登录网站的用户集合B        |
| C     | 六月份登录网站的用户集合C        |
| A∪B   | 四、五月份登录网站的用户集合     |
| B∪C   | 五、六月份登录网站的用户集合     |
| C∪A   | 四、六月份登录网站的用户集合     |
| A∪B∪C | 四、五、六月份登录网站的用户集合 |

## 问题

因业务需要，需求出：

1. 在四月份登录网站的用户中，有多少人也在五月也登录了？
1. 有多少人每月都登录了网站？
1. 五月中新登录的用户中，有多少人在六月也登录了？

## 分析

### 1. 在四月份登录网站的用户中，有多少人也在五月也登录了？

这其实是求四月和五月用户集合的交集的元素个数：$\vert A\cap B\vert$

计算如下：
$\vert A\cap B\vert=\vert A \vert + \vert B \vert-\vert A \cup B \vert$

### 2. 有多少人每月都登录了网站？

每月都登录网站的话，这类人相当于 A, B, C 三个集合的交集：A∩B∩C

计算如下：

$\vert A\cap B\cap C \vert = \vert A \vert + \vert B \vert + \vert C \vert - \vert A \cup B \vert - \vert B\cup C \vert - \vert C \cup A \vert + \vert A\cup B\cup C \vert$ 

### 3. 五月中新登录的用户中，有多少人在六月也登录了？

五月新登录的用户即五月登录了但四月没有登录的用户：B - A

这部分在六月份也登录的集合是：

$(B - A) \cup C = \vert B \vert - \vert A \vert - \vert B \cup C \vert + \vert C \cup A \vert$

## 其他

Oracle 是支持集合运算的（参[《查询集的集合操作》](https://sites.google.com/site/iridiumsite/it/database/operation-of-set)），可以不用上面的计算。但也有不支持集合运算符的数据库，就必须用到上面的计算了。

---

参：

* <http://en.wikipedia.org/wiki/Cardinality>
* <http://en.wikipedia.org/wiki/Inclusion%E2%80%93exclusion_principle>

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