# 谁是小偷？

[返回目录](../index.md)

【题目】

- a 说：我不是小偷；
- b 说：c 是小偷
- c 说： 小偷肯定是 d
- d 说： c 冤枉人

已知四人中有三个人说了真话，一人说了假话。问到底谁是小偷？

【分析】

如果只有一个小偷，可以沿用上文[《哪个赛车最好？》](../bestcar/content.md)的表格分析，此处不表。如果不确定小偷的个数，这这个表的维度就大为增加：5维！a, b, c, d 所说的话占一维，其余四维被a, b, c, d 自身占有。

以下是 Java 代码分析：

如果只有一个小偷，可用下面的简单解法，Java 代码如下：

```java
for (int i = 1; i <= 4; i++) {
    int count = 0;
    count += (i != 1) ? 1 : 0;
    count += (i == 3) ? 1 : 0;
    count += (i == 4) ? 1 : 0;
    count += (i != 4) ? 1 : 0;

    if (count == 3) {
        System.out.println("小偷的编号: " + i);
    }
}
```

完整的可运行代码，参[这里](Chief.java)。

如果不确定小偷的个数，可用下面比较复杂但直观的解法：

```java
int[] a = { 0, 1 };// 0表示不是小偷，1表示是小偷
int[] b = { 0, 1 };
int[] c = { 0, 1 };
int[] d = { 0, 1 };
for (int i : a) {
    for (int j : b) {
        for (int k : c) {
            for (int l : d) {
                int count = 0;
                count += (i != 1) ? 1 : 0;
                count += (k == 1) ? 1 : 0;
                count += (l == 1) ? 1 : 0;
                count += (l != 1) ? 1 : 0;
                if (count == 3) {
                    System.out.println("A " + (i == 1 ? "" : "不") + "是小偷");
                    System.out.println("B " + (j == 1 ? "" : "不") + "是小偷");
                    System.out.println("C " + (k == 1 ? "" : "不") + "是小偷");
                    System.out.println("D " + (l == 1 ? "" : "不") + "是小偷");
                    System.out.println("----");
                }
            }
        }
    }
}
```

完整的可运行代码，参[这里](Chief2.java)。

这里就得到四组解：

```plaintext
A 不是小偷
B 不是小偷
C 是小偷
D 不是小偷
----
A 不是小偷
B 不是小偷
C 是小偷
D 是小偷
----
A 不是小偷
B 是小偷
C 是小偷
D 不是小偷
----
A 不是小偷
B 是小偷
C 是小偷
D 是小偷
----
```

---

本文是从Google Sites的[旧站](https://sites.google.com/site/iridiumsite/)迁移过来的。

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