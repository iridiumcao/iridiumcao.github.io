# Java 继承中需要注意的几个问题

[返回目录](index.md)

Java 语言作为一种 OO 语言，支持类的扩展，其中有一些需要注意的问题。

## 方法的可见性问题

可以简单表述为：子类方法的可见性要大。

当子类和父类出现方法的名称、参数类型相同时，子类的方法的可见性不能低于父类，而抛出异常的范围不能大于父类。对于可见性的规定，可以这样直观地表述：个体的可见性大于或等于总体的可见性。

示例代码：

```java
public class Item60 {
    public int sum(int a, int b) {
        return a + b;
    }
}
```

它有一个扩展类如下：

```java
public class Item60Ext extends Item60 {
    public int sum(int a, int b) {
        return 0;
    }
}
```

这样的代码是不会有什么问题的。但是，当我们把`Item60Ext.sum(int, int)`的签名进行修改：

```java
public class Item60Ext extends Item60 {
    int sum(int a, int b) { // 不能通过编译，Eclipse 报错：Cannot reduce the visibility of the inherited method from Item60
        return 0;
    }
}
```

解析：`int sum(int a, int b)`使用了默认的可见性：`default`，它的可见性小于父类中设置的`public`。覆盖的同名方法中，子类方法不能比父类方法的访问权限更严格。假如父类中方法是`public`，子类中的同名方法就也只能是`public`，而不能是`protected`或者是`private`。

值得一提的是，这种情况在「类」的级别是不存在的，如`Item60Ext`这个类的可见性定义为`protected`不会有什么问题。

为什么要这么设定？假如不这么设定，子类方法的可见性更小。根据父子类的关系，可以这样创建对象：

```java
Item60 item = new Item60Ext();
```

再假如有一个方法调用它：

```java
void hello() {
    item.sum(1, 2);
}
```

现在我们把 `Item60Ext.sum(int, int)` 的可见性往大改，上面这段代码是不用修改的，但如果把 `Item60Ext.sum(int, int)` 的可见性改小，它就有可能访问不到了，这样原先的代码就不能正常运行了。

## Exception 范围问题

可以简单表述为：子类方法抛出的异常要小。

如果将上面提到的`Item60Ext`修改为

```java
public class Item60Ext extends Item60 {
    public int sum(int a, int b) throws Exception { // 不能通过编译，Eclipse 报错 Exception is not compatible with throws clause in Item60.sum
        return 0;
    }
}
```

解析：父类中，`sum`方法没有抛出异常，可认为父类的异常为空，那么子类中方法的异常必须为父类的子集，就只能也为空了，即不能抛出异常。另外，子类中的 override 的方法所抛出的异常不能比父类中原方法抛出的多。为什么要这么设定？因为根据父子类的关系，可以这样创建对象：

```java
Item60 item = new Item60Ext();
```

再假如有一个方法调用它：

```java
void hello() {
    item.sum(1, 2);
}
```

现在我们把 `Item60Ext.sum(int, int)` 抛出的异常改小，没问题，调用位置捕获的范围不用调整，因为它能覆盖改小后的范围。但如果把 `Item60Ext.sum(int, int)` 的异常范围调大，就必须修改上面方法的代码了，它原先能处理的范围不够了。

## super

在子类中若要使用父类中被隐藏的方法，应该使用`super`关键字。

## static 方法

同名同入口参数的方法，如果父类是非静态的，子类不能是静态的。示例代码如下：

```java
public class HelloWorldC {
    void show(){}
}

public class HelloWorldD extends HelloWorldC {
    static void show(){} // 不能通过编译，Eclipse 报错 the satic method cannot hide the instance method from HelloWorldC
}
```

解析：子类在 override 父类的方法时，父类的方法是动态的则子类的方法也必须是动态的，类似地，父类是静态的话，子类的方法也必须是静态的。静态地 field 和 method 和类是绑定的，不可以 override 或者继承，如果子类的静态 field 和 method 的名称和父类一样，子类中的只是隐藏了父类的。

如果前述代码合法，我们再定义一个对象

```java
HelloWorldC hello = new HelloWorldD();
```

那么

```java
hello.show();
```

这个方法到底算谁的？好像都可以吧。从类型的角度讲，可以算 `HelloWorldC` 的，从对象生成的角度讲可以算 `HelloWorldD` 的。如果不允许这么用，就没歧义了。

(本节同学某王亦有贡献)

## 其他来自网络的内容

* Q: Which version of JDK is compatible with `@Override`? A: JDK 1.6+.
* 泛型除了可以向下限制，您也可以向上限制，只要使用 `super` 關鍵字
* 如果沒有調用超類的構造函數，也沒有將自己的構造函數作爲構造函數的首條可執行語句，那麽在新的構造函數的任何語句執行之前，超類不帶自變量的構造函數就會被自動調用。也就是說，你的構造函數被看做 `super()` 為首條語句。如果超類沒有不帶自變量的構造函數，那麽你必須顯式地調用另一個構造函數。
* 可以把接口看成是特殊的抽象类，因为在接口中所有的方法都是抽象方法，只有声明但没有实现。一个类在继承（extends）一个父类后，还可以同时实现（implements）多个接口，这样便具备了和多重继承同样强大的能力，却比多重继承的结构更加清晰。
