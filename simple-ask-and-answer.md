# 简单问答

## 23个汉语普通话声母中有哪些是平舌音？

答：除了 zh, ch, sh, r，其余的都是平舌音。

参百度知道的问答：https://zhidao.baidu.com/question/297637256.html

## 何为灰犀牛？

比喻大概率且影响巨大的潜在危机。

歇爾·渥克的《灰犀牛：如何應對大概率危機》

## 何为黑天鹅？

比喻小概率而影响巨大的事件。

## 在哪里可以找一些常用的英文名？

可以在[disney.com](https://family.disney.com/baby-names/english-names/)找找看，不但有英文的，还有其他语言的。

## 如果 git 不设置 pull 参数，可能出现的状况是什么？

答：如果使用的是 git version 2.27.0，则会提示用户对 pull 的默认操作进行设置，一共有三个选项。示例如下

```
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

## What's VO or PO?

VO, value object, PO, persistence object.
PO maps a record of a table in database, in another word, it maps the metadata of a table.
VO maps values of an object which presented to end user, e.g., we can use a VO object to against a GUI face.
