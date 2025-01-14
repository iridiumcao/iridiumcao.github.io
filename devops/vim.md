# VIM 笔记

[Index](index.md)

按：这篇文章是很早之前发布在个人 Google Site 上的，已经不知具体时间了。在转移到本地时，有少许更新。

VIM 是 [VI](vi.md) 的改进版，即 Vi IMproved. 这里记录一些自己在使用过程中碰到的情况。

在当前的的一些常用 Linux 发行版，如 CentOS, 在 Shell 中键入 `vi` 启动的编辑器，仍然是 VIM, 这点可以在编辑器启动后使用 `:help` 查看到。

## VIM 的列编辑

VIM 也是有列编辑功能的，这个在 notepad++ 中称为[「列模式编辑」](https://npp-user-manual.org/docs/editing/)。它具体是如此操作的：

1. `Ctrl + v` 进入 Visual Block 模式
2. 将光标移动到需要编辑的块的第一行行首
3. 按 `j` 选择需要连续编辑的行
4. 按 `Shift + i` 即大写的 `I` 进入编辑模式，注意这里，用 `I` 不是 `i`
5. 光标在第一行闪烁，编辑内容，只能看到第一行有效果，其他行其实也是有效果的，只是没显示而已
6. 按两次 ESC 退出，编辑生效

注：对以上2, 3两步，说的从第一行往下选，实际上往上往下都是可以的。

## TOhtml

将当前的代码，按屏幕的高亮设置转化为 html。

用法 `:TOhtml` 或 `:m,nTOhtml`

如：

```shell
#!/bin/bash

function hello() {
 echo "Hello, world!"
}

hello
```

以上对应的 html 代码是：

```html
<font color="#8080ff">#!/bin/bash</font><br>
<font color="#00ffff">function</font>&nbsp;<font color="#00ffff">hello() {</font><br>
&nbsp;<font color="#ffff00">echo</font><font color="#ff6060">&nbsp;</font><font color="#ffff00">&quot;</font><font color="#ff6060">Hello, world!</font><font color="#ffff00">&quot;</font><br>
<font color="#00ffff">}</font><br>
<br>
hello<br>
```

可以看出，通过 TOhtml 生成的页面代码，主要使用 <font> 方式来定义样式，这种方式已经不流行了，但生成的代码方便拷贝。

更新，这个指令不知何时升级了，现在（2025.01.14）执行后的记过是：

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>~/sandbox/temp/hello.sh.html</title>
<meta name="Generator" content="Vim/9.1">
<meta name="plugin-version" content="vim9.0_v2">
<meta name="syntax" content="bash">
<meta name="settings" content="use_css,no_foldcolumn,pre_wrap,prevent_copy=,use_input_for_pc=none">
<meta name="colorscheme" content="none">
<style>
<!--
pre { white-space: pre-wrap; font-family: monospace; color: #ffffff; background-color: #000000; }
body { font-family: monospace; color: #ffffff; background-color: #000000; }
* { font-size: 1em; }
.Comment { color: #00ffff; font-weight: bold; }
.Identifier { color: #00ffff; font-weight: bold; }
.Statement { color: #ffff00; font-weight: bold; }
.Constant { color: #ff40ff; font-weight: bold; }
-->
</style>
</head>
<body>
<pre id='vimCodeElement'>
<span class="Comment">#!/bin/bash</span>

<span class="Identifier">function</span> <span class="Identifier">hello() {</span>
 <span class="Statement">echo</span><span class="Constant"> </span><span class="Statement">&quot;</span><span class="Constant">Hello, world!</span><span class="Statement">&quot;</span>
<span class="Identifier">}</span>

hello

</pre>
</body>
</html>
<!-- vim: set foldmethod=manual : -->
```
