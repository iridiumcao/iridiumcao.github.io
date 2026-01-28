# 探讨布尔运算的规律(Explore the Operation Properties of Boolean Algebra)

[返回目录](index.md)

本文探讨的布尔运算仅限`AND`与，`OR`或，`XOR`异或三种。本文探讨的运算规律仅限交换律，结合律，分配律三种。其中分配律会依据不同的运算组合展开。

## 1. 定义

1. `AND`与。`a AND b`，当且仅当 `a = true` 并且 `b = true` 时，`a AND b = true`。
2. `OR`或。`a OR b`，如果`a`或`b`至少有一个为`true`，表达式`a OR b`就为`true`，否则为`false`.
3. `XOR`异或。`a XOR b`，如果`a`和`b`同时为`true`则表达式`a XOR b`为`true`，否则为`false`.

以上定义对应的真值表如下：

| a | b | a AND b | a OR b | a XOR b |
|---|---|---------|--------|---------|
| 0 | 0 | 0       | 0      | 0       |
| 0 | 1 | 0       | 1      | 1       |
| 1 | 0 | 0       | 1      | 1       |
| 1 | 1 | 1       | 1      | 0       |

(表中用`1`表示`true`，用`0`表示`false`)

## 2. 运算律

### 2.1 交换律

根据前面的定义，交换律显然对三种运算都满足。

| -   | 交换律  |
| --- | ------ |
| AND | 满足    |
| OR  | 满足    |
| XOR | 满足    |

### 2.2 结合律

#### 2.2.1 考察`AND`与运算的结合律

比较`a AND b AND c`是否始终与`a AND (b AND c)`相等，如果是，则满足结合律，否则不满足。

观察真值表

| -               | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
| --------------- | - | - | - | - | - | - | - | - |
| a               | 0 | 0 | 0 | 0 | 1 | 1 | 1 | 1 |
| b               | 0 | 0 | 1 | 1 | 0 | 0 | 1 | 1 |
| c               | 0 | 1 | 0 | 1 | 0 | 1 | 0 | 1 |
| a AND b AND c   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 |
| a AND (b AND c) | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 |

上表列出了`a b c`的所有可能值的所有组合，最后两行的值，在同列始终相等，所以`AND`满足结合律。

这里不需要再验证`a AND b AND c`和`a AND c AND b`的关系，因为它们是等价的，证明如下：

```text
  a AND b AND c
= a AND (b AND c) // 结合律
= a AND (c AND b) // 交换律
= a AND c AND b // 结合律
```

类似可以证明其他所有组合：

```text
a AND b AND c = c AND b AND a
a AND b AND c = b AND a AND c
......
```

也就是一旦`AND`满足结合律和交换律，`a b c`这三个元的运算位置可以任意交换而不影响表达式的值。

| -   | 交换律  | 结合律 |
| --- | ------ | ----- |
| AND | 满足    | 满足  |
| OR  | 满足    | -     |
| XOR | 满足    | -     |

### 2.2.2 考察所有运算的结合律

类似再考察`OR`或`XOR`可得到如下真值表：

|     | Expression      |   1   |   2   |   3   |   4   |   5   |   6   |   7   |   8  |
|-----|-----------------|:-----:|:-----:|:-----:|:-----:|:-----:|:-----:|:-----:|:----:|
|     | a               | FALSE | FALSE | FALSE | FALSE |  TRUE |  TRUE |  TRUE | TRUE |
|     | b               | FALSE | FALSE |  TRUE |  TRUE | FALSE | FALSE |  TRUE | TRUE |
|     | c               | FALSE |  TRUE | FALSE |  TRUE | FALSE |  TRUE | FALSE | TRUE |
| AND | a AND b AND c   | FALSE | FALSE | FALSE | FALSE | FALSE | FALSE | FALSE | TRUE |
|     | a AND (b AND c) | FALSE | FALSE | FALSE | FALSE | FALSE | FALSE | FALSE | TRUE |
| OR  | a OR b OR c     | FALSE |  TRUE |  TRUE |  TRUE |  TRUE |  TRUE |  TRUE | TRUE |
|     | a OR (b OR c)   | FALSE | FALSE |  TRUE |  TRUE |  TRUE |  TRUE |  TRUE | TRUE |
| XOR | a XOR b XOR c   | FALSE |  TRUE |  TRUE | FALSE |  TRUE | FALSE | FALSE | TRUE |
|     | a XOR (b XOR c) | FALSE |  TRUE |  TRUE | FALSE |  TRUE | FALSE | FALSE | TRUE |

![结合律](images/bool_associative_property.png)

综上，`AND OR XOR`全部满足交换律和结合律。

| -   | 交换律  | 结合律 |
| --- | ------ | ----- |
| AND | 满足    | 满足  |
| OR  | 满足    | 满足  |
| XOR | 满足    | 满足  |

## 2.3 分配律

类似乘法对加法的分配律`a(b+c) = ab+bc`, 分配律涉及两种运算之间的关系。本文讨论的运算有`AND OR XOR`三种，两两之间的组合多达6种。

1. AND, OR
1. AND, XOR
1. OR, AND
1. OR, XOR
1. XOR, AND
1. XOR, OR

### 2.3.1 `AND`对`OR`的分配律

如果`a AND (b OR c) = (a AND b) OR (a AND c)`恒成立，则`AND`对`OR`的分配律成立。

观察真值表

| -                      | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
| ---------------------- | - | - | - | - | - | - | - | - |
| a                      | 0 | 0 | 0 | 0 | 1 | 1 | 1 | 1 |
| b                      | 0 | 0 | 1 | 1 | 0 | 0 | 1 | 1 |
| c                      | 0 | 1 | 0 | 1 | 0 | 1 | 0 | 1 |
| a AND (b OR c)         | 0 | 0 | 0 | 0 | 0 | 1 | 1 | 1 |
| (a AND b) OR (a AND c) | 0 | 0 | 0 | 0 | 0 | 1 | 1 | 1 |

上表列出了`a b c`的所有可能值的所有组合，最后两行的值，在同列始终相等，所以`AND`对`OR`的分配律成立。

|          | 分配律  | 表达式                                   |
|----------|--------|-----------------------------------------|
| AND, OR  | 成立    | a AND (b OR c) = (a AND b) OR (b AND c) |


### 2.3.2 考察所有运算两两组合的分配律

参上述列表，可以计算其他几种情况

|           | Expression              | 1     | 2     | 3     | 4     | 5     | 6     | 7     | 8     |
|-----------|-------------------------|-------|-------|-------|-------|-------|-------|-------|-------|
|           | a                       | FALSE | FALSE | FALSE | FALSE | TRUE  | TRUE  | TRUE  | TRUE  |
|           | b                       | FALSE | FALSE | TRUE  | TRUE  | FALSE | FALSE | TRUE  | TRUE  |
|           | c                       | FALSE | TRUE  | FALSE | TRUE  | FALSE | TRUE  | FALSE | TRUE  |
| AND → OR  | a AND (b OR c)          | FALSE | FALSE | FALSE | FALSE | FALSE | TRUE  | TRUE  | TRUE  |
|           | (a AND b) OR (a AND c)  | FALSE | FALSE | FALSE | FALSE | FALSE | TRUE  | TRUE  | TRUE  |
| AND → XOR | a AND (b XOR c)         | FALSE | FALSE | FALSE | FALSE | FALSE | TRUE  | TRUE  | FALSE |
|           | (a AND b) XOR (a AND c) | FALSE | FALSE | FALSE | FALSE | FALSE | TRUE  | TRUE  | FALSE |
| OR → AND  | a OR (b AND c)          | FALSE | FALSE | FALSE | TRUE  | TRUE  | TRUE  | TRUE  | TRUE  |
|           | (a OR b) AND (a OR c)   | FALSE | FALSE | FALSE | TRUE  | TRUE  | TRUE  | TRUE  | TRUE  |
| OR → XOR  | a OR (b XOR c)          | FALSE | TRUE  | TRUE  | FALSE | TRUE  | TRUE  | TRUE  | TRUE  |
|           | (a OR b) XOR (a OR c)   | FALSE | TRUE  | TRUE  | FALSE | FALSE | FALSE | FALSE | FALSE |
| XOR → AND | a XOR (b AND c)         | FALSE | FALSE | FALSE | TRUE  | TRUE  | TRUE  | TRUE  | FALSE |
|           | (a XOR b) AND (a XOR c) | FALSE | FALSE | FALSE | TRUE  | TRUE  | FALSE | FALSE | FALSE |
| XOR → OR  | a XOR (b OR c)          | FALSE | TRUE  | TRUE  | TRUE  | TRUE  | FALSE | FALSE | FALSE |
|           | (a XOR b) OR (a XOR c)  | FALSE | TRUE  | TRUE  | TRUE  | TRUE  | TRUE  | TRUE  | FALSE |

![bool table](images/bool_distributive_property.png)

由此可见，满足分配律的运算有如下三种：

|          | 分配律  | 表达式                                     |
|----------|-------- |------------------------------------------ |
| AND, OR  | 成立    | a AND (b OR c) = (a AND b) OR (b AND c)   |
| AND, XOR | 成立    | a AND (b XOR c) = (a AND b) XOR (b AND c) |
| OR, AND  | 成立    | a OR (b AND c) = (a OR b) AND (b OR c)    |
| OR, XOR  | 不成立  |                                           |
| XOR, AND | 不成立  |                                           |
| XOR, OR  | 不成立  |                                           |

## 结论

`AND`与，`OR`或，`XOR`异或三种运算都满足交换律和结合律。但这几种运算的两两组合，只有一半满足分配律。

---

资源链接：

1. [【腾讯文档】布尔运算律真值表](https://docs.qq.com/sheet/DYll0SnZ6aERjRlJQ?tab=BB08J2)
2. [【谷歌文档】布尔运算律真值表](https://docs.google.com/spreadsheets/d/11gWgjyvoM5-oqcboEzo-oHgfmd5Pbvk38Njt0JqtX8k/edit?usp=sharing)

本文曾经发布到[CSDN blog](https://blog.csdn.net/caoi/article/details/127210876).

![history on CSDN](images/history2023-06-16-172925.png)

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