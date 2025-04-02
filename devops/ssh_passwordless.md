# SSH 免密登录

[Index](index.md)

---

- [SSH 免密登录](#ssh-免密登录)
  - [1. 安装软件](#1-安装软件)
  - [2. 生成密钥](#2-生成密钥)
  - [3. 添加认证](#3-添加认证)
    - [3.1 自动方式](#31-自动方式)
    - [3.2 手动方式](#32-手动方式)
  - [附录1：指定密钥登录](#附录1指定密钥登录)
  - [附录2： `.ssh` 目录说明](#附录2-ssh-目录说明)
  - [附录3: 解决 SSH 自动登录失败问题](#附录3-解决-ssh-自动登录失败问题)
    - [Ubuntu：错误信息友好，解决方案明确](#ubuntu错误信息友好解决方案明确)
    - [CentOS：提示模糊，安全限制更严格](#centos提示模糊安全限制更严格)
    - [为什么密钥会失效？](#为什么密钥会失效)
  - [附录4：`~/.ssh/config`](#附录4sshconfig)

---

假设有 A, B 两机，B 的 IP 是 `192.168.0.100`. 为了方便，假设两台主机都用的是 Linux 系统。确保 A 和 B 网络可达，且 B 的 SSH 服务（默认 22 端口）已开启。

从 A 登录 B，通常需运行以下命令并输入密码：

```bash
ssh bob@192.168.0.100 # A 上用户 alice 登录 B 上用户 bob
```

<script type="module">
    import mermaid from 'https://cdn.jsdelivr.net/npm/mermaid@10/dist/mermaid.esm.min.mjs';
    mermaid.initialize({ startOnLoad: true });
</script>

<div class="mermaid">
%% SSH 登录流程
sequenceDiagram
    participant Alice
    participant A as Host A
    participant B as Host B (192.168.0.100)

    Alice->>A: 登录
    A-->>Alice: 登录成功
    Alice->>A: 输入 ssh bob@192.168.0.100
    A->>B: 发起 SSH 连接
    B-->>A: 验证并建立连接
    A-->>Alice: 成功登录 Host B
</div>

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

不同系统的软件包命名可能略有差异，如 Ubuntu 用 `openssh-client`（单数），CentOS 等用 `openssh-clients`（复数）。

Arch Linux:

```bash
$ sudo pacman -S openssh
```

检查 SSH 服务状态：

```bash
$ sudo systemctl status ssh # 或 sshd，视系统而定
```

若输出显示 `active (running)`，则服务正常运行。若服务未运行，可用 `sudo systemctl start ssh` 启动；若需开机自启，可用 `sudo systemctl enable ssh`。

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

也可通过编辑 `~/.ssh/config` 指定默认密钥（`IdentityFile ~/.ssh/id_ed25519`），详见本文附录4.

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
$ chmod 600 ~/.ssh/config
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

删除后下次连接时会重新记录主机密钥，需确认是否信任。详参附录3.

## 附录3: 解决 SSH 自动登录失败问题

当 SSH 自动登录失败时，不同操作系统可能会显示不同的警告信息，这往往让用户感到困惑。下面以 Ubuntu 和 CentOS 为例说明。

SSH 自动登录依赖于公钥认证，通常通过 `~/.ssh/known_hosts` 文件验证远程主机的身份。当远程主机的密钥发生变化（例如服务器重装、IP 地址变更或配置更新），本地保存的密钥与远程主机不再匹配，就会导致登录失败，并显示类似“REMOTE HOST IDENTIFICATION HAS CHANGED”的警告。这种情况可能是正常的配置变更，也可能是潜在的安全威胁（如中间人攻击）。以下是 Ubuntu 和 CentOS 中常见的错误表现及解决方法。

### Ubuntu：错误信息友好，解决方案明确

在 Ubuntu 上，当尝试通过 SFTP 或 SSH 连接时，如果主机密钥验证失败，会显示详细的警告信息。例如：

``` plaintext
$ sftp alice@192.168.0.100
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@    WARNING: REMOTE HOST IDENTIFICATION HAS CHANGED!     @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
IT IS POSSIBLE THAT SOMEONE IS DOING SOMETHING NASTY!
Someone could be eavesdropping on you right now (man-in-the-middle attack)!
It is also possible that a host key has just been changed.
The fingerprint for the ECDSA key sent by the remote host is
SHA256:Jt/yuETXIIuYmmwcJAyQPp/fnUPresmSg3TmhMvLZGs.
Please contact your system administrator.
Add correct host key in /home/alice/.ssh/known_hosts to get rid of this message.
Offending ECDSA key in /home/alice/.ssh/known_hosts:16
  remove with:
  ssh-keygen -f "/home/alice/.ssh/known_hosts" -R "192.168.0.100"
ECDSA host key for 192.168.0.100 has changed and you have requested strict checking.
Host key verification failed.
Connection closed.  
Connection closed
```

Ubuntu 的错误信息非常友好，不仅指出了问题（主机密钥变更），还直接给出了解决方案：删除 `known_hosts` 文件中对应的旧密钥。

根据提示，运行以下命令移除旧的主机密钥：

```bash
ssh-keygen -f "/home/alice/.ssh/known_hosts" -R "192.168.0.100"
```

这将从 known_hosts 文件中删除与 192.168.0.100 相关的条目。

再次运行登录命令：

```bash
sftp alice@192.168.0.100
```

系统会提示你确认新的主机密钥指纹，输入 `yes` 后，新密钥将被添加到 `known_hosts`，连接即可恢复。

### CentOS：提示模糊，安全限制更严格

在 CentOS 上，SSH 登录失败的错误信息略有不同，且解决过程可能更复杂。例如：

```plaintext
$ ssh root@192.168.0.222
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@    WARNING: REMOTE HOST IDENTIFICATION HAS CHANGED!     @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
IT IS POSSIBLE THAT SOMEONE IS DOING SOMETHING NASTY!
Someone could be eavesdropping on you right now (man-in-the-middle attack)!
It is also possible that a host key has just been changed.
The fingerprint for the ECDSA key sent by the remote host is
SHA256:s3ysDUFuL1+ta3QqFt7Q1hEuSZ7S2sOqSZftodElYC0.
Please contact your system administrator.
Add correct host key in /c/Users/alice/.ssh/known_hosts to get rid of this message.
Offending ECDSA key in /c/Users/alice/.ssh/known_hosts:63
Password authentication is disabled to avoid man-in-the-middle attacks.
Keyboard-interactive authentication is disabled to avoid man-in-the-middle attacks.
root@192.168.0.222: Permission denied (publickey,gssapi-keyex,gssapi-with-mic,password).
```

尝试删除密钥时，可能还会遇到额外的麻烦：

```plaintext
$ ssh-keygen.exe -R root@192.168.0.222
Host root@192.168.0.222 not found in /c/Users/alice/.ssh/known_hosts

$ ssh-keygen.exe -R 192.168.0.222
# Host 192.168.0.222 found: line 63
/c/Users/alice/.ssh/known_hosts updated.
Original contents retained as /c/Users/alice/.ssh/known_hosts.old
```

CentOS 的错误信息虽然也提示了密钥变更，但没有像 Ubuntu 那样直接给出完整命令。此外，它默认禁用了密码认证和键盘交互认证，这可能是服务器端配置了更高的安全策略（例如只允许公钥登录）。而且，第一次运行 `ssh-keygen -R` 时失败，原因是命令中包含了用户名（`root@`），需要直接使用 IP 地址。

使用正确的命令移除旧密钥：

```bash
ssh-keygen -R 192.168.0.222
```

这会更新 `known_hosts` 文件，并备份原始文件为 `known_hosts.old`。

由于提示“Permission denied (publickey...)”，说明服务器只接受公钥认证。确保你的私钥（通常是 `~/.ssh/id_rsa`）与服务器上的公钥（`~/.ssh/authorized_keys`）匹配。如果不匹配，可以：

- 生成新密钥对：`ssh-keygen -t rsa -b 4096`
- 将公钥上传到服务器：`ssh-copy-id root@192.168.0.222`

最后，运行：

```bash
ssh root@192.168.0.222
```

确认新密钥后，连接应成功。

### 为什么密钥会失效？

- 服务器重装或 SSH 服务重新配置，导致主机密钥变更。
- 本地网络环境变化（例如 IP 冲突或代理设置）。
- 人为错误，比如误删了 `known_hosts` 或密钥文件。

如果怀疑是中间人攻击，可以通过其他渠道（比如电话或邮件）联系服务器管理员，核对主机密钥指纹（例如 SHA256:s3ysDUFuL1+ta3QqFt7Q1hEuSZ7S2sOqSZftodElYC0）。

## 附录4：`~/.ssh/config`

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

上面的例子中，第2条配置还为登录 `192.168.0.100` 设置了别名已经对应的密钥路径，这样就可以直接使用 `ssh demo_b` 代替 `ssh -i ~/.ssh/id_ed25519 bob@192.168.0.100`. 更多配置选项可参考 `man ssh_config`. 在 `~/.ssh/config` 中配置主机别名，还可以避免因 IP 变化而重复验证。