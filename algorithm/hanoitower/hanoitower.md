# 河内塔 Hanoi Tower

[返回目录](../index.md)

问题描述。有三根杆子A，B，C。A杆上有N个(N>1)穿孔圆盘，盘的尺寸由下到上依次变小。要求按下列规则将所有圆盘移至C杆：

1. 每次只能移动一个圆盘；
1. 大盘不能叠在小盘上面。
1. 提示：可将圆盘临时置于B杆，也可将从A杆移出的圆盘重新移回A杆，但都必须尊循上述两条规则。

问：如何移？最少要移动多少次？(TODO)

这个问题源于法国数学家[爱德华·卢卡斯](https://zh.wikipedia.org/wiki/%E7%88%B1%E5%BE%B7%E5%8D%8E%C2%B7%E5%8D%A2%E5%8D%A1%E6%96%AF)杜撰的一个故事：傳說印度某間寺院有三根柱子，上串64个金盤。寺院裡的僧侶依照一個古老的預言，以上述規則移動這些盤子；預言說當這些盤子移動完毕，世界就會滅亡。（注：这个故事本身有点扯，因为河内在越南而不是印度。）

![Tower of Hanoi](tower-of-hanoi.png)

（图片来自[Program for Tower of Hanoi Algorithm](https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/))

## 递归版本

递归方式的 Java 控制台版本：

```java
    public static void hanoi(int i, String a, String b, String c) { //以 b 为中转, 将 i 个盘子从 a 移动到 c
        if (i == 1) {
            move(a, c); // 直接将 a 移动到 c
        } if (i > 1) {
            hanoi(i-1, a, c, b); // 以 c 为中转, 将 i-1 个盘子从 a 移动到 b
            move(a, c); // 直接将 a 移动到 c, 此时移动的就是最底下的那个盘子
            hanoi(i-1, b, a, c); // 以 a 为中转, 将 i-1 个盘子从 b 移动到 c
        }
    }
    public static void move(String src, String dst) {
        System.out.println(src + " -> " + dst);
    }
```

完整的代码参考[这里](HanoiTower.java).

Python3 可以如此写：

```python
# hanoi tower
def hanoi(n, a, b, c): # 以 b 为中转, 将 i 个盘子从 a 移动到 c
  if n == 1:
    print(a, '->', c) # 直接将 a 移动到 c
    return

  if n > 1:
    hanoi(n - 1, a, c, b) # 以 c 为中转, 将 i-1 个盘子从 a 移动到 b
    print(a, '->', c) # 直接将 a 移动到 c, 此时移动的就是最底下的那个盘子
    hanoi(n -1, b, a, c) # 以 a 为中转, 将 i-1 个盘子从 b 移动到 c

# sample
hanoi(3, 'A', 'B', 'C')
```

完整的代码参考[这里](HanoiTower.py).

## 非递归版本

TODO

河內塔是數據結構 stack 的一個經典應用。

参考：

* 维基百科：[汉诺塔](http://zh.wikipedia.org/zh/%E6%B1%89%E8%AF%BA%E5%A1%94), [Tower of Hanoi](https://en.wikipedia.org/wiki/Tower_of_Hanoi)
* [Program for Tower of Hanoi Algorithm](https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/)

---

本文从[旧站](https://sites.google.com/site/iridiumsite/it/algorithms/hanoi-tower)搬迁而来。

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