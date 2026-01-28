# core.ignoreCase

[Index](index.md)

默认情况下，Mac 和 Windows 对文件名的大小写不敏感，而 Linux 则是敏感的。这意味着，如果在 Linux 上创建了只是大小写不同的同名目录或文件，那么在 Mac 和 Windows 上使用时可能会出现问题。

要解决这个问题，可以明确地设置对大小写不敏感。只需要在 git repo 中执行以下命令即可：

```plaintext
$ git config core.ignoreCase true
```

或者在任意位置执行

```plaintext
$ git config --global core.ignoreCase true
```

这样就可以避免创建同名但大小写不一致的目录或文件。

需要注意的是，这个设置对用作服务端的裸库(bare)没有效果，对 Windows 用户是多余的，只对 Linux 上的普通仓库有效。

## 案例

* 服务端 Host S: Linux
* 开发用机 Client A: Windows
* 开发用机 Client B: Linux

### 1. 未设置 `core.ignoreCase true`

如果没有设置 `core.ignoreCase true`，那么对大小写的敏感性将取决于操作系统。

举个例子，我们通过 Client B 在 Linux 上创建了两个文件 *Hello* 和 *heLLO*，然后将它们 `push` 到 Host S。接着，在 Client A 上执行 `pull` 操作，由于 Windows 本身的限制，可能只能得到一个 *Hello* 或 *heLLO* 文件。在执行 `git status` 时，会发现只有一个文件，并且它有未提交的变化。这是因为 Windows 不支持只是大小写不同的文件名，所以在 `pull` 后，得到的两个文件只能用一个覆盖另一个。

### 2. 设置 `core.ignoreCase true` 后

经过设置，使用 Linux 的 Client B 对大小写也不敏感了，所有的开发用机都不会生成同名但大小写不一致的文件。问题得解。

## 处理历史遗留问题

但如果已经大小写名称混乱，我们应该怎么处理？

### 方法一 `git mv`

最优方法。

在《Git 实验教程》的[第十五章](15.md)有详细的说明。

### 方法二

垃圾方法。

可以先登录 Linux 机器，处理好了，push，再到 Windows 机器上删除相关目录和文件，重新从远程获取，或者干脆在 Windows 主机上重新 clone 一次仓库就好。

### 方法三

垃圾方法。

还有 Windows 上辗转腾挪大法。具体用下面的步骤将 hello.txt 改成 Hello.txt

1. hello.txt -> hello.txt.tmp
2. `git add` + `git commit`
3. hello.txt.tmp -> Hello.txt
4. `git add` + `git commit`
5. squash the last 2 revisions

<script src="https://giscus.app/client.js"
        data-repo="iridiumcao/iridiumcao.github.io"
        data-repo-id="MDEwOlJlcG9zaXRvcnkyOTUwNTIyODQ="
        data-category="Announcements"
        data-category-id="DIC_kwDOEZYj_M4Cxfqj"
        data-mapping="pathname"
        data-strict="0"
        data-reactions-enabled="1"
        data-emit-metadata="0"
        data-input-position="bottom"
        data-theme="preferred_color_scheme"
        data-lang="zh-CN"
        crossorigin="anonymous"
        async>
</script>