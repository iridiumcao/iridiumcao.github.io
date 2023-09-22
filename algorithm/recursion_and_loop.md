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

# 递归，尾递归，循环(Recursion, Tail Recursion and Loop)

[返回目录](index.md)

（2022.10）

本文示例递归，尾递归和循环的等价写法，例子由浅入深——阶乘，阶和（从1到n的自然数之和），汉诺塔，Fibbonaci Array, 文件遍历。所有示例用Java, Python, JavaScript, C++等四种语言表达。所有示例都是完整可运行的代码，均在本机测试过。

* 递归，函数调用自身。
* 尾调用，函数在返回时，调用另一个函数。
* 尾递归，函数返回时，调用且仅调用自身。尾递归属于尾调用的一种。调用自身的尾调用即尾递归。

理论上，所有普通递归，都有等价的尾递归形式，而尾递归，可以看成是循环结构的另一种写法。从效率上讲尽量用循环，不用递归，包括尾递归。

* 据说JavaScript只在严格模式下才对尾递归进行优化，参[什么是尾递归？ 尾递归和普通的递归的区别](https://juejin.cn/post/6959549674990600228)
* 理论上尾递归可以优化，减少函数调用栈，但实际上很多语言都没处理，比如Python，参[递归函数](https://www.liaoxuefeng.com/wiki/1016959663602400/1017268131039072)
* 尾递归可以認爲就是循环的另一種寫法
* 普通递归 -> 尾递归 -> 循环
* 附带提一下“相互递归”

## Demos

### Factorial

In mathematics, the factorial of a non-negative integer $n$, denoted by $n!$, is the product of all positive integers less than or equal to n. [Ref](https://en.wikipedia.org/wiki/Factorial)

#### Java

```java
public class Factorial {

    // loop
    static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // recursion
    static int factorial2(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial2(n - 1);
    }

    // tail recursion
    static int factorial3(int n) {
        if (n == 1) {
            return 1;
        }
        return factorial3(n, 1);
    }

    static int factorial3(int n, int product) {
        if (n == 1) {
            return product;
        }
        return factorial3(n - 1, n * product);
    }

    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(factorial(4));

        System.out.println(factorial2(3));
        System.out.println(factorial2(4));

        System.out.println(factorial3(3));
        System.out.println(factorial3(4));
    }
}
```

### Python

```python
# loop
def factorial(n):
    result = 1
    for i in range(1, n + 1):
        result *= i
    return result

# recursion
def factorial2(n):
    if (n == 1):
        return 1
    return n * factorial2(n-1)

# tail recursion
def factorial3(n, product = 1):
    if (n == 1):
        return product
    return factorial3(n-1, n * product)

print(factorial(3))
print(factorial(4))

print(factorial2(3))
print(factorial2(4))

print(factorial3(3))
print(factorial3(4))

```

### JavaScript

```javascript
'use strict'

// loop
var factorial = function (n) {
    let result = 1
    for (let i = 1; i <= n; i++) {
        result *= i
    }

    return result
}

// recursion
var factorial2 = function (n) {
    if (n === 1) {
        return 1
    }

    return n * factorial2(n - 1)
}

// tail recursion
var factorial3 = function (n, product = 1) {
    if (n === 1) {
        return product
    }
    return factorial3(n - 1, n * product)
}

console.log(factorial(3))
console.log(factorial(4))

console.log(factorial2(3))
console.log(factorial2(4))

console.log(factorial3(3))
console.log(factorial3(4))

```

### C++

```cpp
#include <iostream>

using namespace std;

// loop
int factorial(int n)
{
    int result = 1;
    for (int i = 1; i <= n; i++)
    {
        result *= i;
    }
    return result;
}

// recursion
int factorial2(int n)
{
    if (n == 1)
    {
        return 1;
    }

    return n * factorial2(n - 1);
}

int factorial3(int n, int product = 1)
{
    if (n == 1)
    {
        return product;
    }
    return factorial3(n - 1, n * product);
}

int main()
{
    cout << factorial(3) << endl;
    cout << factorial(4) << endl;

    cout << factorial2(3) << endl;
    cout << factorial2(4) << endl;

    cout << factorial3(3) << endl;
    cout << factorial3(4) << endl;

    return 0;
}
```
