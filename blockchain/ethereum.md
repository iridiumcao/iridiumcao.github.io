# Ethereum

[Index](index.md)

Official site: <https://ethereum.org/zh/>

智能合约开发工具：

* 在线版本：
  * <https://remix.ethereum.org/>
  * <https://github.com/ethereum/remix-project>
* 本地版本：<https://github.com/ethereum/remix-desktop/releases>

## Dev enironment

### NPM & Node.js

Ref: <https://docs.npmjs.com/downloading-and-installing-node-js-and-npm>

```text
$ sudo npm install -g npm
[sudo] cy 的密码： 
/usr/local/bin/npx -> /usr/local/lib/node_modules/npm/bin/npx-cli.js
/usr/local/bin/npm -> /usr/local/lib/node_modules/npm/bin/npm-cli.js
+ npm@7.7.6
added 252 packages from 909 contributors in 8.712s
```

### Install Remix-project

```text
$ npm install -g @nrwl/cli
$ git clone https://github.com/ethereum/remix-project.git

$ cd remix-project
$ npm install
$ nx build remix-ide --with-deps
$ nx serve
```
