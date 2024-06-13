# 哪个赛车最好

[返回目录](../index.md)

按：这个问题来源于网络，算是个经典问题了。

【题目】

四名专家对四款赛车进行了评论：

*  A说：2号赛车是最好的。
*  B说：4号赛车是最好的。
*  C说：3号赛车不是最好的。
*  D说：B说错了。

事实上只有一款赛车最佳，且只有一名专家的评论是正确的。

请找出最佳赛车。

【一般分析】

以上的四句评论可以简化为：

```plaintext
A = 2
B = 4
C = !3
D = !B = !4
```

上面的数字表示该编号的赛车为最好的意思，没有数量上的含义。

由此可列真值表如下：

|                 | if 1 best | if 2 best | if 3 best | if 4 best |
|-----------------|-----------|-----------|-----------|-----------|
| A (best: 2)     | F         | T         | F         | F         |
| B (best: 4)     | F         | F         | F         | T         |
| C (best: not 3) | T         | T         | F         | T         |
| D (best: not 4) | T         | T         | T         | F         |
| count(T)        | 2         | 3         | 1         | 2         |

由上表，count(T) == 1时，为合乎条件的解：3号车最好，D说的对的。

【程序表达】

以上的分析过程如何由程序语言表达？

从上面的表中，可以看出能按这么个步骤来实现程序：

循环每个跑车为最好的情况

在每个循环里计算count(T)的值，如果count(T)==1，即得解

（上面似乎应该用程序顺序图来表示，可惜忘了怎么画）

每个车都有两个可能：最好，和不是最好。可以通过多重循环来完成各车不同情况的组合，然后判断每个组合是否符合条件，Java 代码如下：

```java
int[] first = { 0, 1 };// 1号车, 0表示不是最好，1表示为最好
int[] second = { 0, 1 };// 2号车,
int[] third = { 0, 1 };// 3号车，
int[] forth = { 0, 1 };// 4号车
int count = 0; // 所有人说对话的总数
for (int i : first) {
    for (int j : second) {
        for (int k : third) {
            for (int m : forth) {
                if (i + j + k + m == 1) {//只有一个车是最好的
                    count = 0;
                    count += ((j == 1) ? 1 : 0);// 2号赛车是最好的
                    count += ((m == 1) ? 1 : 0);// 4号赛车是最好的
                    count += ((k != 1) ? 1 : 0);// 3号赛车不是最好的
                    count += ((m != 1) ? 1 : 0);// 4号赛车不是最好的
                    if (count == 1) {//只有一个人说的对的
                        System.out.println("1号车：" + ((i == 1) ? "最好" : "不是最好"));
                        System.out.println("2号车：" + ((j == 1) ? "最好" : "不是最好"));
                        System.out.println("3号车：" + ((k == 1) ? "最好" : "不是最好"));
                        System.out.println("4号车：" + ((m == 1) ? "最好" : "不是最好"));
                    }
                }
            }
        }
    }
}
```

注意：多重循环中，不要使用 `contine` 和 `break`，更不要和标签结合使用，我之前在第一重循环外加了个标签，从最里层的循环体中跳出，出现莫名其妙的结果，这里不多表。完整可运行的代码在[这里](BestCar.java)。

以上的代码很直观，但多重循环看得真是愁杀人，其实考虑到只有一个车是最好的，将车的编号用来循环一次，代入到各人说的话中可以得到如下简化的 Java 代码：

```java
for (int i = 1; i <= 4; i++) {
    int count = 0; // 所有人说对话的总数
    count += ((i == 2) ? 1 : 0);// 2号赛车是最好的
    count += ((i == 4) ? 1 : 0);// 4号赛车是最好的
    count += ((i != 3) ? 1 : 0);// 3号赛车不是最好的
    count += ((i != 4) ? 1 : 0);// 4号赛车不是最好的
    if (count == 1) {// 只有一个人说的对的
        System.out.println(i + "号车是最好的");
        if (i == 2) {
            System.out.println("A说的对");
        }
        if (i == 4) {
            System.out.println("B说的对");
        }
        if (i != 3) {
            System.out.println("C说的对");
        }
        if (i != 4) {
            System.out.println("D说的对");
        }
    }
}
```

完整的可执行代码在[这里](BestCar2.java)。

如果用 C 语言，利用它用整型1表示布尔值 `true` 的特性，则可以得到更为简单的代码（参[这里(by Kenvisa, zhidao.baidu.com)](https://zhidao.baidu.com/question/75477496.html)）：

```c
int m; // 赛车的编号
for (m = 1; m < 5; m++)
{
    if (!(m - 2) + !(m - 4) + !!(m - 3) + !!(m - 4) == 1)
    {
        printf("第%d赛车是最好的", m);
    }
}
```

完整的可执行代码在[这里](best_car.c)。

或

```c
    int m; // 赛车的编号
    for (m = 1; m < 5; m++)
    {
        if (((m == 2) + (m == 4) + (m != 3) + (m != 4)) == 1)
        {
            printf("第%d赛车是最好的", m);
        }
    }
```

完整的可执行代码在[这里](best_car2.c)。

---

本文是从Google Sites的[旧站](https://sites.google.com/site/iridiumsite/it/algorithms/bestcar)迁移过来的。