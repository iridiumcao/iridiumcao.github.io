# Python 类中的方法

[Index](../index.md)

---

- [Python 类中的方法](#python-类中的方法)
  - [1. 实例方法(Instance Method)](#1-实例方法instance-method)
    - [1.1 `self` in Python](#11-self-in-python)
      - [1.1.1 实验，实例方法缺少 `self`](#111-实验实例方法缺少-self)
      - [1.1.2 实验，调用实例方法时显式使用 `self` 参数](#112-实验调用实例方法时显式使用-self-参数)
      - [1.1.3 实验，`self` 的类型](#113-实验self-的类型)
      - [1.1.4 实验，`self` 改名](#114-实验self-改名)
    - [1.2 构造器 `__init__`](#12-构造器-__init__)
      - [1.2.1 实验，区分实例变量和方法变量](#121-实验区分实例变量和方法变量)
  - [2. 类方法(Class Method)](#2-类方法class-method)
  - [3. 静态方法(Static Method)](#3-静态方法static-method)
    - [3.1 Python 类的静态方法](#31-python-类的静态方法)
      - [3.1.1 实验，作为工具的静态方法](#311-实验作为工具的静态方法)
    - [3.2 Java 类的静态方法](#32-java-类的静态方法)
  - [4. 总结](#4-总结)

---

Python 类(class)中的方法有三类：

- 实例方法(instance method)，包括构造方法 `__init__()`
- 类方法(class method)
- 静态方法(static method)

Python 的类中可以定义上述三种方法。在 Java 中没有类方法(class method)的概念，只有通过 `static` 修饰的静态方法，相当于Java 将类方法和静态方法合并为静态方法。Python 的类方法功能部分类似于 Java 的静态方法，但语义上更灵活。本文将通过示例具体说明。

函数 VS 方法。在 Python 中，函数(function)与方法(method)本质上都是函数对象。不同的是，当函数定义在类中时，它会成为方法，在绑定行为上有所区别。类外定义的函数则是普通函数。

## 1. 实例方法(Instance Method)

使用的类型(class)的一个重要目的就是为了创建此类型的实例(instance). Python 和 Java 在定义和调用实例方法上有一些区别。我们可以在类中定义一些函数供创建后的实例对象使用，这些函数就称为实例方法(instance method).

### 1.1 `self` in Python

Python 中的实例方法的第一个参数就是当前对象，这个写死的规则，并且**必须**有个这个参数，如果实例方法的参数列表为空，运行时会报错。这个参数一般命名为 `self`, 它和 Java 中的 `this` 关键字作用有些类似，不过在语法上有区别，在 Java 中 `this` 不用显式声明，可以在方法中直接使用，但在 Python 中，必须在方法的参数列表中第一个参数位置声明当前实例对象。在 Java 中，任何实例对象中隐含一个默认变量 `this` 指向当前对象，但 Python 中无此约定，必须显式指定。以下举例说明。

```python
class Person:
    def hello(self):
        return "Hello, world!"
```

([Source](code/person3.py))

我们可以用这个类创建实例(instance)，并调用其中的方法

```python
alice = Person()
print(alice.hello())     # "Hello, world!"
```

细心的你可能已经发现方法在定义和调用时的参数列表是不一致的，比如 `hello`:

- 定义时的方法签名：`hello(self)`
- 调用时的方法签名：`hello()`

定义方法 `hello` 时，有参数 `self`，但调用时却没有 `self` 这个参数，这处**不一致**往往让初学者费解。其实这是 Python 语言机制，定义实例方法时，第一个参数必须有，且它表示的含义也是确定的：它就表示当前实例对象。在定义实例方法时，`self` 需要显式声明，但在调用时，需要隐藏。当调用类的方法时，Python 会自动将类的实例对象传递给该方法的 `self` 参数。通过 `self` 参数，方法可以访问实例对象的属性和方法。

不过 `self` 并非 Python 的关键字，你也可以使用其他关键字，比如 `this` 也是可以的。不过 `self` 这个名称几乎已经成了事实上的规范，几乎不会有人使用其他名称。

#### 1.1.1 实验，实例方法缺少 `self`

在定义函数时，省略 `self`:

```python
class Person:
    def hello(): # Remove self
        return "Hello, world!"

alice = Person()
print(alice.hello())
```

([Source](code/person4.py))

运行时会报错：

```plaintext
$ python person4.py 
Traceback (most recent call last):
  File ".../your/path/person4.py", line 6, in <module>
    print(alice.hello())
          ~~~~~~~~~~~^^
TypeError: Person.hello() takes 0 positional arguments but 1 was given
```

#### 1.1.2 实验，调用实例方法时显式使用 `self` 参数

调用时显式使用 `self` 参数

```python
class Person:
    def hello(self):
        return "Hello, world!"

alice = Person()
print(Person.hello(alice)) # invoke the method via class, passing instance explicitly
```

([Source](code/person5.py))

运行上面这段代码，可以发现 `Person.hello(alice)` 和 `alice.hello()` 的值是一样的。

#### 1.1.3 实验，`self` 的类型

前面提到 `self` 代表当前实例，那么它的类型就应该是当前类，我们可以通过下面的代码来验证。

```python
class Person:
    def hello(self):
        return f"Hello, world! Type of self is {type(self)}"

alice = Person()
print(alice.hello())
```

([Source](code/person6.py))

运行过程和结果如下：

```plaintext
$ python person6.py 
Hello, world! Type of self is <class '__main__.Person'>
```

可见 `self` 的类型确实就是当前类 `Person`。

#### 1.1.4 实验，`self` 改名

前面提到 `self` 并非 Python 关键字，只是约定俗成而已，它可以改成任何关键字，下面两个例子都能正常运行。

改成 `this`:

```python
class Person:
    def __init__(this, name):
        this.name = name

    def get_name(this):
        return this.name
    
    def hello(this):
        return f"Hello from {this.name}!"

alice = Person("Alice")
print(alice.get_name())  # "Alice"
print(alice.hello())     # "Hello from Alice!"
```

([Source](code/person7.py))

改成 `myself`:

```python
class Person:
    def __init__(myself, name):
        myself.name = name

    def get_name(myself):
        return myself.name
    
    def hello(myself):
        return f"Hello from {myself.name}!"

alice = Person("Alice")
print(alice.get_name())  # "Alice"
print(alice.hello())     # "Hello from Alice!"
```

([Source](code/person8.py))

上面的两个例子都能正常运行并且结果和用 `self` 时是一样的。不过值得再次说明的是，为了程序的可读性和可维护性，请优先使用 `self`.

### 1.2 构造器 `__init__`

构造器 `__init__`是一个特殊的实例方法，它在实例创建后被自动调用，可用于初始化实例的属性，比如：

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

这个类的构造方法为：

```python
    def __init__(self, name):
        self.name = name
```

它的函数名必须是 `__init__`，作为一个实例方法，它的第一个参数必须是 `self`。它在创建实例对象时，初始化 `name` 并绑定到当前实例对象. 调用这个类的语句示例：

```python
alice = Person("Alice")
print(alice.get_name())  # "Alice"
print(alice.hello())     # "Hello from Alice!"
```

在上面的示例中，`get_name()` 方法使用 `self.name` 访问当前实例对象的属性 `name`。在调用 `get_name()` 方法时，Python 会自动将 `Person` 实例 `alice` 对象传递给 `self` 参数。

注意，实例的真正创建由 `__new__` 方法完成，而 `__init__` 仅负责初始化。

#### 1.2.1 实验，区分实例变量和方法变量

前面提到的构造方法

```python
    def __init__(self, name):
        self.name = name
```

它对初学者来说可能会有一些疑惑，`self.name = name` 中左边和右边的 `name` 就是怎么回事？只是同名了而已，其实 `self.name` 中的 `name` 表示当前实例对象的属性 `name`，而右边的 `name` 表示构造方法的参数。它们的作用域和生命周期都不一样。我们可以将实例属性修改为 `my_name` 来说明这一点：

```python
class Person:
    def __init__(self, name):
        self.my_name = name

    def get_name(self):
        return self.my_name
    
    def hello(self):
        return f"Hello from {self.my_name}!"

alice = Person("Alice")
print(alice.get_name())  # "Alice"
print(alice.hello())     # "Hello from Alice!"
```

生命周期：

- 左边的 `self.name` 或 `self.my_name`: 实例对象的生存期
- 右边的 `name`: `__init__` 方法内部

## 2. 类方法(Class Method)

类方法与类本身绑定，而不是与实例绑定。虽然可以通过实例调用，但传入的第一个参数 `cls` 始终引用该类对象。定义类方法需要用到 `@classmethod` 修饰器。

```python
class Person:
    count = 0  # Class variable to track total instances

    def __init__(self, name):
        self.name = name
        Person.count += 1  # Increment on each new instance

    # Instance method (uses 'self')
    def greet(self):
        return f"Hello, my name is {self.name}. Count: {self.__class__.count}"
   
    # Class method (uses 'cls', operates on the class)
    @classmethod
    def get_count(cls):
        return cls.count  # Just returns the class variable—no side effects


# Test the code
alice = Person("Alice")
print(Person.get_count())  # Output: 1
print(alice.greet())       # Output: Hello, my name is Alice. Count: 1

bob = Person("Bob")
print(Person.get_count())  # Output: 2
print(bob.greet())         # Output: Hello, my name is Bob. Count: 2
```

([Source](code/person11.py))

上面例子中，`count` 是类的属性，它是 `Person` 类的实例的计数器，每创建一个实例，值就+1. 

注意类方法的定义：

```python
    @classmethod
    def get_count(cls):
        return cls.count  # Just returns the class variable—no side effects
```

它使用 `@classmethod` 装饰器，它的第一个参数是 `cls`，表示绑定当前类，这个参数是必须的，不过名称不一定要用 `cls`, 它只是约定俗成而已。`cls` 和 `self` 类似，前者绑定当前类，后者绑定当前实例对象。

在 `greet` 方法中，用 `self.__class__.count` 明确访问类变量，避免与实例变量混淆。其实 `self.count` 也能工作，因为类变量会“冒泡”到实例，但用 `self.__class__.count` 更清晰地展示类方法与实例的关联。

另外需要注意，本例中的构造器，不但初始化了实例对象的属性，还更新了当前类的属性。

## 3. 静态方法(Static Method)

静态方法不依赖于类或实例的状态，仅被放置在类的命名空间中，主要用于组织相关的功能函数，无需创建实例即可使用。Python 和 Java 在定义和使用静态方法时，大同小异。
在 Python 中静态方法和实例方法以及类方法是区分开的，但 Java 中静态方法和类方式是合并在一起的，静态方法就是类方法。

### 3.1 Python 类的静态方法

在 Python 中可使用注解 `@staticmethod` 来创建，举例如下：

```python
class Person:
    @staticmethod
    def greet():
        return f"Hello, world!"

print(Person.greet()) # Output: Hello, world!

alice = Person()
print(alice.greet())  # Output: Hello, world!

```

([Source](code/person12.py))

注意示例中的静态方法：

```python
    @staticmethod
    def greet():
        return f"Hello, world!"
```

它用了 `@staticmethod` 装饰器，并且不需要特殊的参数 `self` 和 `cls`, 表示它无需和当前实例对象或者类绑定。静态方法在定义和调用时的参数列表在字面上也是一致的。

这个例子中展示了两种方式调用静态方法：

- `Person.greet()`：直接通过类名来调用。Python 和 Java 都是这个做法。
- (最后两句)：通过实例来调用静态方法。Java 也有这种用法，但不推荐。

#### 3.1.1 实验，作为工具的静态方法

前面的静态方法没有参数，仅为最简单的演示，这里举一个有实际用途的例子：验证名字是否为空。

```python
class Person:
    def __init__(self, name=""):
        self.name = name

    @staticmethod
    def greet():
        return f"Hello, world!"
    
    @staticmethod
    def is_name_empty(name):
        return name == ""

print(Person.greet()) # Output: Hello, world!

alice = Person()
print(Person.is_name_empty(alice.name)) # Output: True

bob = Person("Bob")
print(Person.is_name_empty(bob.name)) # Output: False
```

([Source](code/person13.py))

### 3.2 Java 类的静态方法

在 Java 中，通过 `static` 关键字修饰方法即可，举例如下：

```java
class Person12 {
    public static String greet() {
        return "Hello, world!";
    }

    public static void main(String[] args) {
        // 通过类名调用静态方法
        System.out.println(Person12.greet()); // Output: Hello, world!

        // 通过实例调用静态方法
        Person12 person = new Person12();
        System.out.println(person.greet()); // Output: Hello, world!
    }
}
```

([Source](code/Person12.java))

编译运行过程如下：

```plaintext
$ javac Person12.java 
$ java Person12
Hello, world!
Hello, world!
```

## 4. 总结

| 方法类型 | 装饰器        | 第一个参数              | 绑定行为 | 示例场景                                 |
|----------|---------------|-------------------------|----------|------------------------------------------|
| 实例方法 | 无            | `self` (也可以是其他名称) | 实例方法绑定到实例，自动传入实例对象。 | 修改实例状态                             |
| 类方法   | `@classmethod`  | `cls` (也可以是其他名称)  | 类方法绑定到类，自动传入类对象。   | 工厂方法创建实例，或管理类状态（如计数器） |
| 静态方法 | `@staticmethod` | 无                      | 静态方法不绑定任何对象，不自动传入任何参数。       | 工具函数(如验证输入)                   |