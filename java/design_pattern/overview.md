# 设计模式简述

[Index](../index.md)

模式，套路也。设计模式(Design Pattern)是开发实践中总结出的一些编程范式，Java中的设计模式可以按下表方式呈现：

<table>
  <tbody>
    <tr>
      <td colspan="2" rowspan="2"> </td>
      <td colspan="3" style="text-align:center">
        <b> 目的</b>
      </td>
    </tr>
    <tr>
      <td>
        <b> 创建型 Creational</b>
      </td>
      <td>
        <b>
          结构型 Structual
          <br />
        </b>
      </td>
      <td>
        <b>行为型 Behavioral</b>
      </td>
    </tr>
    <tr>
      <td rowspan="2">
        <b>
           范围
          <br />
          Scope
          <br />
        </b>
      </td>
      <td>
        <b>
           类 Class
          <br />
        </b>
      </td>
      <td><a href="factory_method.html">Factory Method(工厂方法)</a></td>
      <td>
        Adapter(适配器 class)
      </td>
      <td>
        Interpreter
        <br />
        Template Method
        <br />
      </td>
    </tr>
    <tr>
      <td>
        <b>
           对象 Object
          <br />
        </b>
      </td>
      <td>
        Abstract Factory
        (抽象工厂)
        <br />
        Builder
        (生成器)
        <br />
        Prototype
        (原型)
        <br />
        Singleton
        (单例)
        <br />
      </td>
      <td>
        Adapter(object)
        <br />
        Bridge
        (桥接)
        <br />
        Composite
        (组成)
        <br />
        Decorator
        (装饰)
        <br />
        Facade
        (门面)
        <br />
        Flyweight
        (享元)
        <br />
        <a href="proxy.html"> Proxy (代理) </a>
        <br />
      </td>
      <td>
        Chain of Responsibility
        <br />
        Command
        <br />
         Iterator
        <br />
         Mediator
        <br />
         Memento
        <br />
        Observer
        <br />
        State
        <br />
        Strategy
        <br />
         Visitor
        <br />
      </td>
    </tr>
  </tbody>
</table>

* 创建模式处理对象的创建过程，结构模式处理类和对象的组成，行为模式详细说明类和对象之间如何交互以及如何分配职责给对象和类。
* GOF 的《设计模式》描述方式是非常棒的，分成若干固定的部分，每个模式都如是描述一番，很透彻。
* 模式之间的区分，主要是在语义上的，而非语法上的。如果不注意这点，就会对语法类似，但语义不同的模式感到困惑。
* 在实际工作中，应该首先考虑功能完成。其次是模式、性能等等，这些都可以通过重构来完善的。

---

This page is copied from [the old site](https://sites.google.com/site/iridiumsite/it/software-engineering/design-pattern).
