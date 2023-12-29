# `git pull` 的参数

[Index](index.md)

如果 git 不设置 pull 参数，可能出现的状况是什么？

答：如果使用的是 git version 2.27.0，则会提示用户对 `pull` 的默认操作进行设置，一共有三个选项。示例如下

```plaintext
$ git pull origin master 
warning: 不建议在没有为偏离分支指定合并策略时执行 pull 操作。 您可以在执行下一次
pull 操作之前执行下面一条命令来抑制本消息：

  git config pull.rebase false  # 合并（缺省策略）
  git config pull.rebase true   # 变基
  git config pull.ff only       # 仅快进

您可以将 "git config" 替换为 "git config --global" 以便为所有仓库设置
缺省的配置项。您也可以在每次执行 pull 命令时添加 --rebase、--no-rebase，
或者 --ff-only 参数覆盖缺省设置。

来自 github.com:iridiumcao/blog
 * branch            master     -> FETCH_HEAD
已经是最新的。
```

## 配置说明

1. `pull.rebase` 执行 `git pull` 时使用是否变基（rebase）
   * `false`：如果远程分支有新的 commit, 则本地创建一个新的合并提交，将远程分支的变化合并到本地分支上。
   * `true`：如果远程分支有新的 commit, 则将本地的提交放到远程分支的最新提交之后，使得提交历史更加线性，不会产生额外的合并提交。
2. `pull.ff`
   * `false`: create an extra merge commit in such a case (equivalent to giving the `--no-ff` option from the command line)
   * `only`：这个命令告诉Git在执行git pull命令时只允许快进（fast-forward）合并，等价于 `--ff-only`.如果远程分支能够直接合并到本地分支而不产生新的提交，就会执行快进合并；否则，会出现合并冲突的情况。
   * 不设置，就相当于 `-ff`，没有分叉，就 fast-forward, 有分叉，就生成合并 commit

下面是来自官方文档的内容

pull.rebase

> When true, rebase branches on top of the fetched branch, instead of merging the default branch from the default remote when "git pull" is run. See "branch.<name>.rebase" for setting this on a per-branch basis.
>
> When `merges` (or just `m`), pass the `--rebase-merges` option to git rebase so that the local merge commits are included in the rebase (see [git-rebase](https://git-scm.com/docs/git-rebase) for details).
>
> When the value is `interactive` (or just `i`), the rebase is run in interactive mode.
>
> **NOTE**: this is a possibly dangerous operation; do not use it unless you understand the implications (see [git-rebase](https://git-scm.com/docs/git-rebase) for details).

pull.ff

> By default, Git does not create an extra merge commit when merging a commit that is a descendant of the current commit. Instead, the tip of the current branch is fast-forwarded. When set to `false`, this variable tells Git to create an extra merge commit in such a case (equivalent to giving the `--no-ff` option from the command line). When set to `only`, only such fast-forward merges are allowed (equivalent to giving the `--ff-only` option from the command line). This setting overrides `merge.ff` when pulling.

(Ref: <https://git-scm.com/docs/git-config>)