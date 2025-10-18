# Python 类简介

[Index](../index.md)

Python 是一种灵活的语言，它可以是面向过程的，也可以是面向对象(OOP)的。

类(Class)是面向对象语言的核心概念。在 Python 中，几乎所有东西都是对象，每个对象都有其类型(Type)，而类(Class)就是定义对象类型的模板。

不同语言的类型系统有相似和不同之处。如果熟悉 Java，会比较容易理解 Python 的类，但两者的不同也往往让初学者误解。

从面向对象的角度，一切皆为对象(Object)，所有对象皆有其类型(Class). 一个 Class 可以创建多个 Object。Class 中定义一些属性和方法，实例化后即可使用。这里定义一个简单的 Python 类：

```python
class Person:
    def __init__(self, name):
        self.name = name

    def get_name(self):
        return self.name
    
    def hello(self):
        return f"Hello from {self.name}!"
```

([Source](code/person.py))

它定义的 `Person` 类别的对象有 `name` 属性，以及一个打招呼的方法(`hello(self)`)，可以这样调用：

```python
alice = Person("Alice")  # Create a new Person object whose name is Alice
print(alice.get_name())  # Output: "Alice"
print(alice.hello())     # Output: "Hello from Alice!"

bob = Person("Bob")      # Create a new Person object whose name is Bob
print(bob.get_name())    # Output: "Bob"
print(bob.hello())       # Output: "Hello from Bob!"
```

注意，Python 是动态类型语言(dynamically typed)，它创建对象的方式和 Java 这种静态语言有区别：不需要声明变量类型，也不需要使用 `new` 关键字。

- Python: `alice = Person("Alice")`
- Java: `Person alice = new Person("Alice");`

`__init__` 是类的构造方法，在创建对象时自动调用，用于初始化实例属性。
例如，`Person("Alice")` 会自动调用 `__init__(self, name)`。

在 Python 类中定义实例方法时，第一个参数 `self` 必须有，它用来表示当前对象，类似 Java 的 `this` 关键字。`self` 并非关键字，也可以使用别的名称(如 `this`, [Source](code/person2.py))。在调用实例方法时，不用写 `self` 参数。请看前面的例子：

- 实例方法定义时：`def hello(self)`
- 实例方法调用时：`alice.hello()`

看起来定义和调用的同名方法 `hello(self)`, `hello()` 的参数列表不一样，但其实是一致的，定义时，显式写上 `self` 参数，调用时隐藏——调用时 Python 自动把 `alice` 作为第一个参数传递给 `self`。这和 Java 的处理有区别，Java 定义和调用时 `this` 关键字都是隐藏提供的。个人认为 Java 的做法更好，虽然有人说这是符合 Python 哲学思想的。

本文用以初步了解 Python 类的概念，后续还将展开更多内容，如继承、属性、方法等。

## 附：运行文本代码的方法

1. 确认本机已安装 Python 环境，推荐 Python 3.x 版本
2. 下载代码 [Source](code/person.py)
3. 在代码目录打开 Terminal 执行指令：`python person.py`
