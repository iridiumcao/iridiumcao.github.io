# Math in Python

[Index](index_en.md)

Python has excellent built-in support for mathematics, from simple arithmetic to advanced functions via the `math` module.

## Basic Operations

Python supports the four basic arithmetic operations directly:

### Addition, Subtraction, Multiplication, Division

```python
>>> 2 + 3
5
>>> 2 - 3
-1
>>> 2 * 3
6
>>> 2 / 3
0.6666666666666666
```

These operators work with both **integers** and **floats**. Division (`/`) always returns a float.

**Important:** You cannot divide by zero:

```python
>>> 2 / 0
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
ZeroDivisionError: division by zero
```

### Floor Division and Modulo

- `//` → floor division (returns the largest integer less than or equal to the result)
- `%`  → modulo (remainder)

```python
>>> 7 // 3     # floor division
2
>>> 7 % 3      # remainder
1
```

### Exponentiation (`**`)

Use `**` for powers (not `^` — that's bitwise XOR in Python):

```python
>>> 2 ** 3
8
>>> 2 ** 3.14
8.815240927012887
```

```python
>>> 2 ^ 3      # This is NOT exponentiation!
2
```

### Other Built-in Functions

- `abs(x)` → absolute value
- `round(x, ndigits)` → rounding
- `min()`, `max()`, `sum()`

```python
>>> abs(-5)
5
>>> round(3.14159, 2)
3.14
>>> max(1, 5, 3)
5
```

## The `math` Module

For more advanced functions, import the `math` module:

```python
>>> import math
```

**Note:** Python uses American English spelling (`math`, not `maths`):

```python
>>> import maths
Traceback (most recent call last):
  ...
ModuleNotFoundError: No module named 'maths'
```

### Common Functions

**Power and roots:**
```python
>>> math.sqrt(2)          # square root
1.4142135623730951
>>> math.pow(2, 3)        # same as 2**3 but returns float
8.0
```

**Logarithms:**
```python
>>> math.log(math.e)      # natural log (base e)
1.0
>>> math.log10(100)       # base 10
2.0
>>> math.log2(8)          # base 2
3.0
```

**Trigonometry** (all angles in **radians**):
```python
>>> math.sin(math.pi)     # sin(π) ≈ 0 (floating-point result)
1.2246467991473532e-16
>>> math.sin(0)
0.0
>>> math.cos(0)
1.0
>>> math.pi               # constant π
3.141592653589793
>>> math.e                # constant e
2.718281828459045
```

**Tip:** Convert degrees to radians with `math.radians()`:

```python
>>> math.sin(math.radians(90))   # sin(90°)
1.0
```

### Important Note on Precision

Python uses **floating-point** numbers (IEEE 754 double precision). `math.pi` is a very good approximation, but **not** the exact mathematical value of π. For calculations involving exact multiples of π (e.g., `sin(n * π)`), small floating-point errors can appear:

```python
>>> math.sin(math.pi)   # Should be 0, but isn't exactly
1.2246467991473532e-16
```

For high-precision needs, consider the `mpmath` or `sympy` libraries.

## Advanced Math

For more powerful mathematics:

- **NumPy** — Fast arrays, matrices, linear algebra, basic integration/differentiation.
- **SciPy** — Scientific computing (integration, optimization, statistics, signal processing).
- **SymPy** — Symbolic mathematics (exact algebra, calculus, solving equations).

Example with NumPy (for matrices):

```python
import numpy as np
A = np.array([[1, 2], [3, 4]])
B = np.array([[5, 6], [7, 8]])
print(A @ B)        # matrix multiplication
```

For numerical integration, use `scipy.integrate`.

## Summary

- **Built-in operators**: `+ - * / // % **`
- **Built-in functions**: `abs()`, `round()`, `min()`, `max()`, `sum()`
- **`math` module**: `sqrt`, `pow`, `log`, `sin/cos/tan`, `pi`, `e`, and many more → [Official docs](https://docs.python.org/3/library/math.html)
- For serious numerical work: **NumPy + SciPy**
- For symbolic math: **SymPy**

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
        data-lang="en"
        crossorigin="anonymous"
        async>
</script>