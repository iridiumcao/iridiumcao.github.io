# core.ignorecase

[Index](index.md)

默认情况下，Mac 和 Windows 对文件名的大小写不敏感，而 Linux 则是敏感的。这意味着，如果在 Linux 上创建了只是大小写不同的同名目录或文件，那么在 Mac 和 Windows 上使用时可能会出现问题。

要解决这个问题，可以明确地设置对大小写不敏感。只需要在 git repo 中执行以下命令即可：

```bash
git config core.ignorecase true
```

或者在任意位置执行

```bash
git config --global core.ignorecase true
```

这样就可以避免创建同名但大小写不一致的目录或文件。

需要注意的是，这个设置对用作服务端的 bare 库没有效果，只能在开发人员的各自工作区设置。

## 案例

* 服务端 Host S: Linux
* 开发用机 Client A: Windows
* 开发用机 Client B: Linux

### 1. 未设置 `core.ignorecase true`

如果没有设置 `core.ignorecase true`，那么对大小写的敏感性将取决于操作系统。

举个例子，我们通过 Client B 在 Linux 上创建了两个文件 *Hello* 和 *heLLO*，然后将它们 `push` 到 Host S。接着，在 Client A 上执行 `pull` 操作，由于 Windows 本身的限制，可能只能得到一个 *Hello* 或 *heLLO* 文件。在执行 `git status` 时，可能会发现只有一个文件，并且它有未提交的变化。这是因为 Windows 不支持只是大小写不同的文件名，所以在 `pull` 后，得到的两个文件只能用一个覆盖另一个。

### 2. 设置 `core.ignorecase true` 后

经过设置，Linux 主机 B 对大小写也不敏感了，所有的开发用机都不会生成同名但大小写不一致的文件。问题得到了解决。
