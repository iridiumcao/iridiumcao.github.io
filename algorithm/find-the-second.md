# 找出第二大的整数

问题来源于 pongba 邮件列表的一个[帖子](https://groups.google.com/g/pongba/c/k6OPRN5RqHs)。

问题描述：如何在 O(n) 时间内找到一个整数数组中的第二大元素？

遍历一次找到第一，是比较容易的事情，第二呢？那么在遍历时同时保存第一和第二就成。那个帖子中 fumin.shen 和 legendsland 的回答都很有启发性，我的代码正是根据 fumin.shen 的提示写出来的，如下：

```java
public class HelloWorld {
    public static void main(String[] args) {
        int[] a = { 3, 4, 5, 6, 7, 8, 8, 9, 9, 2, -1 };
        System.out.println(HelloWorld.getSecond(a));
    }
    public static int getSecond(int... a) {
        int first = a[0];
        int second = a[1];
        if (a[0] < a[1]) {
            first = a[1];
            second = a[0];
        }
        for (int i = 2; i < a.length - 1; i++) {
            if (a[i] > first) {
                second = first;
                first = a[i];
            } else if (a[i] < first && a[i] > second) {
                second = a[i];
            }
        }
        return second;
    }
}
```

---

本文从[旧站](https://sites.google.com/site/iridiumsite/it/algorithms/find-the-second)搬迁而来。
