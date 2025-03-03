# 东大拯救NPM指南之代理设置

[Index](index.md)

在古老神奇的东大，没有代理寸步难行。这里简单介绍下如何设置。

## 🧐检查代理状态

```bash
npm config get proxy
npm config get https-proxy
```

如果没有设置过代理，输出结果会是 `null`。

## 🔧设置代理

```bash
npm config set proxy http://192.168.0.100:8888
npm config set https-proxy http://192.168.0.100:8888
```

如果之前已经有设置过，执行后会覆盖之前的设置。这里要特别说明下

- 💡 代理地址要附上协议，不能省掉`http://`写成下面这样：
  
```bash
npm config set https-proxy 192.168.0.100:8888  # ❌ 错误示范
```

- HTTPS 的代理地址可以是 HTTP 的，即 `http://192.168.0.100:8888`，而不必是 `https://192.168.0.100:8888`。如果代理地址也要用 HTTPS，需要额外添加认证，比较麻烦，一般不必要（我现在也不会，目前也不打算会 😎）。

## ✅验证设置

测试代理是否正常，可以运行下面的指令：

```bash
npm cache clean --force
npm install express
```

测试代理是否能正常拉取依赖。这里用 `express` 测试的，你也可以改成别的。

## 🗑️删除代理

如果不需要使用代理了，可以用如下指令删除：

```bash
npm config rm proxy
npm config rm https-proxy
```
