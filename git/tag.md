# git 的两种 tag 的平行对比实验

[Index](index.md)

按：写作本文时查阅了一些资料，也做了一些实验，但有好些只是个人的理解，可能有误。

git 的 tag 分两种：

* 轻量 tag (lightweight tag)：可以看着是一个 commit 的引用或别名，仅此而已。
* 标记 tag (annotated tag)：除了轻量 tag 的内容，它还包含 tag 创建时的一些信息：创建时间，创建者的 email，备注（类似 commit 的 comment）
  * annotated tag 似乎有好些中文译名：标记，标注，附注

官方的说法如下：

> Tag objects (created with -a, -s, or -u) are called "annotated" tags; they contain a creation date, the tagger name and e-mail, a tagging message, and an optional GnuPG signature. Whereas a "lightweight" tag is simply a name for an object (usually a commit object).
>
> Annotated tags are meant for release while lightweight tags are meant for private or temporary object labels. For this reason, some git commands for naming objects (like git describe) will ignore lightweight tags by default.
>
> [Ref](https://git-scm.com/docs/git-tag)

## 实验

### 1. 创建 tag

* 创建一个轻量 tag: `git tag test-only-lightweight`
* 创建一个标记 tag: `git tag -a "test-only-annotated" -m "test tag: annotated"`

### 2. 查看 tag

按 tag 名查找：

```plaintext
$ git tag --list "test-only*"
test-only-annotated
test-only-lightweight
```

上面也可以变通地使用命令：

```plaintext
$ git tag --list | grep "test-only"
```

查看 tag 的元信息：

```plaintext
$ git show test-only-annotated
tag test-only-annotated
Tagger: Cao Yi <iridiumcao@gmail.com>
Date:   Tue Nov 7 10:35:56 2023 +0800

test tag: annotated

（以上是该 tag 的相关信息展示，后面向接的就是 commit 的常规信息，这里省略）

```

但 `git show test-only-lightweight` 可以看出：没有和该 tag 有关的任何信息，这看起来符合前面提到的——tag 只是个别名而已。

### 3. Push to Remote

```plaintext
$ git push origin refs/tags/test-only-lightweight
$ git push origin refs/tags/test-only-annotated
```

这里我用了完整的 tag 路径 `refs/tags/name`，是为了避免 tag 和 branch 同名时用短名无法推送的问题。如果没有同名的情况，可以使用下面的简便方式：

```plaintext
$ git push origin test-only-lightweight
$ git push origin test-only-annotated
```

### 4. 查看远端的 tag

前面使用 `git tag` 可以查看本地的 tag，远端我们使用下面的方式：

```plaintext
$ git ls-remote --tags ssh://git@192.168.5.67:2222/hello/world.git | grep "test-only"
```

如果执行命令的当前目录就是这个远程库对应的本地库，则远程库的地址可以省略，如下：

```plaintext
$ git ls-remote --tags | grep "test-only"
From ssh://git@192.168.5.67:2222/hello/world.git
65aef7ff2efdfe73253238b388513da62ad8060b        refs/tags/test-only-annotated
85084db2c79b1a18f5b3e836cc5656d97fa098c0        refs/tags/test-only-annotated^{}
85084db2c79b1a18f5b3e836cc5656d97fa098c0        refs/tags/test-only-lightweight
```

注意，标记 tag 有两条记录，其中以 `^{}` 结尾的记录的 ID 和轻量 tag 是一样的，说明标记 tag 在 git 中实际上由两条记录构成：

1. 以 `^{}` 结尾的记录，和轻量 tag 等同，但无法通过 `git tag` 列出，默认对用户隐藏，不过可以通过 `git ls-remote --tags` 列出。
2. 无特殊标记的记录，记录该标记 tag 的元信息，即：创建者，创建时间，说明等。

我们通过观察 tag 在远端有几条记录来确认它是轻量 tag 还是标记 tag.

### 5. 删除远端的 tag

可以使用完整的路径删除:

```plaintext
$ git push origin --delete refs/tags/test-only-lightweight
$ git push origin --delete refs/tags/test-only-annotated
```

当 tag 和 branch 名称不会混淆时，可以用简便的方式：

```plaintext
$ git push origin --delete test-only-lightweight
$ git push origin --delete test-only-annotated
```

注意，删除标记 tag 时，不要使用带 `^{}` 的标签名，下面一条错误的示例：

```plaintext
$ git push origin --delete refs/tags/hello^{}
fatal: invalid refspec ':refs/tags/hello^{}'
```

### 6. 删除本地的 tag

可以分别删除，也可以一起删除

```plaintext
$ git tag --delete test-only-annotated test-only-lightweight
```