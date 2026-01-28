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

# 求最大公约数

[返回目录](../index.md)

本文的讨论都在整数范围内。

## 1. 定义

* 约数(divisor)：如果一个整数可以表示为另外几个整数的积，则这几个整数就是原数的约数。
* 公约数(common divisor)：几个整数共有的约数，叫做公约数。
  * 性质：如果一个数能同时整除两个整数，则这个数就是这两个整数的公约数。
* 最大公约数(greatest common divisor, gcd)：公约数中的最大者。也称为最大公因數(highest common factor，hcf)。

## 2. 举例说明

假设有两个正整数：20和30。
$20 = 1 \times 20$，所以1和20是20的约数，$20 = 2 \times 10$，所以2和10是20的约数，等等。

* 20的约数有：1, 2, 4, 5, 10, 20
* 30的约数有：1, 2, 3, 5, 6, 10, 30
* 20和30的公约数有：1, 2, 5
* 20和30的最大公约数是：5

## 3. 一些性质

* 1是任何整数的约数。
* 任何整数都是它本身的约数。
* 1的约数是1，除此之外，任何整数都有1和它本身两个约数。
* 任何整数数都是0的约数。
* 两个整数的公约数，等于其中较小的数和两数之差的公约数。
* 两个整数的公约数，等于其中 _较小的数_ 和 _大数除以小数的余数_ 的公约数。（辗转相除法的依据）
* 两个整数的最大公约数是能够同时整除它们的最大的正整数，简单说就是公约数中最大的。

## 4. 公约数求解

* 列舉法：分別列出兩整數的所有因數，並找出最大的公因數。
* 質因數分解：分別列出兩數的質因數分解式，並計算共同項的乘積。
* 短除法：兩數除以其共同質因數，直到兩數互質時，所有除數的乘積即為最大公因數。
* 辗转相除法：两个整数的最大公约数等于其中较小的数和两数相除余数的最大公约数。又称欧几里得算法(Euclidean algorithm)。数学依据是[裴蜀等式, Bézout's identity](https://zh.wikipedia.org/wiki/%E8%B2%9D%E7%A5%96%E7%AD%89%E5%BC%8F)

Ref: 维基词条[最大公因數](https://zh.wikipedia.org/wiki/%E6%9C%80%E5%A4%A7%E5%85%AC%E5%9B%A0%E6%95%B8)和[輾轉相除法](https://zh.wikipedia.org/wiki/%E8%BC%BE%E8%BD%89%E7%9B%B8%E9%99%A4%E6%B3%95)

### 4.1 示例

求解20和30的最大公因数

#### 4.1.1 解法一，列举法

本文一开始的例子即是列举法

#### 4.1.2 解法二，质因数分解

```plaintext
20 = 2 * 10 = 2 * 2 * 5
30 = 2 * 15 = 2 * 3 * 5
所以 gcd(20, 30) = 2 * 5 = 10
```

#### 4.1.3 解法三，短除法

```plaintext
2 | 20 30
   -------
5 | 10 15
   -------
     2  3
```

所以 gcd(20, 30) = 2 * 5 = 10

#### 4.1.4 解法四，辗转相除法

本小节从辗转相减推导辗转相除，丝滑自然。辗转相除的证明可以[参本站的另一篇文章](gcd2.md)，它也给了相应的Java实现，和本文类似。

假若x和y的最大公约数是a，且它们可表示为

```plaintext
x = a * b
y = a * c
令两者之差 z = x - y
则 z = a * (b - c)
```

这说明两数的最大公约数是两数之差的因数。显然，a 也是 x, y, z 三数的公因数。如此，我们可以选用 x, y 中较小的数和 z 相减，继续相减，直到能很明显看出两数的最大公约数是多少。

计算两个非负整数p和q的最大公约数：若q时0，则最大公约数为p。否则，将p除以q得余数r，p和q的最大公约数即为q和r的最大公约数。

例如：

```plaintext
gcd(48, 18) = gcd(48-18, 18)
            = gcd(30, 18)
            = gcd(30-18, 18)
            = gcd(12, 18)
            = gcd(12, 18-12)
            = gcd(12, 6)
            = gcd(12-6, 6)
            = gcd(6, 6) // 到这里即可以看出最大公约数是6
            = gcd(6 - 6, 6) // 本步是为了和使用出发的方式一致而作的冗余步骤
            = gcd(0, 6)
            =6
```

上面这个过程，可以简化为大数除以小数，再求小数和余数的最大公约数，如此反复，过程如下：

```plaintext
gcd(48, 18) = gcd(48 mod 18, 18)
            = gcd(12, 18)
            = gcd(12, 18 mod 12)
            = gcd(12, 6)
            = gcd(12 mod 6, 6)
            = gcd(0, 6)
            = 6
```

这里也可以不用考虑两个数大小的问题，每一步都是左数除以右数得余数，然后扔掉左数，将右数变为左数，余数变为右数即可。计算机实现按此方法代码最少。

如：

```plaintext
gcd(18, 48) = gcd(48, 18 mod 48)
            = gcd(48, 18) // 可见，这一步相当于交换了左右数
            = gcd(18, 48 mod 18)
            = gcd(18, 12)
            = gcd(12, 18 mod 12)
            = gcd(12, 6)
            = gcd(6, 12 mod 6)
            = gcd(6, 0)
            = 6
```

以上算法的终止条件是两数相等，或其中一数为0。

这个方法容易通过编程实现，特别是改进后使用除法求余的方式是程序解答的通行方法。

这里的两个示例来源于[Createst Common Divisor (Wikipedia)](https://en.wikipedia.org/wiki/Greatest_common_divisor)

## 程序解答

输入：两个正整数

输出：两数的最大公约数

### 代码实现

### Java

```java
    public static long calculateGcd(long a, long b) {
        if (a < 0 || b < 0) {
            System.out.println("Only accept numbers greater than 0.");
        }

        if ( a == b) {
            return a;
        }

        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        // if a is smaller than b, switch them.
        if (a < b) {
            long t = a;
            a = b;
            b = t;
        }

        long r = a % b;

        return calculateGcd(b, r);
    }
```

以上的代码是可以运行的，但其实我们依据4.1.4的末尾提到的解法

* 比较 a == b 和 a == 0 是不必要的，可以删除
* 交换操作是不必要的，可以删除交换(a, b)的代码

可简化改进为：

```java
    public static long calculateGcd(long a, long b) {
        if (a < 0 || b < 0) {
            System.out.println("Only accept numbers greater than 0.");
        }

        if (b == 0) {
            return a;
        }

        long r = a % b;

        return calculateGcd(b, r);
    }

```

完整的代码实现参[GreatestCommonDivisor.java](GreatestCommonDivisor.java)，运行记录

```plaintext
$ javac GreatestCommonDivisor.java
$ java GreatestCommonDivisor
gcd(18, 48) = 6
```

### C

```c
long calculateGcd(long a, long b)
{
    if (a < 0 || b < 0)
    {
        printf("Only accept numbers greater than 0.");
        exit(0);
    }

    if (b == 0)
    {
        return a;
    }

    long r = a % b;

    return calculateGcd(b, r);
}
```

完整的代码实现参[gcd.c](gcd.c)，其中包含了一个非递归版本，但可读性不佳，运行记录

```plaintext
$ gcc gcd.c -o gcd
$ ./gcd.exe
gcd(18, 48) = 6
gcd(18, 48) = 6

```

(Windows平台编译出的可执行文件，带有后缀名.exe，但在Linux上是没有后缀名的。)

### C++

TODO

### JavaScript

TODO

### TypeScript

TODO

### Python

TODO

### Rust

TODO

### Go

TODO

### Hashkell

TODO

### Scala

TODO

---

后记，因为阅读[《算法·第4版》](https://book.douban.com/subject/19952400/)(Robert & Kevin)，书中第一章第一页提到最大公约数算法，故做了一点小小的研究，记录于此。

【参考】

* [约数 和 因数 ——全中国都混乱的数学基本概念](http://blog.sina.com.cn/s/blog_6386b85d0100iar0.html)这篇文章中提到了约数概念在国内没有统一的定义，这点针对具体问题时，一定要明确。

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