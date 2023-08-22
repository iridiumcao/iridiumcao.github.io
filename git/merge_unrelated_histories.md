# 合并不同的仓库

[Index](index.md)

将两个独立的仓库合并成一个仓库并保留两个库的历史。

假设这两个需要合并的仓库是 `aaa.git` 和 `bbb.git`，不妨假设它们都创建在你的 github 账号下。

这里把 `bbb.git` 的 `master` 合并到 `aaa.git` 的 `master`.

## 1. 添加源

给一个仓库添加另一个仓库的源

不妨进入 `aaa.git` 目录，把 `bbb.git` 作为另一个源添加进来

```plaintext
$ git remote add bbb git@github.com:your_account_id/bbb.git
```

这时可以看到当前仓库有个两个源

```plaintext
$ git remote -v
origin  git@github.com:your_account_id/aaa.git (fetch)
origin  git@github.com:your_account_id/aaa.git (push)
bbb  git@github.com:your_account_id/bbb.git (fetch)
bbb  git@github.com:your_account_id/bbb.git (push)
```

## 2. 准备分支

两个仓库都有 `master` 分支，不能直接把 `bbb.git` 的 `master` 直接 pull 下来。

这里可以考虑按如下顺序处理：

1. 重命名本地的 `master`

将 `aaa.git` 的 `master` 临时改名为 `master-aaa`

```plaintext
$ git branch --move master-aaa
```

2. pull `bbb.git` 的 `master`

```plaintext
$ git pull
$ git checkout --track bbb/master
```

3. 重命名 `master`

将 `bbb.git` 的 `master` 临时改名为 `master-bbb`, 将 `aaa.git` 的 `master-aaa` 改回 `master`

```plaintext
$ git branch --move master-bbb
$ git checkout master-aaa
$ git branch --move master
```

## 3. 合并

前面都是铺垫，现在才是关键。

```plaintext
$ git checkout master
$ git merge bbb --no-ff
fatal: refusing to merge unrelated histories
```

不出意外，报错了。`fatal: refusing to merge unrelated histories` 错误意味着正在尝试合并两个没有共同祖先的分支，默认情况下git是不允许的。
怎么处理？使用参数 `--allow-unrelated-histories`

```plaintext
$ git merge python --no-ff --allow-unrelated-histories
Auto-merging .gitignore
CONFLICT (add/add): Merge conflict in .gitignore
Automatic merge failed; fix conflicts and then commit the result.
...
```

上面解决代码冲突的内容这里就不多贴了。

完工。
