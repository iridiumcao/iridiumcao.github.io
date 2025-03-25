# 用 IPFS 发布静态站点

[Index](../index.md)

---

- [用 IPFS 发布静态站点](#用-ipfs-发布静态站点)
  - [1. 安装 IPFS](#1-安装-ipfs)
  - [2. 创建站点](#2-创建站点)
    - [2.1. 准备网站文件](#21-准备网站文件)
    - [2.2. 将网站添加到 IPFS](#22-将网站添加到-ipfs)
    - [2.3 本地测试](#23-本地测试)
  - [3. 公开访问](#3-公开访问)
    - [3.1. 通过公共网关测试](#31-通过公共网关测试)
    - [3.2. 固定内容](#32-固定内容)
  - [4. 更新网站内容](#4-更新网站内容)
    - [4.1. 修改文件](#41-修改文件)
    - [4.2. 重新添加到 IPFS](#42-重新添加到-ipfs)
    - [4.3 使用 IPNS 保持固定地址](#43-使用-ipns-保持固定地址)
    - [4.4. 后续更新](#44-后续更新)
  - [5. 注意事项](#5-注意事项)
    - [5.1. 节点在线](#51-节点在线)
    - [5.2. IPNS 延迟](#52-ipns-延迟)
    - [5.3. 内容可用性](#53-内容可用性)
    - [5.3. 内容可用性](#53-内容可用性-1)

---

我们可以利用 IPFS 发布一个静态站点，本文会介绍一个极简示例，适合想快速学习 IPFS 部署的开发者。思路是把网站直接发布到 IPFS，通过 IPFS 网关地址访问。为了更新后也能继续访问，使用 IPNS 固定访问地址。

## 1. 安装 IPFS

建议直接[安装Kubo](https://docs.ipfs.tech/install/command-line/#install-kubo-windows)，它是 IPFS 的官方命令行版本，本文中用到一些指令需要它支持。

安装后验证版本：

```bash
$ ipfs --version
ipfs version 0.34.0
```

安装后运行初始化（首次使用时需要）：

```bash
$ ipfs init
```

启动 IPFS 守护进程：

```bash
$ ipfs daemon
```

## 2. 创建站点

这里为了演示，创建一个最简单的静态个人站点，本实验的目标是支持更新内容并保持访问地址不变。它包含：

- 两个页面：首页（index.html）和关于页面（about.html）。
- 一个图片（logo.png）。
- 一个 JS 文件（script.js）实现简单交互。

本实验要支持更新内容并保持访问地址不变。

### 2.1. 准备网站文件

在你的电脑上创建一个新的目录，如 `my-website`，然后添加以下文件：

**文件结构**

```plaintext
my-website/
├── index.html
├── about.html
├── logo.png
└── script.js
```

确保文件路径正确，避免后续添加时出错。

**文件内容**

- index.html

```html
<!DOCTYPE html>
<html>
<head>
    <title>My IPFS Website</title>
</head>
<body>
    <h1>Welcome to My Website</h1>
    <img src="logo.png" alt="Logo" width="100">
    <p><a href="about.html">Go to About Page</a></p>
    <button onclick="sayHello()">Click Me</button>
    <script src="script.js"></script>
</body>
</html>
```

- about.html

```html
<!DOCTYPE html>
<html>
<head>
    <title>About Me</title>
</head>
<body>
    <h1>About Me</h1>
    <p>This is a simple website hosted on IPFS.</p>
    <p><a href="index.html">Back to Home</a></p>
</body>
</html>
```

-  script.js

```javascript
function sayHello() {
    alert("Hello from IPFS!");
}
```

- logo.png

下载一个简单的 PNG 图片（比如 100x100 像素的图标），保存为 logo.png。或者用任意图片代替。

### 2.2. 将网站添加到 IPFS

进入 `my-website` 目录，然后添加文件夹到 IPFS：

```bash
$ cd my-website
$ ipfs add -r .
```

输出会列出每个文件的 CID（内容标识符，Content Identifier），最后一行是整个文件夹的根 CID，例如：

```plaintext
ipfs add -r .
added QmY9mabAFA8gzme7vWvS6PdKFpvktewUB9tn32bpFftMUS my-website/about.html
added QmSZa9ctx9CZ7D3iPWfnoDrPm9Hokix35odAsL4qkCHgPB my-website/index.html
added QmNcTkf7PF611dXwfmVtkMjA1tpWBdT77moGKBbhArCgGb my-website/logo.png
added QmSuxkLnJc1zxSaxywsPi2Thb8CWt2WosmZWkjejeXkyG5 my-website/script.js
added QmeRRwTBfzJMFsKv9DyPS9THnAnxqkaVSofRi9dTbjNH4E my-website
```

记下根 CID（这里假设是 QmeRRwTBfzJMFsKv9DyPS9THnAnxqkaVSofRi9dTbjNH4E）。

### 2.3 本地测试

确保 `ipfs daemon` 已运行，在浏览器中访问：<http://localhost:8080/ipfs/QmeRRwTBfzJMFsKv9DyPS9THnAnxqkaVSofRi9dTbjNH4E>

你应该看到首页，点击链接可以跳转到 About 页面，图片显示正常，按钮点击会弹出提示。

## 3. 公开访问

### 3.1. 通过公共网关测试

用公共网关访问：<https://ipfs.io/ipfs/QmeRRwTBfzJMFsKv9DyPS9THnAnxqkaVSofRi9dTbjNH4E>

分享这个链接给别人，他们也能访问你的网站。如果网关无响应，可尝试其他公共网关。

### 3.2. 固定内容

为了确保网站长期可用，在你的节点上固定网站内容：

```bash
ipfs pin add QmeRRwTBfzJMFsKv9DyPS9THnAnxqkaVSofRi9dTbjNH4E
```

## 4. 更新网站内容

假设你想修改内容，比如在 `index.html` 添加一个新段落。

### 4.1. 修改文件

编辑 `index.html`，在 `<button>` 前添加：

```html
<p>This is a new update!</p>
```

### 4.2. 重新添加到 IPFS

再次运行：

```bash
ipfs add -r .
```

得到新的根 CID，比如 `QmSwT81FFFZhRbXLtBKEsVh9ZWjJ3VLQaTQ98hmwmEcjxZ`（因为内容变了，CID 会变）。

### 4.3 使用 IPNS 保持固定地址

IPNS 地址基于你的节点密钥生成，初次使用时会自动创建默认密钥。发布到 IPNS：

```bash
ipfs name publish /ipfs/QmSwT81FFFZhRbXLtBKEsVh9ZWjJ3VLQaTQ98hmwmEcjxZ
```

输出会给你一个 IPNS 地址，比如 `/ipns/k51qzi5uqu5dgbbsqmcree9xbq4f8vpd9rj5x3fle21h24oqw8aovmz8tcjti4`，这是基于你节点密钥生成的固定地址。

测试访问：<http://localhost:8080/ipns/k51qzi5uqu5dgbbsqmcree9xbq4f8vpd9rj5x3fle21h24oqw8aovmz8tcjti4> 或 <https://ipfs.io/ipns/k51qzi5uqu5dgbbsqmcree9xbq4f8vpd9rj5x3fle21h24oqw8aovmz8tcjti4>

### 4.4. 后续更新

每次修改后重复 `ipfs add` 和 `ipfs name publish`，IPNS 地址不变，但指向最新内容。


## 5. 注意事项

### 5.1. 节点在线

你的节点需定期在线刷新 IPNS 记录（每天一次，执行 `ipfs name publish`）。如果不方便，可以用 Pinning 服务（如 Pinata）托管内容和 IPNS。

### 5.2. IPNS 延迟

更新后解析可能有几秒到几分钟延迟，适合非实时更新的场景。

### 5.3. 内容可用性

如果你的节点下线，靠公共网关或他人缓存访问，建议固定(`ipfs pin`)内容。

### 5.3. 内容可用性

如果你的节点下线，网站内容依赖公共网关或他人缓存访问，建议固定（`ipfs pin`）内容。可以用以下命令检查哪些节点提供了该内容：

```bash
ipfs routing findprovs <CID>
```