# Git Commit 中的时间记录

[Index](index.md)

git 本身作为一个代码版本管理工具，所有的提交记录都有相应的时间，这是自然，也是必须。

一个 commit 可能作者(author)是张三，但 push 到远程仓库的人(committer)可能是李四。对应地，就涉及两个时间概念：

* author date. 张三创建该 commit 的时间
* commit date. 李四 push 代码到远程仓库的时间

## 查看时间

查看最后一条 commit 的时间信息

```bash
$ git log -1 --pretty=format:"Author: %an <%ae>,  %ad | Committer: %cn <%ce>, %cd"
Author: Alice <alice@hello.world>,  Mon Oct 30 14:05:27 2023 +0800 | Committer: Bob <bob@hello.world>, Mon Nov 13 14:28:43 2023 -0500
```

查看某个指定的 commit 的时间信息

```bash
$ git show -s --format="Author: %an <%ae>,  %ad | Committer: %cn <%ce>, %cd" c6664a
Author: Alice <alice@hello.world>,  Tue Jan 4 11:49:27 2022 +0800 | Committer: Bob <bob@hello.world>, Tue Jan 11 17:17:06 2022 -0500
```

查看某个 branch 的最后一条 commit 的时间信息

```bash
$ git show -s --format="Author: %an <%ae>,  %ad | Committer: %cn <%ce>, %cd"   12345-test-branch
Author: Alice <alice@hello.world>,  Fri Feb 25 13:46:51 2022 +0800 | Committer: Alice <alice@hello.world>, Fri Feb 25 13:46:51 2022 +0800
```

时间格式 %i 和 %d 有所不同，下面的例子以示区别：

```bash
$ git show -s --format=%ai c6664a
2022-01-04 11:49:27 +0800

$ git show -s --format=%ad c6664a
Tue Jan 4 11:49:27 2022 +0800
```

## 更新时间

我们可以用如下命令修改时间，这些命令不能指定修改 Author date 或 Committer date, 它会把两个时间一并修改为当前时间。

```bash
# Update the last git commit to current time
git commit --amend --date=now
git commit --amend --date=now --no-edit
git commit --amend --no-edit --date "$(date)"
git commit --amend --no-edit --date "$(date -R)"

```

---

Ref

* [How can one change the timestamp of an old commit in Git?](https://stackoverflow.com/questions/454734/how-can-one-change-the-timestamp-of-an-old-commit-in-git) (stackoverflow.com)
* [Update git commit author date when amending](https://stackoverflow.com/questions/9110310/update-git-commit-author-date-when-amending) (stackoverflow.com)
* [Git commit date](https://stackoverflow.com/questions/3814926/git-commit-date) (stackoverflow.com)
