# 📖 Git 保姆级实验教程——前言

[首页🏠](index.md) - [下一章⇨](01.md)

---

这些年看过好些 git 资料，各有各的好，但总觉得差那么点意思，或太浅，或太深，或太零散，就想到自己写一套全系列教程帮助理解。

本教程计划由浅入深，全面介绍 git 的方方面面，把自己对 git 的全部理解按章节全部讲完，让菜鸟可以学会，老鸟亦有收获。学习 git 的方法，是不断做实验，在实践中感悟。

教程的章节是按 git 的知识结构来设计的。每章的默认内容是最基本的，git 用户必须掌握，进阶内容不是必须的，但对高效使用 git 有帮助。

## 阅读建议

不同的用户，根据个人的情况和目标，阅读合适的内容即可。本教程无需用户了解任何前置的专业知识，但如果对「SSH 登录」和 vi/vim 有一定经验，将会有更好的体验。

### 菜鸟

如果只是基本使用，看看前十章的基础内容差不多够用了，不会的再去搜即可。

如果想要熟练使用，全部教程建议读两遍，边读边做实验。
第一遍，阅读基本内容就可以了，不需要读「进阶」的内容，或者不要花太多时间在「进阶」上。
第二遍，阅读进阶内容。每章的「进阶」部分，可能和当前章节之后的内容有联系，也可能是基本内容的一些扩展，第一遍阅读时可以先跳过，待读完全部教程的基础部分之后，再过来看更有收获。

### 老鸟

不必讲究阅读顺序，挑感兴趣的内容看阅读即可。

## 写作说明

本教程用 VS Code 写作，使用 [All-in-one 的 markdown 插件](https://marketplace.visualstudio.com/items?itemName=yzhang.markdown-all-in-one)，绘图使用 [drawio 插件](https://marketplace.visualstudio.com/items?itemName=hediet.vscode-drawio)。

本教程托管在 GitHub，点击每个页面右下角的 "Improve this page" 即可进入 GitHub 修改编辑。

本教程的版本管理使用 git, GUI 工具是[Git Extentions](16.md).

### 术语说明

术语的引入，有的翻译后引入，有的直接引入，但无论哪种方式，引入后其实还可能有词义的变化。

**commit**

这是 git 的一个核心词汇，因为语言的差异，导致它的含义在不同语境下出现差异。

英语语境。"commit" 表示将缓存区的内容「提交」到仓库，是一个动词。「提交」的结果用 "revision" (版本)来表示。

汉语语境。"commit" 不但表示「提交」的动作，还表示提交的结果。汉语里直接引入了英语外来词 "commit" 并赋予它新的含义。本教程中前面几章因为还没介绍「提交」这个操作，就用「版本」来对应 "revision".

我们可以通过上下文去理解这些它的具体含义。如果有的描述让你困惑，请告诉我，我再修改。

**revision**

汉语资料中几乎没有引入这个词，有的用 "patch" 来表示 "revision", 虽然不影响理解，但看起来很奇怪。本教程也没有引入这个词。

**command**

本教程多译作「指令」，但 "command line" 译作「命令行」而不是「指令列」，纯个人取向而已。

## 反馈

这是本人第一次大篇幅比较系统的知识整理，非常欢迎你的反馈，反馈渠道：

* Email: iridiumcao@gmail.com
* Issues: <https://github.com/iridiumcao/iridiumcao.github.io/issues>
* 或直接提交 PR

## 免费声明

本文档免费，因为 git 本身开源免费。向 BitKeeper 和 Linus Torvalds 致敬。

## License

<p xmlns:cc="http://creativecommons.org/ns#" >This work is licensed under <a href="http://creativecommons.org/licenses/by-sa/4.0/?ref=chooser-v1" target="_blank" rel="license noopener noreferrer" style="display:inline-block;">CC BY-SA 4.0<img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/cc.svg?ref=chooser-v1"><img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/by.svg?ref=chooser-v1"><img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/sa.svg?ref=chooser-v1"></a></p>

---

[首页🏠](index.md) - [下一章⇨](01.md)
