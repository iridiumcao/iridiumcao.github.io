# Bash 条件表达式（Bash Conditional Expressions）

[Index](../index.md)

---

- [Bash 条件表达式（Bash Conditional Expressions）](#bash-条件表达式bash-conditional-expressions)
  - [文件比较](#文件比较)
  - [字符串比较](#字符串比较)
  - [数值比较](#数值比较)
  - [其他](#其他)

---

按：这篇文章是很早之前发布在个人 Google Site 上的，已经不知具体时间了。在转移到本地时，有少许更新。

Bash 条件表达式分三类：文件，文本（字符串），数值。

## 文件比较

先看一个例子：判断文件是否存在？

```shell
#!/bin/bash

if [ -e helloworld.sh ]
then
   echo "helloworld.sh exists!"
else
   echo "helloworld.sh does not exist!"
fi
```

这里用到的操作符是 `-e`

关于文件的操作符，主要都是一元操作符，也有几个二元的，详见下表

| 操作符 |  示例             |  说明                                                                                                        |
|--------|-------------------|--------------------------------------------------------------------------------------------------------------|
|  -a    |  -a file          |  True if file exists.                                                                                        |
|  -b    |  -b file          |  True if file exists and is a block special file. *[1]                                                       |
|  -c    |  -c file          |  True if file exists and is a character special file. *[1]                                                   |
|  -d    |  -d file          |  True if file exists and is a directory.                                                                     |
|  -e    |  -e file          |  True if file exists.                                                                                        |
|  -f    |  -f file          |  True if file exists and is a regular file. *[2]                                                             |
|  -g    |  -g file          |  True if file exists and its set-group-id bit is set.                                                        |
|  -h    |  -h file          |  True if file exists and is a symbolic link.                                                                 |
|  -k    |  -k file          |  True if file exists and its "sticky" bit is set.                                                            |
|  -p    |  -p file          |  True if file exists and is named pipe (FIFO).                                                               |
|  -r    |  -r file          |  True if file exists and is readable.                                                                        |
|  -s    |  -s file          |  True if file exists and has a size greater than zero.                                                       |
|  -t    |  -t fd            |  True if file descriptor fd is open and refers to a terminal.                                                |
|  -u    |  -u file          |  True if file exists and is writable.                                                                        |
|  -x    |  -x file          |  True if file exists and is executable.                                                                      |
|  -G    |  -G file          |  True if file exists and is owned by the effective group id.                                                 |
|  -L    |  -L file          |  True if file exists and is a symbolic link.                                                                 |
|  -N    |  -N file          |  True if file exists and has been modified since it was last read.                                           |
|  -O    |  -O file          |  True if file exists and is owned by the effective user id.                                                  |
|  -S    |  -S file          |  True if file exists and is a socket.                                                                        |
|  -ef   |   file1 -ef file2 |  True if file1 and file2 refer to the same device and inode numbers.                                         |
|  -nt   |   file1 -nt file2 |  True if file1 is newer (according to modification date) than file2 , or if file1 exists and file2 does not. |
|  -ot   |   file1 -ot file2 |  True if file1 is older than file2 , or if file2 exists and file1 does not.                                  |

Linux 上的文件类型主要有下面几种：

- block special file, 块设备：如果一个设备是随机（无序的）访问的，那么它就属于块设备。如：硬盘，光驱，U盘。
- character special file, 字符设备：如果一个硬件设备是以字符流的方式被访问的话，那就应该将它归于字符设备。如：键盘。(ref: <http://blog.itpub.net/10522540/viewspace-198228>)
- regular file, regular 的意思就是不是 device file, 不是 socket, 不是 pipe, 不是……剩下的就是 regular file，比如一个text 文件，一个可执行文件，一个图片……等等。(by sakulagi from <http://bbs.chinaunix.net/thread-2251937-1-1.html>)

## 字符串比较

| 操作符 |  示例                 |  说明                                                                                           |
|--------|-------------------|----------------------------------------------------------------------------------------------------|
| -z     |  -z string           |  True if the length of string is zero.                                                          |
|  -n    |  -n string           |  True if the length of string is non-zero.                                                      |
|        |   string             |  True if the length of string is non-zero.                                                      |
|  =     |   string1 = string2  |  True if the strings are equal. ‘=’ should be used with the test command for POSIX conformance. |
|  ==    |   string1 == string2 |  True if the strings are equal.                                                                 |
|  !=    |   string1 != string2 |  True if the strings are not equal.                                                             |
|  <     |   string1 < string2  |  True if string1 sorts before string2 lexicographically.                                        |
|  >     |   string1 > string2  |  True if string1 sorts after string2 lexicographically.                                         |

## 数值比较

Bash 仅支持整数（正数，负数和0）。数值相关的条件操作符，都是二元操作符，列表如下：

| 操作符 |  等效操作符 |  示例           |  说明                                            |
|--------|-------------|-----------------|--------------------------------------------------|
|  -eq   |  = or ==    |   arg1 -eq arg2 |  True if arg1 is equal to arg2 .                 |
|  -ne   |  !=         |   arg1 -ne arg2 |  True if arg1 is not equal to arg2 .             |
|  -lt   |  <          |   arg1 -lt arg2 |  True if arg1 is less than arg2 .                |
|  -le   |  <=         |   arg1 -le arg2 |  True if arg1 is less than or equal to arg2 .    |
|  -gt   |  >          |   arg1 -gt arg2 |  True if arg1 is greater than arg2 .             |
|  -ge   |  >=         |   arg1 -ge arg2 |  Ture if arg1 is greater than or equal to arg2 . |

注意在使用上表第二列等效的操作符时，符号两边的数字要有空格。

## 其他

|  操作符 |  示例       |  说明                                                                                                                                                   |  说明                                |
|---------|-------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------|
|  -o     |  -o optname |  True if the shell option optname is enabled. The list of options appears in the description of the -o option to the set builtin (see The Set Builtin). |  True if arg1 is equal to arg2.     |
|  -v     |  -v varname |  True if the shell variable varname is set (has been assigned a value).                                                                                 |  True if arg1 is not equal to arg2. |

参 <http://www.gnu.org/software/bash/manual/bashref.html#Bash-Conditional-Expressions>
