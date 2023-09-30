# Python 类方法中的 self 参数不能省

[Index](index.md)

下面这段Python代码运行会报错。

```python
class Hello(object):
    pass

def hi(self):
    print("hi, word!")

Hello.hi = hi

s2 = Hello()
s2.hi()
```

代码中缺少了一个self参数，需要在调用`Hello.hi`时传入`self`参数。修改后的代码如下所示：

```python
class Hello(object):
    pass

def hi(self):  # 这是唯一的修改点，加了self参数
    print("hi, word!")

Hello.hi = hi

s2 = Hello()
s2.hi()  # 注意这里需要调用s2.hi()，而不是Hello.hi()
```

这样运行就不会报错了。之前出错的原因是`hi`函数定义时缺少了`self`参数，而在Python中调用类方法时，Python会自动将调用该方法的实例作为第一个参数传递给方法，所以需要在`hi`函数的定义中添加`self`参数。
