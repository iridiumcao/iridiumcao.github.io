# 交换两数

已知两数a 和 b，交换它们的值，是在学 C 语言赋值操作时讲到的一个问题。它算是比 HelloWorld 复杂一点的问题，解法有很多。

## 1. 通过中间变量交换

伪码如下：

```javascript
tmp = a;
a = b;
b = tmp;
```

## 2. 不通过中间变量交换

如果是数值类型，还可以不通过中间变量交换两数，伪码如下：

```javascript
a = a + b;
b = a - b;
a = a - b;
```

更进一步，如果是整型变量，还可以通过位运算来完成交换两数的交换，伪码如下：

```javascript
a ^= b;
b ^= a;
a ^= b;
```

参：

1. [代码](http://git.oschina.net/iridiumcao/iridiumonline/blob/master/helloalgorithm/src/main/java/org/iridium/algorithm/basic/ExchangeTwoValues.java)
2. [如何交換兩個變數，而不動用第三個變數? (C/C++) (C) (.NET) (C#) ](http://www.cnblogs.com/oomusou/archive/2007/09/09/887337.html)
3. [经典算法——不用第三变量交换两数](http://blog.sina.com.cn/s/blog_438414c901009pwc.html)