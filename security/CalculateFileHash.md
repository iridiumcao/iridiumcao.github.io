# Calculate File Hash

To calculate MD5, SHA1 and SHA256 code.

## Linux or Git Bash

```bash
$ sha256sum velocity.7z
b488f0ed92010bf17063b07eb22f079112f8dbb3e055b5eb0b799314771cc03a *velocity.7z

$ sha1sum velocity.7z
9caf3b9d2814045d31e49cae8438229f6660635c *velocity.7z

$ md5sum velocity.7z
3331dbc1ed7ff83e19ff519e5058dab3 *velocity.7z
```

## Windows

* [Ref](https://cloud.tencent.com/developer/article/1562603)

```cmd
D:\test>certutil -hashfile velocity.7z sha256
SHA256 的 velocity.7z 哈希:
b488f0ed92010bf17063b07eb22f079112f8dbb3e055b5eb0b799314771cc03a
CertUtil: -hashfile 命令成功完成。

D:\test>certutil -hashfile velocity.7z sha1
SHA1 的 velocity.7z 哈希:
9caf3b9d2814045d31e49cae8438229f6660635c
CertUtil: -hashfile 命令成功完成。

D:\test>certutil -hashfile velocity.7z md5
MD5 的 velocity.7z 哈希:
3331dbc1ed7ff83e19ff519e5058dab3
CertUtil: -hashfile 命令成功完成。
```
