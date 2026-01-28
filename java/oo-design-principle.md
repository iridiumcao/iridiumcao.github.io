# OO 设计原则

[返回目录](index.md)

针对 OO 开发, 业界有一些流传甚广的设计原则：

1. OCP 开闭原则（Open Close Principle, 对修改关闭, 对扩展开放）。软件在变更中, 尽量不要改原先的功能实现, 新的需求, 新写代码就是。
2. LSP 里氏代换原则（Liskov Substitution Principle, 任何基类出现的地方, 子类一定可以出现）。尽量不要覆盖和重写父类已实现的具体方法。
3. DIP 依赖倒转原则（Dependency Inversion Principle, 依赖于抽象, 不依赖于具体。针对接口编程, 不针对实现编程）。对该原则最重要的应用, 可能就是 Spring 的 IoC 了。
4. ISP 接口隔离原则（Interface Segregation Principle, 使用多个专门接口, 比使用单一的总接口要好）。一个 interface 的内容不应庞杂和过多。
5. CARP 合成/聚合复用原则（Composite/Aggregate Reuse Principle, 尽量使用合成/聚合, 而不要使用继承。聚合：整体和部分的关系。合成：更强的整体和部分, 拥有相同的生命周期）。
6. LoD 迪米特法则（Law of Demeter, 又叫最少知识原则 Least Knowledge Principle 或简写为 LKP）, 如果两个类不必直接通信, 就不要直接通信；尽量降低类成员的访问权限, 通过接口调用, 而不是直接调用。主旨：降低类之间的耦合程度。

设计原则比[设计模式](java/design_pattern/overview.md)根本。公认和流行的23种设计模式，可以看着是符合上述设计原则的一些典型示例，有一定参考价值，在个人在开发软件时，更应依据业务需求并考虑设计原则进行合理的设计，而不是生搬硬套设计模式。大多数场景，其实不能简单归结为某个现存的设计模式。

---

本文最初是从[旧站](https://sites.google.com/site/iridiumsite/it/software-engineering/oo-design-principle)转移过来的。
