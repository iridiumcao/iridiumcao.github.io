# Python 类方法中的 self 参数不能省

[Index](index.md)

## `self`

在 Python 中，`self` 是一个参数，它代表类的实例对象本身。虽然 `self` 不是 Python 中的关键字，但它是 Python 中的一个约定俗成的参数名，通常用于类的方法中，以引用类的实例对象本身。

当调用类的方法时，Python 会自动将类的实例对象传递给该方法的 `self` 参数。通过 `self` 参数，方法可以访问实例对象的属性和方法。

例如，以下是一个简单的 Python 类示例，其中包含一个方法 `get_name()`，它使用 `self` 参数来访问实例对象的属性 name：

```python
class Person:
    def __init__(self, name):
        self.name = name

    def get_name(self):
        return self.name

person = Person("Alice")
print(person.get_name())  # 输出 "Alice"
```

在上面的示例中，`get_name()` 方法使用 `self.name` 访问实例对象的属性 `name`。在调用 `get_name()` 方法时，Python 会自动将 `person` 实例对象传递给 `self` 参数。

## 函数可以先定义到类之外，再赋值进去

下面这段Python代码运行会报错。

```python
class Hello(object):
    pass

def hi():
    print("hi, word!")

Hello.hi = hi

s2 = Hello()
s2.hi()
```

运行后报错：

```plaintext
$ python hello1.py
Traceback (most recent call last):
  File "....../hello1.py", line 10, in <module>
    s2.hi()
    ~~~~~^^
TypeError: hi() takes 0 positional arguments but 1 was given
```

代码中缺少了一个`self`参数，需要在调用`Hello.hi`时传入`self`参数。修改后的代码如下所示：

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

## Name

In Python, functions defined within a class are called methods. They are associated with class instances and can access instance-specific data (via self) or class data (via cls for class methods). For example:python

```python
class MyClass:
    def my_method(self, arg):  # This is a method
        return f"Hello, {arg}!"

obj = MyClass()
result = obj.my_method("world")  # Called on an instance
```

This aligns with OOP conventions, similar to Java's "methods," though C++ often refers to them as "member functions" rather than just "functions."


