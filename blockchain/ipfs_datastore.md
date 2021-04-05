# IPFS Datastore Path

IPFS 初始化后默认的目录是``~/.ipfs``, 如果存放的文件比较多，可能需要设置到硬盘其他目录。
具体设置方法是，先设置环境变量，再初始化。

``` text
$ export IPFS_PATH=/path/to/ipfsrepo
$ ipfs init
```
（可以考虑把``IPFS_PATH``永久设置下来）

参考``ipfs --help``命令中的输出内容：

``` text
  ipfs uses a repository in the local file system. By default, the repo is
  located at ~/.ipfs. To change the repo location, set the $IPFS_PATH
  environment variable:
  
    export IPFS_PATH=/path/to/ipfsrepo
```

比较不解的是``ipfs config``无效：

``` text
$ipfs config Datastore.Path /path/to/ipfsrepo
old style datatstore config detected
```