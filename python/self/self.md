# `self` in Python

[Index](index.md)

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