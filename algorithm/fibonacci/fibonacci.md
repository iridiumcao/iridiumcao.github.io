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

# Fibonacci 问题

[返回目录](../index.md)

这个问题很经典，相关的讨论和研究也算是很成熟了。它是算法问题的典型素材，仍然非常值得在此记录和思考——即使是重复别人的思考。

## 1. 来源

传说 Fibonacci 研究过这个假定的兔子繁殖问题：

* 月初有一对刚出生的兔子
* 兔子出生两月后开始生育，每月都生一次，每次都生一对，不受性别限制
* 兔子万寿无疆（不会死去）
* 兔子交配没有伦理限制
* 到某月的兔子数量是多少呢？

假设第 $n$ 月的兔子数量是 $f(n)$, 则该月的兔子总数为上月的兔子数加上新生的兔子数，上月的兔子数就是 $f(n-1)$，而新生的兔子数是多少？本月新生兔子数，即上月的成熟兔子数，上月的成熟兔子数，即上上月的兔子总数，即 $f(n-2)$

即可得到公式： $f(n)=f(n-1)+f(n-2)$

衍生数列：每月新增兔子数量。

|  时间（月） |  新生兔子数(对) |  成熟兔子数(对) |  兔子总数(对) |
|-------------|-------------|-------------|-----------|
|  1          |  1          |  0          |  1        |
|  2          |  0          |  1          |  1        |
|  3          |  1          |  1          |  2        |
|  4          |  1          |  2          |  3        |
|  5          |  2          |  3          |  5        |
|  6          |  3          |  5          |  8        |

## 2. Java 实现1

简单用代码实现求 f(n) 的代码如下：

```java
public int fibonnaci(int i) {
    if (i < 0)
        return 0;
    if (i == 1 || i == 2)
        return 1;
    return fibonnaci(i - 1) + fibonnaci(i - 2);
}
```

完整的可运行的代码参[这里](Fibonnaci1.java)。

## 3. Java 实现2

还可以利用Java Stream的功能实现一个Fibonacci数列生成器

|         | 1 | 1 | 2 | 3 | 5 | 8 | 13 | 21 | 34 |
|---------|---|---|---|---|---|---|----|----|----|
| round 1 | i | j | k |   |   |   |    |    |    |
| round 2 |   | i | j | k |   |   |    |    |    |
| round 3 |   |   | i | j | k |   |    |    |    |
|   ...   |   |   |   |   |   |   |    |    |    |

```java
class FibSupplier implements LongSupplier {
    private long i = 1, j = 1;

    public long getAsLong() {
        long r = i;
        long k = i + j;
        i = j;
        j = k;
        return r;
    }
}
```

调用语句如下：

```java
LongStream fib = LongStream.generate(new FibSupplier());
fib.limit(10).forEach(System.out::println);
```

完整的可运行的代码参[这里](Fibonnaci2.java)。

这是[廖雪峰讲解Stream](https://www.liaoxuefeng.com/wiki/1252599548343744/1322655160467490)时提到的一种解法。

---

参考：

* [维基百科·Fibonacci 数列](https://zh.wikipedia.org/wiki/%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0)
* 本文从[Google Sites](https://sites.google.com/site/iridiumsite/it/algorithms/fibonacci)迁移而来
