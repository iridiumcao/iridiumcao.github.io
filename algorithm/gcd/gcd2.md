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

# 求最大公约数(Java, 辗转相除法)

[返回目录](../index.md)

本站[求最大公约数](gcd.md)比较详细介绍了求最大公约的各种方法，本文仅记录辗转相除法的Java实现。

关于余数的定义，参本站《求余运算》，这里的求最大公约数 GCD(Greatest Common Divisor) 的运算只考虑 Java 语言能表达的整数范围。

【定理】两个整数 $\{m, n\} (m \gt n)$ 的最大公约数，和 $\{n, m \mod n\}$ 的最大公约数是相等的。${m \mod n}$ 表示 m 除以 n 的余数。

【证明】

假设 ${m \mod n = r}$

则存在某个整数 k, 有 m = kn + r

则由 m - kn = r，假设 a 是 m 和 n 的公约数，即 a$\vert$m, a$\vert$n，进而得到 a$\vert$r，由 a$\vert$n 和 a$\vert$r 得出：a 也是 n 和 r 的公约数

即：如果 a 是 m 和 n 的公约数，则 a 也是 n 和 r 的公约数 -- 结论1

再由 kn + r = m，假设 b 是 n 和 r 的公约数，即 b$\vert$n, b$\vert$r，进而得到 b$\vert$m，由 b$\vert$n 和 b$\vert$m 得出：b 也是 m 和 n 的公约数

即：如果 b 是 n 和 r 的公约数，则 b 也是 m 和 n 的公约数 -- 结论2

由结论1和结论2可以得知：m, n 的公约数集合和 n, r 的公约数集合是同一个集合，当然，m, n 的最大公约数也就是 n, r 的最大公约数。

【求解】

具体对两个数求它们的最大公约数，一般都依据前面的定理反复运算，直到余数为0，这时较小的那个就是最大公约数。这种求解方法，称为辗转相除法，也称为欧几里德算法(Euclidean Algorithm).

【非递归实现】

以下是依据前面的定理的一个非递归 Java 版本：

```java
int calculateGcd(int m, int n) {
    if (m < n) {
        int a = m;
        m = n;
        n = a;
    }
    int r = m % n;
    while (r != 0) {
        m = n;
        n = r;
        r = m % n;
    }
    return n;
}
```

【递归实现】

递归版本的代码非常简单，以致有些看不出什么东西的感觉：

```java
int calculateGcd3(int a, int b) {
    if (b == 0) {
        return a;
    }
    return this.calculateGcd3(b, a % b);
}
```

[代码下载](EuclidGcd.java)

【参考】

* [求两个整数的最大公约数](http://blog.csdn.net/caoi/article/details/1231871) (CSDN)
* 对欧几里德算法更详细的资源: [Euclidean Algorithm, Wikipedia](http://en.wikipedia.org/wiki/Euclidean_algorithm)

本文是从Google Sites的[旧站](https://sites.google.com/site/iridiumsite/it/algorithms/gcd)转移过来的。

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