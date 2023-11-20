# core.ignorecase

[Index](index.md)

Mac 和 Windows 默认对文件名大小写不敏感，但 Linux 敏感。
如果在 Linux 上创建只是大小写不相同的同名目录或文件，Mac 和 Windows 可能会无法正常使用。

解决办法是，都明确设置对大小写不敏感，在 git repo 里执行下面语句即可：

```bash
git config core.ignorecase true
```

或者在任意位置执行

```bash
git config --global core.ignorecase true
```

也行。这样就可以避免创建同名但大小写不一致的目录或文档。

这个设置对用作服务端的 bare 库没有效果，只能在开发人员的各自工作区设置。

## 案例

* 服务端 Host S: Linux
* 开发用机 Client A: Windows
* 开发用机 Client B: Linux

### 1. 未设置 `core.ignorecase true`

此时对大小写是否敏感，是依赖操作系统的。

我们通过 Client B 创建两个文件 *Hello* 和 *heLLO* 并 `push` 到 Host S。再在 Client A 上执行 `pull` 操作，因为操作系统本身的限制，自然不能同时得到 *Hello* 和 *heLLO*，这时，可能出现的情况是，git 提示 `pull` 成功，但文件只有一个。再执行 `git status` 观察，发现有只有一个叫 *Hello* 或 *heLLO* 的文件，而且它有未提交的变化。这是因为 Windows 不支持只是大小写不同名的文件，那 `pull` 后得到的两个文件要放到工作区，只能用一个覆盖另一个，这就有了前面的情况。

### 2. 设置 `core.ignorecase true` 后

经过设置，Linux host B 也对大小写也不敏感了，所有的开发用机都不再生成同名但大小写不一致的文件。问题得解。
