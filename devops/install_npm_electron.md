# 东大网络环境下安装 Electron 的解决方案

[Index](index.md)

前些天我写了[东大拯救 NPM 指南之代理设置](npm_proxy.md)以为只要设置了代理，就能顺利使用 npm 安装使用一切 node package 了，昨天装 Electron 时却被狠狠打了脸。本篇不使用代理，因为使用代理解决不了问题。本篇使用国内阿里云的 npm 镜像。

本文基于 Node.js v22.14.0 和 npm v10.8.3 测试，其他版本可能需稍作调整。

## 问题描述

因为使用代理安装已经失败了，所以我尝试了取消代理并设置阿里云镜像

```powershell
npm config delete proxy
npm config delete https-proxy
npm config set registry https://registry.npmmirror.com
npm config get registry  # 验证返回 https://registry.npmmirror.com
```

然后安装 `electron`：

```powershell
npm install electron --save-dev --verbose
```

没想到还是一直卡住转圈圈，最后还报了个退出码 3221225786（Windows 的崩溃代码）。日志里是这样的：

```plaintext
382 info run electron@35.1.2 postinstall node_modules/electron node install.js
383 info run electron@35.1.2 postinstall { code: 3221225786, signal: null }
```

问题出在 **Electron 二进制包下载阶段** (`node install.js`)，它要去 GitHub 下东西，但网络环境太好了，根本下不动。加上我用了阿里云镜像，结果发现它有些安全审计接口（`/v1/security/audits`）压根没实现，报 404：

```plaintext
378 verbose audit error HttpErrorGeneral: 404 Not Found - POST https://registry.npmmirror.com/-/npm/v1/security/audits/quick - [NOT_IMPLEMENTED] /-/npm/v1/security/* not implemented yet
```

详细日志参：[full log](install_npm_electron_log.txt)

## 解决过程

### 1. 修改 npm 配置文件

在用户主目录下的 `.npmrc` 文件（Windows 下为 `C:\Users\<你的用户名>\.npmrc`，如不存在可手动创建）中添加以下内容：

```plaintext
registry=https://registry.npmmirror.com
strict-ssl=false
electron_mirror=https://npmmirror.com/mirrors/electron/
electron_custom_dir={{ version }}
electron_skip_download=true
```

其中，

- `registry`：指定 npm 包的镜像源为阿里云。
- `strict-ssl=false`：禁用 SSL 验证以绕过网络限制（后续需恢复）。
- `electron_mirror`：设置 用阿里云的 Electron 镜像。
- `electron_custom_dir={{ version }}`：指定版本号占位符，确保缓存路径与版本一致。
- `electron_skip_download=true`：跳过自动下载，改为使用本地缓存的二进制文件。

### 2. 手动下载

为了绕过网络问题，我们跳过了自动下载(上一步中的 `electron_skip_download=true`)，采取手工下载文件到缓存目录。在日志中能看到正在安装 `electron@35.1.2`。

访问以下任一地址下载 `electron-v35.1.2-win32-x64.zip`：

- https://github.com/electron/electron/releases/tag/v35.1.2
- https://registry.npmmirror.com/binary.html?path=electron/35.1.2/

将下载的 zip 文件放入 Electron 缓存目录（Windows 默认路径为 `C:\Users\<你的用户名>\AppData\npm-cache\_electron\35.1.2`）：

```powershell
# 创建缓存目录（如果不存在）
mkdir -p "$env:USERPROFILE\AppData\npm-cache\_electron\35.1.2"
# 移动下载的 ZIP 文件到缓存
mv electron-v35.1.2-win32-x64.zip "$env:USERPROFILE\AppData\npm-cache\_electron\35.1.2"
```

注意，手动下载后，建议用 SHA256 校验文件完整性（GitHub 发布页通常提供校验值），增强安全性。

```powershell
certutil -hashfile electron-v35.1.2-win32-x64.zip SHA256
```

### 3. 清除缓存并重试安装

```powershell
# 清除缓存
npm cache clean --force
# 重新安装（使用 --no-audit 跳过安全检查）
npm install electron --save-dev --no-audit
```

- `--no-audit`：跳过安全审计，因为阿里云镜像未实现相关接口。

### 4. 验证安装

```powershell
npx electron -v
# 应输出 v35.1.2
```

## 风险分析和善后

前面的安装过程中有三个有风险的操作

- 设置了 `strict-ssl=false`
- 设置了 `no-audit`
- 添加了 `electron_skip_download=true`

风险等级与解决方案

| 操作                  | 风险                             | 建议恢复方式                                      |
|-----------------------|----------------------------------|--------------------------------------------------|
| `strict-ssl=false`      | 🔴 高风险（可能遭受中间人攻击，导致下载恶意包） | 安装后立即恢复：`npm config set strict-ssl true` |
| `--no-audit`            | 🟡 中风险（未扫描依赖中的已知漏洞）      | 安装后单独运行审计：`npm audit`                          |
| `electron_skip_download=true` | 🟢 低风险（若文件来源可信则无问题） | 从 GitHub 下载并校验 SHA256，确保文件完整性      |

由于安装时关闭了 SSL 验证（`strict-ssl=false`）并跳过了审计（`--no-audit`），下载的包可能存在篡改风险，进而污染最终软件成品。参考 [XcodeGhost风波](https://zh.wikipedia.org/wiki/XcodeGhost%E9%A3%8E%E6%B3%A2)（XCode因未验证依赖被注入恶意代码），需谨慎处理。

### 恢复 npm 配置文件

安装结束后，恢复 `~/.npmrc` 的配置：

```plaintext
# registry=https://registry.npmmirror.com
registry=https://registry.npmjs.org
strict-ssl=true
# electron_mirror=https://npmmirror.com/mirrors/electron/
electron_custom_dir={{ version }}
# electron_skip_download=true
proxy=http://192.168.0.100:8888
https-proxy=http://192.168.0.100:8888
```

这里把源重置为官方源并设置代理，是为支持安全审计，待审计结束后，可以换回阿里镜像并取消代理。

### 安全审计

阿里云镜像未实现 npm 官方的 `/v1/security/audits` 接口，导致无法直接审计漏洞。需切换官方源：

```powershell
> npm audit
found 0 vulnerabilities
```

请注意，要想审计正常执行，必须使用官方源。如果要使用官方源，必须设置代理。

## 总结

用镜像源加速安装，关键安全操作回归官方源，这可能是目前东大程序员使用 npm 的最优平衡方案。