# 浅尝二进制文件和文本文件

[Index](index.md)

虽然电脑上的文件本质上都是二进制的，但 Java 还是把流分成了两类：字节流和字符流，两种流的输出，前者亦称为二进制文件，後者则称为文本文件。下面来考察下

## 字节流输出的二进制文件

0. 首先示范 Java 流工具和 Linux ``xxd`` 的使用：

代码片段

``` Java
FileOutputStream fos = new FileOutputStream("binary_output");
DataOutputStream dos = new DataOutputStream(fos);

dos.writeBoolean(false);
dos.close();
```

执行后，通过工具 ``xxd`` 查看：

``` bash
$ xxd -b binary_output 
00000000: 00000000                                     
```

可见，布尔值 ``false`` 一个 byte (8 bits) 存储，所有位皆为0.

1. 再考察 ``true`` 的存储形式：

``` Java
dos.writeBoolean(true);
```

``` bash
$ xxd -b binary_output 
00000000: 00000001        
```

很清楚地看到 ``true`` 也是以一个 byte 来存储的，最后一位为1.

2. 继续考察其他：

```java
dos.write('\n');
```

```bash
$ xxd -b binary_output 
00000000: 00001010                                               .
```

换行符号的 ASCII 码是10, 即二进制数1010. 换行符号也是用一个 byte 来存储的。

1. ``int``

```java
dos.writeInt(3);
```

```bash
$ xxd -b binary_output 
00000000: 00000000 00000000 00000000 00000011          
```

一个 ``int`` 数字，用 4 bytes 存储。

4. ``double``

```java
    dos.writeDouble(3.14);
```

```bash
$ xxd -b binary_output 
00000000: 01000000 00001001 00011110 10111000 01010001 11101011  @...Q.
00000006: 10000101 00011111                             
```

可见，需要8 bytes 才能存储一个 ``double`` 数字。

5. ``float``

```java
    dos.writeFloat(3.14f);
```

```bash
$ xxd -b binary_output 
00000000: 01000000 01001000 11110101 11000011            
```

可见，4 bytes 即可存储一个 ``float`` 数字。
以上浮点数的二进制文件中的存储形式，还需翻下资料才能理解。TODO

6. 汉字

```java
    dos.write('曹');
```

```bash
$ xxd -b binary_output 
00000000: 11111001                                               .
```

(11111001)<sub>2</sub> = (F9)<sub>16</sub>
这里不太理解，汉字``曹``的``UTF-8``编码是66F9，但这里只有後面两位，百思不得其解。TODO

7. 英文字母

```java
dos.write('A');
```

```bash
$ xxd -b binary_output 
00000000: 01000001                                        
```

(01000001)<sub>2</sub> = (41)<sub>16<sub>，即字母``A``的 ``ASCII`` 编码。

8. 以上综合输出

```java
dos.writeBoolean(true);
dos.write('\n');
dos.writeInt(3);
dos.writeDouble(3.14);
dos.writeFloat(3.14f);
dos.write('曹');
dos.write('A');
```

```bash
$ xxd -b binary_output 
00000000: 00000001 00001010 00000000 00000000 00000000 00000011  ......
00000006: 01000000 00001001 00011110 10111000 01010001 11101011  @...Q.
0000000c: 10000101 00011111 01000000 01001000 11110101 11000011  ..@H..
00000012: 11111001 01000001                                      .A
```

## 字符流产生的文本文件

同样的内容，如果存储到文本文件中，再用 ``xxd`` 查看，会得到什么？
保存文本文件：``text.txt``，内容如下：

```plaintext
true
33.143.14f曹A
```

```bash
$ xxd -b text.txt 
00000000: 01110100 01110010 01110101 01100101 00001010 00110011  true.3
00000006: 00110011 00101110 00110001 00110100 00110011 00101110  3.143.
0000000c: 00110001 00110100 01100110 11100110 10011011 10111001  14f...
00000012: 01000001                                                                                                 A
```

很明显，这些内容全部当文本保存成二进制文件了，故曰文本文件。

## 总结

文本文件，是为了对人类可读，多了一个转字符串的中间环节，实际上存到计算机上的都是人类可见的那些“字面量”。比如对布尔型值``true``，二进制文件存它的值，只需要8 bits即可，前面7 bits填0，最後一个 bit 填1即可。而保存为文本文件的话，实际上保存的是"t", "r", "u", "e"这四个字母对应的UTF-8编码的二进制值。

所以，二进制比较省空间，文本文件比较好读。

---

本文最早发布在[OSC](https://my.oschina.net/iridium/blog/841566)上。