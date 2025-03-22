# SSH 免密登录设置

[Index](index.md)

---

- [SSH 免密登录设置](#ssh-免密登录设置)
  - [1. 安装软件](#1-安装软件)
  - [2. 生成密钥](#2-生成密钥)
  - [3. 添加认证](#3-添加认证)
    - [3.1 自动方式](#31-自动方式)
    - [3.2 手动方式](#32-手动方式)
  - [附录1：指定密钥登录](#附录1指定密钥登录)
  - [附录2： `.ssh` 目录说明](#附录2-ssh-目录说明)
  - [附录3：`~/.ssh/config`](#附录3sshconfig)

---

假设有 A, B 两机，B 的 IP 是 `192.168.0.100`. 为了方便，假设两台主机都用的是 Linux 系统。确保 A 和 B 网络可达，且 B 的 SSH 服务（默认 22 端口）已开启。

从 A 登录到 B，通常需要执行这样的指令并按提示输入密码，即可登录 B.

```bash
ssh bob@192.168.0.100 # A 上用户 alice 登录 B 上用户 bob
```

如果经常需要从 A 登录到 B，每次都输入密码就显得比较麻烦，可以考虑将 A 系统 `alice` 用户的 SSH 公钥添加到 B 上的用户 `bob` 的信任列表（即 `authorized_keys` 文件）中，实现免密登录。具体步骤如下：

## 1. 安装软件

在 A 和 B 中都安装好 SSH 的客户端与服务器

Ubuntu/Debian:

```bash
$ sudo apt-get update
$ sudo apt-get install openssh-server openssh-client
```

CentOS / Rocky / RHEL:

```bash
$ sudo dnf install openssh-server openssh-clients
```

不同系统的软件包命名可能略有差异，如 Ubuntu 用单数 `openssh-client`，CentOS 等用复数 `openssh-clients`。

Arch Linux:

```bash
$ sudo pacman -S openssh
```

检查 SSH 服务状态：

```bash
$ sudo systemctl status ssh # 或 sshd，视系统而定
```

若服务未运行，可用 `sudo systemctl start ssh` 启动；若需开机自启，可用 `sudo systemctl enable ssh`。

更多关于安装的内容参[SSH Server/Client 安装和连接](ssh_server_client.md).

## 2. 生成密钥

在 A 系统，以用户 `alice` 登入，生成密钥。执行 `ssh-keygen`:

```bash
$ ssh-keygen
Generating public/private ed25519 key pair.
Enter file in which to save the key (/home/alice/.ssh/id_ed25519):
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
Your identification has been saved in /home/alice/.ssh/id_ed25519
Your public key has been saved in /home/alice/.ssh/id_ed25519.pub
The key fingerprint is:
SHA256:eKK0X0DUaJoPtR1BUSEh96iJ680KM/kDXIQf9O2U7RA alice@alicepc
The key's randomart image is:
+--[ED25519 256]--+
|   o. o+E=o.     |
|  . oo++oB       |
|   o *oo*.o      |
|    *o.*.o       |
| . .oo* S .      |
|  oo +.+         |
|  =.+   .        |
|   *.+ .         |
|    +o+          |
+----[SHA256]-----+
```

注意，`ssh-keygen` 执行后，会交互式询问一些问题，若无需自定义，可以不用理会，直接按回车使用默认设置即可。它会询问生成的密钥文件的名称（默认是 `id_ed25519`），如果不想覆盖已有的密钥，可以指定不同的文件名。

建议为私钥设置 passphrase 以增强安全性（设置后登录时需输入该密码短语）。若追求完全免密登录，可直接回车跳过此步骤，但需妥善保管私钥文件。

此命令执行后，会在 `~/.ssh/` 中生成一对密钥：`id_ed25519` 和 `id_ed25519.pub`，前者是私钥，后者是公钥。

公钥的文本内容类似这样的：

```plaintext
ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIANLXUF3pyHu9lTDJKv693a2FghZqtRLxKBzLft4iUOg alice@alicepc
```

## 3. 添加认证

将 A 上生成的公钥（`id_ed25519.pub`）内容添加到 B 的 `/home/bob/.ssh/authorized_keys` 文件中。可以通过以下方式实现：

### 3.1 自动方式

在 A 上执行

```bash
$ ssh-copy-id bob@192.168.0.100
```

执行后按提示输入 B 上 `bob` 用户的密码即可。

`ssh-copy-id` 一般需要在目标主机上已经启用了 SSH 服务器，如果没启动，可以执行 `sudo systemctl enable --now ssh` 来启动。

### 3.2 手动方式

将公钥复制到B：

```bash
$ cat ~/.ssh/id_ed25519.pub | ssh bob@192.168.0.100 "mkdir -p ~/.ssh && cat >> ~/.ssh/authorized_keys"
```

> 注意：此命令需确保 B 的 SSH 服务已运行，且 A 能通过 SSH 连接到 B。

完成后，确保 B 上 `~/.ssh` 目录权限为 700，`authorized_keys` 文件权限为 600，可用以下命令调整：

```bash
$ ssh bob@192.168.0.100 "chmod 700 ~/.ssh && chmod 600 ~/.ssh/authorized_keys"
```

测试免密登录：

```bash
$ ssh bob@192.168.0.100
```

若无需输入密码即登录成功，则配置完成。若仍提示输入密码，可检查 B 上 `~/.ssh/` 和 `authorized_keys` 的权限，或确认 B 的 SSH 配置文件（`/etc/ssh/sshd_config`）是否启用公钥认证（`PubkeyAuthentication yes`），并重启服务（`sudo systemctl restart ssh`）。

## 附录1：指定密钥登录

如果当前用户使用多个密钥，登录时需要指定密钥，如

```bash
$ ssh -i ~/.ssh/id_ed25519 bob@192.168.0.100
```

注意，`-i` 参数需要指定密钥的完整路径（如 `~/.ssh/id_ed25519`），否则可能会报错 `no such file`. 如果 `~/.ssh` 中只有一个密钥，那么它就是默认密钥，无需使用 `-i` 参数。

也可通过编辑 `~/.ssh/config` 指定默认密钥（`IdentityFile ~/.ssh/id_ed25519`），详见本文附录3.

## 附录2： `.ssh` 目录说明

在 `~/.ssh` 目录中，A 和 B 通常可能包含以下文件（示例输出以 A 的用户 `alice` 为例，B 的用户 `bob` 文件结构类似，实际时间戳因系统而异）：

```bash
$ cd ~/.ssh
$ ls -l
total 44
-rw-------. 1 alice users 25194 Sep 15 08:01 authorized_keys
-rw-r--r--. 1 alice users    25 Sep 15 08:01 config
-rw-------. 1 alice users  3381 Mar 26 23:06 id_ed25519
-rw-r--r--. 1 alice users   741 Mar 26 23:06 id_ed25519.pub
-rw-r--r--. 1 alice users   723 Aug 17 04:29 known_hosts
```

SSH 对权限非常敏感，权限不对 SSH 可能无法使用免密登录，`.ssh` 目录应为 `700`，`authorized_keys` 应为 `600`，可以通过下面的指令设置：

```bash
$ chmod 700 ~/.ssh
$ chmod 600 ~/.ssh/authorized_keys
```

下面对 `~/.ssh` 的几个文件解释如下：

- `authorized_keys`: 存储了允许免密登录到本机的 SSH 公钥。比如本文中 A 免密登录 B，则 A 的 SSH 公钥需要记录到 B 的 `authorized_keys` 中。
- `config`: SSH 客户端的配置文件，可以用于简化 SSH 连接，例如指定不同的主机别名、端口、密钥等。
- `id_ed25519`: 是当前用户的 SSH 私钥，务必妥善保管，不能泄露。若私钥泄露，应立即重新生成密钥对并更新相关配置。注意它的默认权限是 `-rw-------`
- `id_ed25519.pub`: 当前用户的密钥之公钥，注意它的默认权限是 `-rw-r--r--`
- `known_hosts`: 记录从本机登录过的远程主机的信息，用于验证远程主机的身份。如果远程主机的密钥发生更改，SSH 会发出警告。此时，你可以手动删除 `known_hosts` 文件中对应的条目，或者使用 `ssh-keygen -R hostname` 命令删除特定主机的记录，如：

```bash
$ ssh-keygen -R 192.168.0.100
```

删除后下次连接时会重新记录主机密钥，需确认是否信任。

## 附录3：`~/.ssh/config`

`~/.ssh/config` 可以记录多个远程主机的信息，如下例：

```plaintext
Host chengdu12
  HostName 192.168.2.123
  User test
  Port 2222  # 指定非默认端口

Host demo_b
  HostName 192.168.0.100
  User bob
  IdentityFile ~/.ssh/id_ed25519
```

上面的例子中，第2条配置还为登录 `192.168.0.100` 设置了别名已经对应的密钥路径，这样就可以直接使用 `ssh demo_b` 代替 `ssh -i ~/.ssh/id_ed25519 bob@192.168.0.100`. 更多配置选项可参考 `man ssh_config`.
