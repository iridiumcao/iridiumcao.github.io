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

# Scilab 求解线性方程组示例(linsolve)

[Index](index.md)

方程组：

$$
\begin{cases}
x_1-3x_2-2x_3-x_4=6 \\
3x_1-8x_2+x_3+5x_4=0 \\
-2x_1+x_2-4x_3+x_4=12 \\
-x_1+4x_2-x_3-3x_4=2 \\
\end{cases}
$$
  
Scilab 求解代码：

```bash
-->A = [1 -3 -2 -1; 3 -8 1 5; -2 1 -4 1; -1 4 -1 -3]
-->b = [-6; 0; 12; -2]
-->linsolve(A, b)
```

  
注意，

1.  Scilab 中定义矩阵的方式，行与行之间用分号断开，但一行中的各元素用空格断开
2.  矩阵 b, 是将常数列移动等号左边的结果
3.  函数名称 `linsolve` 而非 _linesolve_

执行以上代码的实际输出如下：

```bash
-->A = [1 -3 -2 -1; 3 -8 1 5; -2 1 -4 1; -1 4 -1 -3]
 A  =
 
    1.  - 3.  - 2.  - 1. 
    3.  - 8.    1.    5. 
  - 2.    1.  - 4.    1. 
  - 1.    4.  - 1.  - 3. 
 
-->b = [-6; 0; 12; -2]
 b  =
 
  - 6.  
    0.  
    12. 
  - 2.  
 
-->linsolve(A, b)
 ans  =
 
    2. 
  - 1. 
    1. 
  - 3.  
```

---

本文最初于2018.03.31 18:40发布在[OSC](https://my.oschina.net/iridium/blog/1822940).