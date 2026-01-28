# Python's Variable Type is Fixed

[Index](index_en.md)

In Python, when defining a variable, it's not necessary to set the data type. The type will be assigned implicitly as the same as its value.

For example:

```python
x = 100
```

100 is an integer, so `x`'s type is `int`.

This is similar to JavaScript. However, JavaScript has two keywords `let` and `var`. Python has no keywords like that.

**In Python, once a variable's data type is set, it cannot be changed.** This is different from JavaScript.

For example:

```python
y = 'hello'
print(y + 3)
```

Save the above script to file `test.py`, and run it. We get:

```plaintext
$ python test.py 
Traceback (most recent call last):
  File "test.py", line 2, in <module>
    print(y + 3)
          ~~^~~
TypeError: can only concatenate str (not "int") to str
```

`'hello'` is a string, so `y`'s type is `str`, 3 is an integer. A string cannot be added to an integer, so `y+3` raises an error.

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
