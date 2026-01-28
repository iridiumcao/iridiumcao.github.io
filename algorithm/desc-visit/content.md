# 倒着遍历数组

[返回目录](../index.md)

按：这是从《编程之美》上看到的一个题目。

已知一个数组，用它每一项除以第一项，得到一个新数组。求得到新数组的函数。

这个问题可以如下描述

* 输入：某整数数组，假定为 A
* 输出：整数数组，假定为 B
* 要求满足：B[i] == A[i]/A[0]

最直接的解法，定义一个等长的新数组，循环赋值给每个元素即可。如下：

```java
    public static int[] genNewArray1(int[] a) {
        int[] b = new int[a.length];
        if (a[0] != 0) {
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i] / a[0];
            }
        }
        return b;
    }
```

这个解法比较直接，但不够炫技，因此有了下边的解法：

```java
    public static void genNewArrray(int[] a) {
        if (a[0] != 0) {
            for (int i = a.length - 1; i >= 0; i--) {
                a[i] /= a[0];
            }
        }
    }
```

这个方法和上个方法相比，没有返回值，也没有定义新的数组，而且循环是倒着来的。能这么做的理由如下：

根据 Java 语言的特征，方法入口传入的仅仅是 a 的引用。虽然 Java 的参数是值传递的，但此时的值，就是引用。—— 对于非元数据类型，可以认为这是变相的“引用传递”。

如果不倒着来，那么 a[0] 赋值为1后，后边的元素除以1，结果就会得到一个{1, 1, ..., 1}这样的数组。

详细代码在[这里](HelloAlgrithm001.java).

---

本文是从Google Sites上的[旧站](https://sites.google.com/site/iridiumsite/it/algorithms/desc-visit)搬运过来的。

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