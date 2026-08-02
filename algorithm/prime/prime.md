# 素数判定

[返回目录](../index_zh.md)

素数是只有1和它自身两个约数的大于1的整数。即一个数是素数的充分必要条件如下：

* 整数
* 大于1
* 只有1和它自身两个约数

给定一个正整数，如何通过程序判断它是否是素数，是本文要解决的问题。

我们可以用穷举法判断一个数是否为素数，从2开始到它本身，一个一个去除，只要能整除其中任意一个，它就不是素数。C代码如下：

```c
int isPrime(long n)
{
    if (n < 2)
    {
        return 0;
    }

    for (int i = 2; i <= n - 1; i++) // 从 2 开始一路试到 n-1
    {
        if (n % i == 0)
        {
            return 0;
        }
    }

    return 1;
}
```

但是，上面这个方法，对于较大的数，性能比较差，我们似乎用不着尝试那么多数。
考虑到一个大于或等于2的数如果是合数，它必然能表示为另外两个大于或等于2的数的乘积，而这个乘积的两个因数，至少有一个小于或等于它的平方根。

```text
假设a是合数，且 a = bc, b >= 2, c >=2,
则 b 和 c 不可能同时大于a的平方根 sqrt(a)

证明：
如果 b > sqrt(a) 且 c > sqrt(a)
则 a = bc > sqrt(a) * sqrt(a) = a
得 a > a
矛盾。

衍生：
b 和 c 中必然有一个小于或等于 sqrt(a)
```

上面得到的结论对我们用计算机方法判定一个数是否为素数非常有用，我们最多只需要测试 `sqrt()` 这么多次数就行了，如此，前面的C代码可以改进为：

```c
int isPrime(long n)
{
    if (n < 2)
    {
        return 0;
    }

    long limit = sqrt(n);
    for (long i = 2; i <= limit; i++) // 2 ~ sqrt(n)
    {
        if (n % i == 0)
        {
            return 0;
        }
    }

    return 1;
}
```

完整的代码实现参[prime.c](prime.c)，在Linux平台下，因为用到 `<math.h>` 库，编译时必须加上 `-lm` 参数，编译和运行记录如下：

```text
$ gcc prime.c -o prime -lm
$ ./prime 
2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
```

在实际写C代码时，为了避免引入 `<math.h>` 库（省去 `-lm` 编译参数）以及规避浮点数转换的开销，我们经常会将条件等价转换为纯整数运算 `i <= n / i` （注意：写成 `n/i` 而不是 `i*i` 是为了防止大数乘法溢出）。”

```c
int isPrime(long n)
{
    if (n < 2)
    {
        return 0;
    }

    for (long i = 2; i <= n / i; i++)
    {
        if (n % i == 0)
        {
            return 0;
        }
    }

    return 1;
}
```

完整的代码实现参[prime2.c](prime2.c)，编译和运行记录如下：

```plaintext
PS ...> gcc .\prime2.c -o prime2.exe
PS ...> .\prime2.exe                
2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 
```

---

后记，因为阅读[《算法·第4版》](https://book.douban.com/subject/19952400/)(Robert & Kevin)，书中第一章第13页提到求素数的算法，故做了一点小小的研究，记录于此。

还有[Eratosthenes 筛法](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes_)效率更高。

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