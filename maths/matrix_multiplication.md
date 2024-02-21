# 矩阵乘法的理解

[返回目录](index.md)

_2024.02.13 农历正月初四_

---

- [矩阵乘法的理解](#矩阵乘法的理解)
  - [1. 数乘](#1-数乘)
  - [2. 向量的点积](#2-向量的点积)
  - [3. 行向量与矩阵相乘](#3-行向量与矩阵相乘)
  - [4. 矩阵相乘](#4-矩阵相乘)
  - [5. 行变换](#5-行变换)
    - [5.1 交换两行](#51-交换两行)
    - [5.2 将某两行相加](#52-将某两行相加)
    - [5.3 对某一行乘以一个数](#53-对某一行乘以一个数)
  - [6. 矩阵乘法另外的视角：「点积」](#6-矩阵乘法另外的视角点积)
  - [7. 矩阵乘法另外的视角：「列」](#7-矩阵乘法另外的视角列)
    - [7.1 列变换](#71-列变换)
      - [7.1.1 交换两列](#711-交换两列)
      - [7.1.2 将某两行相加](#712-将某两行相加)
      - [7.1.3 对某一列乘以一个数](#713-对某一列乘以一个数)
  - [8. 总结](#8-总结)
  - [9. 后记](#9-后记)

---

矩阵是表达多维数组的重要数学工具，它的运算，加法和数乘，甚至关联的向量点积都很直观，但矩阵的乘法对于新手来说，理解起来难度比较大。记忆定义和公式或许很容易，但明了它们的来历，却需要花一番功夫去思考去演算。本文从三个不同的视角去理解矩阵乘法。

## 1. 数乘

先举一个简单的例子。已知某 $3 \times 2$矩阵为例子

$$
\mathcal{A} =
\begin{bmatrix}
    a_{11} & a_{12}\\
    a_{21} & a_{22}\\
    a_{31} & a_{32}
\end{bmatrix}
$$

假设有一个实数 $k$ 和 $\mathcal{A}$ 相乘：

$$
k\mathcal{A} = 
k
\begin{bmatrix}
    a_{11} & a_{12}\\
    a_{21} & a_{22}\\
    a_{31} & a_{32}
\end{bmatrix} = 
\begin{bmatrix}
    ka_{11} & ka_{12}\\
    ka_{21} & ka_{22}\\
    ka_{31} & ka_{32}
\end{bmatrix}
$$

这其实是一个定义，也就是规定如此。

推广成一般矩阵，数乘就是：一个实数乘以一个矩阵，等于矩阵的每一项都乘以这个数，即：

$$
k
\begin{bmatrix}
    a_{11} & a_{12} & \cdots & a_{1n}\\
    a_{21} & a_{22} & \cdots & a_{2n}\\
    \vdots & \vdots & \ddots & \vdots \\
    a_{m1} & a_{m2} & \cdots & a_{mn}
\end{bmatrix} =
\begin{bmatrix}
    ka_{11} & ka_{12} & k\cdots & ka_{1n}\\
    ka_{21} & ka_{22} & k\cdots & ka_{2n}\\
    \vdots & \vdots & \ddots & \vdots \\
    ka_{m1} & ka_{m2} & k\cdots & ka_{mn}
\end{bmatrix}
$$

## 2. 向量的点积

两个维度相同的向量的点积等于它们对应元素的乘积之和。

令 $\mathcal{A} = [a_{1}, a_{2}, ..., a_{n}]$, $\mathcal{B} = [b_{1}, b_{2}, ..., b_{n}]$

则它们的点积定义为

$$
\begin{equation}
    \begin{split}
        \mathcal{A}\cdot\mathcal{B} &= a_{1}b_{1} + a_{2}b_{2} + \cdots + a_{n}b_{n} \nonumber \\
                               &= \sum_{i}^{n} a_{i}b_{i}
    \end{split}
\end{equation}
$$

其中 $\mathcal{A}$ 和 $\mathcal{B}$ 也可以同为列向量。

## 3. 行向量与矩阵相乘

行向量 $\mathcal{k}$ 与矩阵 $\mathcal{A}$ 相乘，就是把 $\mathcal{A}$ 的行向量按 $\mathcal{k}$ 提供的系数做线性组合。

还是以矩阵 $\mathcal{A}$ 为例，

$$
\mathcal{A} = 
\begin{bmatrix}
    a_{11} & a_{12}\\
    a_{21} & a_{22}\\
    a_{31} & a_{32}
\end{bmatrix}
$$

把 $\mathcal{A}$ 的三个行向量拆出来：

$$a_{1\ast} = \begin{bmatrix} a_{11} & a_{12} \end{bmatrix}$$

$$a_{2\ast} = \begin{bmatrix} a_{21} & a_{22} \end{bmatrix}$$

$$a_{3\ast} = \begin{bmatrix} a_{31} & a_{32} \end{bmatrix}$$

用实数 $k_{i}$ 作系数，对它们做线性组合：

$$
\begin{equation}
    \begin{split}  
        \mathcal{L} &= k_{1}a_{1*} + k_{2}a_{2*} + k_{3}a_{3*} \nonumber \\
                    &= k_{1}\begin{bmatrix} a_{11} & a_{12} \end{bmatrix} 
                        + k_{2}\begin{bmatrix} a_{21} & a_{22} \end{bmatrix} 
                        + k_{3}\begin{bmatrix} a_{31} & a_{32} \end{bmatrix} \\
                    &= \begin{bmatrix}
                          k_{1}a_{11} + k_{2}a_{21} + k_{3}a_{31} 
                        & k_{1}a_{12} + k_{2}a_{22} + k_{3}a_{32}
                        \end{bmatrix} \\
                    &= \begin{bmatrix}
                          \sum_{i=1}^3 k_{i}a_{i1}
                        & \sum_{i=1}^3 k_{i}a_{i2}
                        \end{bmatrix}
    \end{split}
\end{equation}
$$

如此，就得到了一个新的行向量，它的维度和原矩阵的行向量的维度是一样的，等于矩阵的列数。

如果把系数 $k_{i}$ 用行向量 $\begin{bmatrix} k_{1} & k_{2} & k_{3} \end{bmatrix}$ 表示，对 $\mathcal{A}$ 的行向量做线性组合还可以这样写：

$$
\begin{equation}
    \begin{split}  
        \mathcal{L} &= \begin{bmatrix}
                            k_{1} & k_{2} & k_{3}
                        \end{bmatrix}
                        \begin{bmatrix}
                            a_{11} & a_{12} \\
                            a_{21} & a_{22}\\
                            a_{31} & a_{32}
                       \end{bmatrix} \nonumber
    \end{split}
\end{equation}
$$

这里其实定义了行向量与矩阵相乘的法则：行向量与矩阵相乘，等于按行向量的值对矩阵的行向量做线性组合，最后得到一个新的行向量，即：

$$
\begin{equation}
    \begin{split}  
        \begin{bmatrix}
            k_{1} & k_{2} & k_{3}
        \end{bmatrix}
        \begin{bmatrix}
            a_{11} & a_{12} \\
            a_{21} & a_{22}\\
            a_{31} & a_{32}
        \end{bmatrix} \nonumber 
        &= k_{1}\begin{bmatrix} a_{11} & a_{12} \end{bmatrix} 
            + k_{2}\begin{bmatrix} a_{21} & a_{22} \end{bmatrix} 
            + k_{3}\begin{bmatrix} a_{31} & a_{32} \end{bmatrix} \\
        &= \begin{bmatrix}
                k_{1}a_{11} + k_{2}a_{21} + k_{3}a_{31} 
            & k_{1}a_{12} + k_{2}a_{22} + k_{3}a_{32}
            \end{bmatrix}
    \end{split}
\end{equation}
$$

推广到更一般的情况，$\begin{bmatrix}k_{1} & k_{2} & \cdots & k_{m}\end{bmatrix}$ 乘以 $\mathcal{A}$ 相当于用实数 $k_{i}$ 作系数，对矩阵 $\mathcal{A}$ 的行做线性组合，计算过程如下：

$$
\begin{equation}
    \begin{aligned}  
        \begin{bmatrix}
                            k_{1} & k_{2} & \cdots & k_{m}
                        \end{bmatrix}
                        \begin{bmatrix}
                            a_{11} & a_{12} & \cdots & a_{1n} \\
                            a_{21} & a_{22} & \cdots & a_{2n}\\
                            \vdots & \vdots & \ddots & \vdots \\
                            a_{m1} & a_{m2} & \cdots & a_{mn}
                       \end{bmatrix} 
                    &= k_{1}\begin{bmatrix} a_{11} & a_{12} & \cdots & a_{1n} \end{bmatrix} \\
                      &+ k_{2}\begin{bmatrix} a_{21} & a_{22} & \cdots & a_{2n} \end{bmatrix} \\
                      &+ \cdots \\
                      &+ k_{m}\begin{bmatrix} a_{m1} & a_{m2} & \cdots & a_{mn} \end{bmatrix} \nonumber \\
                    &= \begin{bmatrix}
                           \sum_{i=1}^m k_{i}a_{i1} &
                           \sum_{i=1}^m k_{i}a_{i2} &
                           \cdots &
                           \sum_{i=1}^m k_{i}a_{in}
                       \end{bmatrix}
    \end{aligned}
\end{equation}
$$

行向量 $\begin{bmatrix}k_{1} & k_{2} & \cdots & k_{m}\end{bmatrix}$ 可以视作组合规则，它的元素个数就是矩阵 $A$ 的行数 $m$. 这里也可以看出向量 $\mathcal{k}$ 的维度必须和矩阵 $\mathcal{A}$ 的行数匹配，它们必须相等，不然少了多了，都不能计算。

## 4. 矩阵相乘

因为行向量也是矩阵，所以前面提到的行向量和矩阵相乘，算是矩阵相乘的特殊形式：行数为1的矩阵和普通矩阵相乘。这里将推广到两个一般矩阵相乘，还是从行向量的线性组合的视角来解释。

假设有两个矩阵 $\mathcal{K}$, $\mathcal{A}$，不妨把 $\mathcal{K}$ 称为称为变换规则矩阵，简称规则矩阵，把 $\mathcal{A}$ 称为目标矩阵，$\mathcal{K}$ 的每一行都是一条变换规则。$\mathcal{K}$ 和 $\mathcal{A}$ 相乘，就是把 $\mathcal{A}$ 按 $\mathcal{K}$ 提供的规则变化为一个新的矩阵，假若这个新矩阵是 $\mathcal{B}$.

$\mathcal{K}\mathcal{A} = \mathcal{B}$ 即 $\mathcal{A} \xrightarrow{\mathcal{K}} \mathcal{B}$

还可以理解为函数 $\mathcal{K}$ 作用于变量 $\mathcal{A}$ 得到 $\mathcal{B}$，即 $\mathcal{K}(\mathcal{A}) = \mathcal{B}$

结合前面的「行向量和矩阵相乘」，当 $\mathcal{K}$ 只有一行时，$\mathcal{K}\mathcal{A}$ 是一个行向量，即 $\mathcal{A}$ 的行向量的一个线性组合。当 $\mathcal{A}$ 有两行时，就把 $\mathcal{A}$ 的行向量线性组合两次，两次的结果用矩阵记在一起。

假设

$$
\mathcal{K} = \begin{bmatrix}
                  k_{11} & k_{12} & k_{13} \\
                  k_{21} & k_{22} & k_{23}
              \end{bmatrix},
\mathcal{A} = 
\begin{bmatrix}
    a_{11} & a_{12}\\
    a_{21} & a_{22}\\
    a_{31} & a_{32}
\end{bmatrix}
$$

则 $\mathcal{K}\mathcal{A}$ 的值是 $\mathcal{K}$ 的第一行和第二行分别与 $\mathcal{A}$ 相乘后的结果组成的矩阵

$$
\begin{equation}
    \begin{split}
        \mathcal{k_{1*}}\mathcal{A} &= \begin{bmatrix}
                                    k_{11} & k_{12} & k_{13}
                                  \end{bmatrix}
                                  \begin{bmatrix}
                                      a_{11} & a_{12}\\
                                      a_{21} & a_{22}\\
                                      a_{31} & a_{32}
                                  \end{bmatrix} \nonumber \\
                                &= \begin{bmatrix}
                                        k_{11}a_{11} + k_{12}a_{21} + k_{13}a_{31}
                                       & k_{11}a_{12} + k_{12}a_{22} + k_{13}a_{32}
                                   \end{bmatrix}
    \end{split}
\end{equation}
$$

$$
\begin{equation}
    \begin{split}
        \mathcal{k_{2*}}\mathcal{A} &= \begin{bmatrix}
                                    k_{21} & k_{22} & k_{23}
                                  \end{bmatrix}
                                  \begin{bmatrix}
                                      a_{11} & a_{12}\\
                                      a_{21} & a_{22}\\
                                      a_{31} & a_{32}
                                  \end{bmatrix} \nonumber \\
                                &= \begin{bmatrix}
                                        k_{21}a_{11} + k_{22}a_{21} + k_{23}a_{31}
                                       & k_{21}a_{12} + k_{22}a_{22} + k_{23}a_{32}
                                   \end{bmatrix}
    \end{split}
\end{equation}
$$

所以

$$
\begin{equation}
    \begin{split}
        \mathcal{K}\mathcal{A} &= \begin{bmatrix}
                                    k_{11} & k_{12} & k_{13} \\
                                    k_{21} & k_{22} & k_{23}
                                  \end{bmatrix}
                                  \begin{bmatrix}
                                      a_{11} & a_{12}\\
                                      a_{21} & a_{22}\\
                                      a_{31} & a_{32}
                                  \end{bmatrix} \nonumber \\
                               &= \begin{bmatrix}
                                      k_{11}a_{11} + k_{12}a_{21} + k_{13}a_{31}
                                      & k_{11}a_{12} + k_{12}a_{22} + k_{13}a_{32} \\
                                      k_{21}a_{11} + k_{22}a_{21} + k_{23}a_{31}
                                      & k_{21}a_{12} + k_{22}a_{22} + k_{23}a_{32}
                                  \end{bmatrix}
    \end{split}
\end{equation}
$$

推广到更一般的情况，$\mathcal{K}\mathcal{A}$ 就是用 $\mathcal{K}$ 的每一个行向量去乘以矩阵 $\mathcal{A}$，然后把所得的结果组合成一个新的矩阵。

因为 $\mathcal{A}$ 是一个 $m \times n$ 矩阵，$\mathcal{K}$ 要和它相乘，$\mathcal{K}$ 每行的维度即 $\mathcal{K}$ 的列数必须和 $\mathcal{A}$ 的行数对应，即 $\mathcal{K}$ 有 $m$ 列。$\mathcal{K}$ 的行数任意，它取决于需要对 $\mathcal{A}$ 做多少次线性组合。因此不妨假设 $\mathcal{K}$ 是 $p \times m$ 矩阵，它们的乘积计算定义如下：

$$
\begin{equation}
    \begin{aligned}  
        \mathcal{K}\mathcal{A} &= \begin{bmatrix}
                            k_{11} & k_{12} & \cdots & k_{1m} \\
                            k_{21} & k_{22} & \cdots & k_{2m} \\
                            \vdots & \vdots & \ddots & \vdots \\
                            k_{p1} & k_{p2} & \cdots & k_{pm}
                        \end{bmatrix}
                        \begin{bmatrix}
                            a_{11} & a_{12} & \cdots & a_{1n} \\
                            a_{21} & a_{22} & \cdots & a_{2n}\\
                            \vdots & \vdots & \ddots & \vdots \\
                            a_{m1} & a_{m2} & \cdots & a_{mn}
                       \end{bmatrix} \nonumber \\
                    &= \begin{bmatrix}
                           \sum_{i=1}^m k_{1i}a_{i1} & \sum_{i=1}^m k_{1i}a_{i2} & \cdots & \sum_{i=1}^m k_{1i}a_{in} \\
                           \sum_{i=1}^m k_{2i}a_{i1} & \sum_{i=1}^m k_{2i}a_{i2} & \cdots & \sum_{i=1}^m k_{2i}a_{in} \\
                           \vdots & \vdots & \ddots & \vdots \\
                           \sum_{i=1}^m k_{pi}a_{i1} & \sum_{i=1}^m k_{pi}a_{i2} & \cdots & \sum_{i=1}^m k_{pi}a_{in} \\
                       \end{bmatrix}
    \end{aligned}
\end{equation}
$$

上面这个式子看着有点头大，只是为了说明，只要了解它的定义过程，也就很简单了。

## 5. 行变换

矩阵的行变换，都是由下面的几种基本变换组合而来的：交换两行，将某两行相加，对某一行乘以一个数。结合前面讲过的矩阵乘法，这些变换相当于用一个规则矩阵去乘目标矩阵。

还是以矩阵 $\mathcal{A}$ 为例：

$$
\mathcal{A} = 
\begin{bmatrix}
    a_{11} & a_{12}\\
    a_{21} & a_{22}\\
    a_{31} & a_{32}
\end{bmatrix}
$$

### 5.1 交换两行

交换第一和第二行

$$
\mathcal{K}\mathcal{A} = 
    \begin{bmatrix}
        0 & 1 & 0\\
        1 & 0 & 0\\
        0 & 0 & 1
    \end{bmatrix} \nonumber
    \begin{bmatrix}
        a_{11} & a_{12}\\
        a_{21} & a_{22}\\
        a_{31} & a_{32}
    \end{bmatrix}
    =
    \begin{bmatrix}
        a_{21} & a_{22}\\
        a_{11} & a_{12}\\
        a_{31} & a_{32}
    \end{bmatrix} \\
$$

可以直观地认为，$\mathcal{K}$ 就是把单位矩阵对应的行调整一下。

### 5.2 将某两行相加

将第三行和加到第一行，另两行不变。

$$
\mathcal{K}\mathcal{A} = 
    \begin{bmatrix}
        1 & 0 & 1\\
        0 & 1 & 0\\
        0 & 0 & 1
    \end{bmatrix} \nonumber
    \begin{bmatrix}
        a_{11} & a_{12}\\
        a_{21} & a_{22}\\
        a_{31} & a_{32}
    \end{bmatrix}
    =
    \begin{bmatrix}
        a_{11} + a_{31}& a_{12} + a_{32}\\
        a_{21} & a_{22}\\
        a_{31} & a_{32}
    \end{bmatrix} \\
$$

可以直观地认为，$\mathcal{K}$ 就是把单位矩阵第三行加到第一行。

### 5.3 对某一行乘以一个数

将第二行的元素变为原先的 $k$ 倍。

$$
\mathcal{K}\mathcal{A} = 
    \begin{bmatrix}
        1 & 0 & 0\\
        0 & k & 0\\
        0 & 0 & 1
    \end{bmatrix} \nonumber
    \begin{bmatrix}
        a_{11} & a_{12}\\
        a_{21} & a_{22}\\
        a_{31} & a_{32}
    \end{bmatrix}
    =
    \begin{bmatrix}
        a_{11} & a_{12}\\
        ka_{21} & ka_{22}\\
        a_{31} & a_{32}
    \end{bmatrix} \\
$$

可以直观地认为，$\mathcal{K}$ 就是把单位矩阵第二行乘以 $k$ 即可。


## 6. 矩阵乘法另外的视角：「点积」

前面直接定义了矩阵的数乘，向量的点乘，并从行变换出发定义了矩阵的乘法，一切都像是很自然。根据矩阵乘法的结果，还可以从点积的视角去定义矩阵乘法的结果。

从简单的实例出发，还是用前面示例用到过的矩阵。

假设

$$
\mathcal{K} = \begin{bmatrix}
                  k_{11} & k_{12} & k_{13} \\
                  k_{21} & k_{22} & k_{23}
              \end{bmatrix},
\mathcal{A} = 
\begin{bmatrix}
    a_{11} & a_{12}\\
    a_{21} & a_{22}\\
    a_{31} & a_{32}
\end{bmatrix}
$$

有

$$
\begin{equation}
    \begin{split}
        \mathcal{K}\mathcal{A} &= \begin{bmatrix}
                                    k_{11} & k_{12} & k_{13} \\
                                    k_{21} & k_{22} & k_{23}
                                  \end{bmatrix}
                                  \begin{bmatrix}
                                      a_{11} & a_{12}\\
                                      a_{21} & a_{22}\\
                                      a_{31} & a_{32}
                                  \end{bmatrix} \nonumber \\
                               &= \begin{bmatrix}
                                      k_{11}a_{11} + k_{12}a_{21} + k_{13}a_{31}
                                      & k_{11}a_{12} + k_{12}a_{22} + k_{13}a_{32} \\
                                      k_{21}a_{11} + k_{22}a_{21} + k_{23}a_{31}
                                      & k_{21}a_{12} + k_{22}a_{22} + k_{23}a_{32}
                                  \end{bmatrix}
    \end{split}
\end{equation}
$$

矩阵 $\mathcal{K}\mathcal{A}$ 的行数和 $\mathcal{K}$ 相等，列数和 $\mathcal{A}$ 相等。它的元素是在 $\mathcal{K}$ 中对应的行向量和在 $\mathcal{A}$ 中对应的列向量的点积。

假设 $\mathcal{K}\mathcal{A} = \mathcal{B}$，则 $b_{ij} = k_{i\ast} \cdot a_{\ast j}$

## 7. 矩阵乘法另外的视角：「列」

观察 $\mathcal{K}\mathcal{A}$ 的结果：

$$
\begin{equation}
    \begin{split}
        \mathcal{K}\mathcal{A} &= \begin{bmatrix}
                                    k_{11} & k_{12} & k_{13} \\
                                    k_{21} & k_{22} & k_{23}
                                  \end{bmatrix}
                                  \begin{bmatrix}
                                      a_{11} & a_{12}\\
                                      a_{21} & a_{22}\\
                                      a_{31} & a_{32}
                                  \end{bmatrix} \nonumber \\
                               &= \begin{bmatrix}
                                      k_{11}a_{11} + k_{12}a_{21} + k_{13}a_{31}
                                      & k_{11}a_{12} + k_{12}a_{22} + k_{13}a_{32} \\
                                      k_{21}a_{11} + k_{22}a_{21} + k_{23}a_{31}
                                      & k_{21}a_{12} + k_{22}a_{22} + k_{23}a_{32}
                                  \end{bmatrix}
    \end{split}
\end{equation}
$$

$\mathcal{K}\mathcal{A}$ 的第一列，是以 $\mathcal{A}$ 的第一列为规则，对 $\mathcal{K}$ 按列进行线性组合。

$$
\begin{equation}
    \begin{split}
        \begin{bmatrix}
            k_{11}a_{11} + k_{12}a_{21} + k_{13}a_{31} \\
            k_{21}a_{11} + k_{22}a_{21} + k_{23}a_{31}
        \end{bmatrix}  = \nonumber
        a_{11} \begin{bmatrix} k_{11} \\ k_{21}\end{bmatrix} +
        a_{21} \begin{bmatrix} k_{12} \\ k_{22}\end{bmatrix} +
        a_{31} \begin{bmatrix} k_{13} \\ k_{23}\end{bmatrix}
    \end{split}
\end{equation}
$$

$\mathcal{K}\mathcal{A}$ 的第二列，是以 $\mathcal{A}$ 的第二列为规则，对 $\mathcal{K}$ 按列进行线性组合。

如此，矩阵乘法还可以从列的视角来看，$\mathcal{K}\mathcal{A}$ 可以视作以 $\mathcal{A}$ 为规则矩阵，对 $\mathcal{K}$ 的列做线性组合。

### 7.1 列变换

既然可以从列的视角定义矩阵乘法，那么我们应该可以构造一些简单的列变换。交换两列，将某两列相加，对某一列乘以一个数。结合上一节内容，这些变换相当于用一个目标矩阵去乘规则矩阵。

假设

$$
\mathcal{C} = 
\begin{bmatrix}
    c_{11} & c_{12} & c_{13} & c_{14}\\
    c_{21} & c_{22} & c_{23} & c_{24}
\end{bmatrix}
$$

#### 7.1.1 交换两列

交换第一和第二列

$$
\mathcal{C}\mathcal{K} = 
    \begin{bmatrix}
        c_{11} & c_{12} & c_{13} & c_{14}\\
        c_{21} & c_{22} & c_{23} & c_{24}
    \end{bmatrix}
    \begin{bmatrix}
        0 & 1 & 0 & 0 \\
        1 & 0 & 0 & 0 \\
        0 & 0 & 1 & 0 \\
        0 & 0 & 0 & 1
    \end{bmatrix} \nonumber
    =
    \begin{bmatrix}
        c_{12} & c_{11} & c_{13} & c_{14}\\
        c_{22} & c_{21} & c_{23} & c_{24}
    \end{bmatrix}
$$

可以直观地认为，$\mathcal{K}$ 就是把单位矩阵对应的列调整一下。

#### 7.1.2 将某两行相加

将第三列和加到第一列，另三行不变。

$$
\mathcal{C}\mathcal{K} = 
    \begin{bmatrix}
        c_{11} & c_{12} & c_{13} & c_{14}\\
        c_{21} & c_{22} & c_{23} & c_{24}
    \end{bmatrix}
    \begin{bmatrix}
        1 & 0 & 0 & 0 \\
        0 & 1 & 0 & 0 \\
        1 & 0 & 1 & 0 \\
        0 & 0 & 0 & 1
    \end{bmatrix} \nonumber
    =
    \begin{bmatrix}
        c_{11} + c_{13} & c_{12} & c_{13} & c_{14}\\
        c_{21} + c_{23} & c_{22} & c_{23} & c_{24}
    \end{bmatrix}
$$

可以直观地认为，$\mathcal{K}$ 就是把单位矩阵第三列加到第一列。

#### 7.1.3 对某一列乘以一个数

将第二列的元素变为原先的 $k$ 倍。

$$
\mathcal{C}\mathcal{K} = 
    \begin{bmatrix}
        c_{11} & c_{12} & c_{13} & c_{14}\\
        c_{21} & c_{22} & c_{23} & c_{24}
    \end{bmatrix}
    \begin{bmatrix}
        1 & 0 & 0 & 0 \\
        0 & k & 0 & 0 \\
        0 & 0 & 1 & 0 \\
        0 & 0 & 0 & 1
    \end{bmatrix} \nonumber
    =
    \begin{bmatrix}
        c_{11} & kc_{12} & c_{13} & c_{14}\\
        c_{21} & kc_{22} & c_{23} & c_{24}
    \end{bmatrix}
$$

可以直观地认为，$\mathcal{K}$ 就是把单位矩阵第二列乘以 $k$ 即可。

## 8. 总结

数学是基于假设的学科，而定义就是假设，由一个定义出发，可以推出一些结论。有时候定义A和定义B是可以相互推出的，如果以A为定义，B就是推论，反之亦然。通过本文对矩阵乘法定义的考察，无论从行还是从列还是从点积的视角来看，都能得到相同的乘法结果，但是，从行的角度来看能帮助我们更自然更容易理解矩阵的行变换，同理，从列的角度来看又能帮助我们理解矩阵的列变换。而从点积的角度，可以帮助我们去完成一些繁琐的证明，只不过有点缺乏直觉和美感。

矩阵乘法简单汇总如下：

- 从行运算看：矩阵$\mathcal{A}$和$\mathcal{B}$相乘，用左边的矩阵$\mathcal{A}$的各行为规则对右边的矩阵$\mathcal{B}$按行做线性变换。
- 从列运算看：矩阵$\mathcal{A}$和$\mathcal{B}$相乘，用右边的矩阵$\mathcal{B}$的各列为规则对左边的矩阵$\mathcal{A}$按列做线性变换。
- 从点积运算看：$\mathcal{A}\mathcal{B}$的的某个位置的元素 $c_{ij} = a_{i\ast}b_{\ast j}$

## 9. 后记

2024年初，无意在网上看到[马同学的线性代数教程](https://www.matongxue.com/courses/1/)，它对矩阵乘法的讲解就分了三种观点：行观点、点积观点、列观点。我在阅读之后很受启发，这段时间也有空想了一些，于是有了此文。

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
