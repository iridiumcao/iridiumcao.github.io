# Windows 上没有 `uname`

[Index](index.md)

在 Windows 的 Python 环境下如果想得到操作系统的详细信息，用 `uname` 是不行的，如下：

```python
>>> import os
>>> os.uname
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
AttributeError: module 'os' has no attribute 'uname'. Did you mean: 'name'?
```

在 Windows 上，`os` 模块没有 `uname` 函数，因此会出现 `AttributeError` 错误。`uname` 函数是用于获取操作系统的相关信息，但它在 Windows 上不可用。

如果想获取操作系统的相关信息，可以使用 `platform` 模块。示例如下：

```python
>>> import platform
>>> platform.uname()
uname_result(system='Windows', node='DESKTOP-ABC123', release='10', version='10.0.22621', machine='AMD64')
```

`platform.uname()` 返回的是一个命名元组，可以通过属性访问各个字段的值。

从跨平台的角度，用 `platform.uname()` 更好，因为 Linux 和 Windows 都支持。
