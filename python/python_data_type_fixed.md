# Python's Variable's Type Fixed

In Python, when to define a variable, it's not needed to set the data type. The type will be assigned implicitly as the same as its value's.

e.g.

```python
x = 100
```

100 is an integer, so `x`'s type is `int`.

This is similar as JavaScript. However, JavaSciprt has two keywords `let` and `var`. Python has no keywords to like that.

**In Python, when a variable's data type is set, it's not able to change.** This is different from JavaScript.

e.g.

```python
y = 'hello'
print(y + 3)
```

Save the above script to file `test.py`, and run, we can get

```plaintext
$ python test.py 
Traceback (most recent call last):
  File "test.py", line 2, in <module>
    print(y + 3)
          ~~^~~
TypeError: can only concatenate str (not "int") to str
```

`'hello'` is a string, so `y`'s type is `str`, 3 is an integer. A string is not able to add to an integer, so `y+3` raises error.
