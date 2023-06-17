# 如何描述一个 bug

[Index](index.md)

反馈软件中的 bug, 将问题描述清楚是非常重要的.

书面描述一个可能的问题，可按下面的步骤陈述：

1. 描述重现问题的步骤
2. 描述期望输出和实际输出，并说明差异
3. 指出 bug 发生的环境

在 Google Code 中其实给出了非常不错的模版：

```plaintext
What steps will reproduce the problem?

1. ...

2. ...

3. ...

What is the expected output? What do you see instead?

....

What version of the product are you using? On what operating system?

...

Please provide any additional information below. / Please use labels and text to provide additional information.

....
```

上面例子的基本思路就是：

要汇报一个问题，首先描述如何重现问题，其次描述预期效果和实际情况，然后记录 bug 发生时的软件环境如产品版本和操作系统信息等等，最后添加一些你认为需要的额外信息。

对如何重现问题，在 Bugzilla 的实践中，有很好的体现，需要将 bug 产生的各种环境条件（包括软件和硬件的）都记录下来。

---

本文是从[旧站](https://sites.google.com/site/iridiumsite/it/software-test/discribe-a-bug)转移而来。
