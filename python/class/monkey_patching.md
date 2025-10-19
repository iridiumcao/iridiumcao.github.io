# 猴子补丁(Monkey Patching)：在类之外定义方法

——Python 动态方法注入指南

[Index](../index.md)

通常，我们在类体内定义方法，但实际上，方法只是函数绑定到类或实例上的结果。但有时我们在引用第三方代码并且不方便修改源代码时，可以通过变通的方式给类增加方法。我们可以先定义一个函数，然后将其赋值给类的属性，从而成为类的方法。

## 实验，实例方法

例如：

```python
# 定义一个空类
class Hello():
    pass

def hi(self):  # 因为这个函数将要作为 Hello 类的实例方法，所以第一个参数 self 必须有。
    print("hi, word!")

# 将上面定义的函数赋值给 Hello 的属性 hi
Hello.hi = hi

h = Hello()
h.hi()  # 注意这里需要调用h.hi()，而不是Hello.hi()
Hello.hi(h)  # 也可以这样调用，不过不推荐
```

([Source](code/hello1.py))

我们先定义了一个空的类 `Hello`，再在类之外定义了函数 `hi(self)`，在通过 `Hello.hi = hi` 绑定到类上。

这个示例中，外部定义的函数和类的属性都是 `hi`，实际上函数名不必和属性名相同，因此，下面的代码也是可以的：

```python
class Hello():
    pass

def hello(self):
    print("hi, word!")

Hello.hi = hello

h = Hello()
h.hi()
```

这样，我们就在不修改类定义的情况下，为 `Hello` 实例动态增加了一个方法。

## 实验，类方法

我们还可以在类之外定义类方法(class method)然后绑定到类上。示例如下：

```python
class Hello():
    pass

def class_hi(cls):  # 注意第一个参数是 cls(类变量)
    print(f"hello from class {cls.__name__}!")

Hello.class_hi = classmethod(class_hi)  # 用 classmethod 包装

Hello.class_hi()   # 输出: hello from class Hello!
```

这里特别需要注意两点：

- 外部函数在定义时，第一个参数必须是 `cls` (类变量)
- 需要用 `classmethod` 包装外部函数之后才能赋值给类的属性：`Hello.class_hi = classmethod(class_hi)`.

这样，我们就在不修改类定义的情况下，为 `Hello` 类动态增加了一个方法。

## 实验，静态方法

我们还可以在类之外定义静态方法(static method)然后绑定到类上。示例如下：

```python
class Hello:
    pass

def static_hi():  # 无需 self 或 cls
    print("hello from static method!")

Hello.static_hi = staticmethod(static_hi)  # 用 staticmethod 包装

Hello.static_hi()  # 输出: hello from static method!
h = Hello()
h.static_hi()      # 输出: hello from static method!
```

外部函数需要通过`staticmethod` 包装之后才能赋值给类的属性：`Hello.static_hi = staticmethod(static_hi)`.

## 注意事项

- `classmethod` 和 `staticmethod` 是内置类型(并非 `functools` 模块的函数)，可直接使用，无需导入。
- 绑定时机：最好在类定义后、实例化前绑定，以避免意外。
- 类型提示：如果用类型提示(如 `self: Hello`)，动态添加时 IDE 可能不智能提示，但运行无问题。
- 猴子补丁(Monkey Patching)指在运行时动态修改类、模块或实例的行为(如添加、替换方法或属性)。这在调试、兼容性修复中很有用，但也可能带来难以追踪的副作用。

> ⚠️ 警告：
> Monkey Patching 可能在大型项目中引发兼容性或安全问题，尤其当多个模块同时修改同一类时。

## 赋值方式总结

- 实例方法：直接赋值函数即可(函数需接受 `self` 作为第一个参数)。当通过实例访问时，Python 会自动将其绑定到该实例上。
- 类方法：函数需接受 `cls`(类本身)作为第一个参数，然后用 `classmethod()` 包装后赋值。调用时，可以通过类或实例访问。
- 静态方法：函数不需要 `self` 或 `cls`，直接用 `staticmethod()` 包装后赋值。调用时，也可通过类或实例访问。
