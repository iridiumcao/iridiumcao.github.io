# Python Names Can Refer to Values of Different Types

[Index](index.md)

In Python, assignment binds a name to an object. The object has a type, and you can later bind the same name to an object of a different type.

For example:

```python
x = 100
```

At this point, `x` refers to an integer. Assigning `x = 'hello'` would bind it to a string instead.

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

`y` refers to a string, and `3` is an integer. Python does not automatically convert the integer to a string for concatenation, so `y + 3` raises a `TypeError`.

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
