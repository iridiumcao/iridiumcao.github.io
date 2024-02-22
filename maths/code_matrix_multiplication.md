# Implmenting Matrix Multiplication in Programming Code

[Index](index.md)

---

- [Implmenting Matrix Multiplication in Programming Code](#implmenting-matrix-multiplication-in-programming-code)
  - [Definition](#definition)
  - [Implementation](#implementation)
    - [Pesdo Code](#pesdo-code)
    - [Java](#java)
    - [C](#c)
    - [C++](#c-1)
    - [JavaScript](#javascript)
    - [Python](#python)

---

## Definition

(This part is copied from [Matrix multiplication, Wikipedia](https://en.wikipedia.org/wiki/Matrix_multiplication))

If $\mathcal{A}$ is an $m \times n$ matrix and $\mathcal{B}$ is an $n \times p$ matrix,

$$\mathcal{A}=\begin{bmatrix}
 a_{11} & a_{12} & \cdots & a_{1n} \\
 a_{21} & a_{22} & \cdots & a_{2n} \\
 \vdots & \vdots & \ddots & \vdots \\
 a_{m1} & a_{m2} & \cdots & a_{mn} \\
\end{bmatrix},\quad\mathcal{B}=\begin{bmatrix}
 b_{11} & b_{12} & \cdots & b_{1p} \\
 b_{21} & b_{22} & \cdots & b_{2p} \\
 \vdots & \vdots & \ddots & \vdots \\
 b_{n1} & b_{n2} & \cdots & b_{np} \\
\end{bmatrix}$$

the _matrix product_ $\mathcal{C} = \mathcal{AB}$ (denoted without multiplication signs or dots) is defined to be the $m \times p$ matrix

$$\mathcal{C} = \begin{bmatrix}
 c_{11} & c_{12} & \cdots & c_{1p} \\
 c_{21} & c_{22} & \cdots & c_{2p} \\
 \vdots & \vdots & \ddots & \vdots \\
 c_{m1} & c_{m2} & \cdots & c_{mp} \\
\end{bmatrix}$$

such that

$$c_{ij} = a_{i1} b_{1j} + a_{i2} b_{2j} + \cdots + a_{in} b_{nj} = \sum_{k=1}^n a_{ik} b_{kj},$$

for $i = 1, ..., m$ and $j = 1, ..., p$.

That is, the entry $c_{ij}$ of the product is obtained by multiplying term-by-term the entries of the $i$th row of $\mathcal{A}$ and the $j$th column of $\mathcal{B}$, and summing these $n$ products. In other words, $c_{ij}$ is the [dot product](https://en.wikipedia.org/wiki/Dot_product) of the $i$th row of $\mathcal{A}$ and the $j$th column of $\mathcal{B}$.

Therefore, $\mathcal{AB}$ can also be written as

$$\mathcal{C} = \begin{bmatrix}
 a_{11}b_{11} +\cdots + a_{1n}b_{n1} & a_{11}b_{12} +\cdots + a_{1n}b_{n2} & \cdots & a_{11}b_{1p} +\cdots + a_{1n}b_{np} \\
 a_{21}b_{11} +\cdots + a_{2n}b_{n1} & a_{21}b_{12} +\cdots + a_{2n}b_{n2} & \cdots & a_{21}b_{1p} +\cdots + a_{2n}b_{np} \\
\vdots & \vdots & \ddots & \vdots \\
 a_{m1}b_{11} +\cdots + a_{mn}b_{n1} & a_{m1}b_{12} +\cdots + a_{mn}b_{n2} & \cdots & a_{m1}b_{1p} +\cdots + a_{mn}b_{np} \\
\end{bmatrix}
$$

Thus the product $\mathcal{AB}$ is defined if and only if the number of columns in $\mathcal{A}$ equals the number of rows in $\mathcal{B}$, in this case $n$.

In most scenarios, the entries are numbers, but they may be any kind of [mathematical object](https://en.wikipedia.org/wiki/Mathematical_object)s for which an addition and a multiplication are defined, that are [associative](https://en.wikipedia.org/wiki/Associative_property), and such that the addition is [commutative](https://en.wikipedia.org/wiki/Commutative_property), and the multiplication is [distributive](https://en.wikipedia.org/wiki/Distributive_property) with respect to the addition. In particular, the entries may be matrices themselves (see [block matrix](https://en.wikipedia.org/wiki/Block_matrix)).

## Implementation

According to the definition, we can implement it with a programming languange. A matrix can be presented by a two demensional array.

- Input: matrix $\mathcal{A}$ and $\mathcal{B}$
  - the number of columns in $\mathcal{A}$ equals the number of rows in $\mathcal{B}$
- Output: $\mathcal{C}$
  - $\mathcal{C} = \mathcal{AB}$

### Pesdo Code

```plaintext
// Input:
//     a: matrix A, m X n (rows: m, columns: n)
//     b: matrix B, n X p (rows: n, columns: p)
// Output:
//     c: matrix C, C = AB (rows: m, columns: p)
produce(a, b) {
    check the numbers of input matrix;
    if legal, continue, or return;
    build c with n rows and p columns;
    set every c[i][j]'s value {
        get the i-th row of A -> c_row;
        get the j-th column of B -> c_col;
        calculate the dot product of c_row and c_col;
        c[i][j] <- the dot product;
    }
    return c;
}
```

### Java

It's easy to implement it in Java according to the pesudo code.

```java
public static double[][] product(double[][] a, double[][] b) {
    int rows = a.length;
    int columns = b[0].length;
    double[][] c = new double[rows][columns];

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            double[] row = a[i];
            double[] col = new double[columns];
            for (int k = 0; k < b.length; k++) {
                col[k] = b[k][j];
            }

            // c[i][j] = a[i][*] b[*][j]
            c[i][j] = dotProduct(row, col);
        }
    }
    return c;
}

public static double dotProduct(double[] a, double[] b) {
    double dp = 0.0;
    for (int i = 0; i < a.length; i++) {
        dp += a[i] * b[i];
    }
    return dp;
}
```

Yes, it works. However, it seems to be too verbose. We can consider to remove the method `docProduct(double[], double[])`, since it's too simple.

```java
public static double[][] product(double[][] a, double[][] b) {
    int rows = a.length;
    int columns = b[0].length;
    double[][] c = new double[rows][columns];

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            double[] row = a[i];
            double[] col = new double[columns];
            for (int k = 0; k < b.length; k++) {
                col[k] = b[k][j];
            }

            // c[i][j] = a[i][*] b[*][j]
            for (int p = 0; p < rows; p++) {
                c[i][j] += row[p] * col[p];
            }
        }
    }
    return c;
}
```

Since

```java
double[] row = a[i];
double[] col = new double[columns];
```

Continue to simplify it, removing the definition of `row` and `col`:

```java
public static double[][] productV2(double[][] a, double[][] b) {
    int rows = a.length;
    int columns = b[0].length;
    double[][] c = new double[rows][columns];

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            for (int k = 0; k < b.length; k++) {
                c[i][j] += a[i][k] * b[k][j];
            }
        }
    }
    return c;
}
```

[Download Code in Java](code/Matrix.java)

### C

### C++

### JavaScript

(run in nodejs)

### Python

More details of the definition refs to [Understanding Matrix Multiplication](matrix_multiplication.md) (in Chinese).
