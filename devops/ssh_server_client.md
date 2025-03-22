# SSH Server/Client 安装和连接

[Index](index.md)

---

- [SSH Server/Client 安装和连接](#ssh-serverclient-安装和连接)
  - [服务端](#服务端)
    - [Debian/Ubuntu](#debianubuntu)
    - [Fedora](#fedora)
    - [CentOS](#centos)
      - [修改默认端口](#修改默认端口)
  - [客户端](#客户端)
    - [Windows Client](#windows-client)
    - [Linux Client](#linux-client)
  - [我的故事](#我的故事)

---

按：这篇文章是很早之前发布在个人 Google Site 上的，已经不知具体时间了。在转移到本地时，更新了一些过时的内容。

## 服务端

如果要在网络中使用 SSH，则被连接的服务器需要开启 SSH server，如果没装这个软件，可以很快装上。

### Debian/Ubuntu

安装：

```shell
sudo apt-get install openssh-server
```

（文件很小，安装很快）

安装好后，SSH 服务就自动启动了，端口默认是22，也可以通过修改 /ect/ssh/ssh_config 的 Port 值来改变。默认情况是：它开机自动启动，可以用 chkconfig 调节。

手动启动/关闭 SSH 服务：

```shell

sudo /etc/init.d/ssh stop
sudo /etc/init.d/ssh start
```

附: 在 Ubuntu 中设置为开机自动启动的方法：【系统】-【首选项】-【启动应用程序】

### Fedora

安装：

```shell
yum install openssh-server
```

这步可能碰到一个很奇怪的问题，提示我 Dropbox 没安装对，导致 ssh 也不能安装，真实太奇怪了，这两个软件有什么关系？！后来删除了 /etc/yum.repos.d/dropbox.repo 再度安装才成功。万恶的 GFW，导致我的 Dropbox 没能安装成功！

启动/关闭 SSH (以下指令须在 root 帐号执行):

```shell
/etc/init.d/sshd start
/etc/init.d/sshd restart
```

取消防火墙限制：修改 iptables:

```shell
su
/etc/sysconfig/iptables   
```

### CentOS

无需另外安装，系统自带了 ssh 的程序。如果需要安装，方法应该和 Fedora 是一样的。

启动 ssh 服务的指令参 Fedora 部分。

设置开机启动的指令是：`chkconfig sshd on`

该指令对 Fedora 也应该是有效的。

#### 修改默认端口

对Ubuntu，编辑文件 `/ect/ssh/ssh_config` 即可，对 Fedora，编辑 `/ect/ssh/sshd_config`。
找到行：

```plaintext
# Port 22
```

取消注释，修改数值即可。
   
参考：

1. 如何更改SSH端口号,如何限制IP登录SSH服务器 （2009-10-15 15:49）(已失效)
2. Fedora防火墙设置(网易上的一个blog，已失效)

## 客户端

### Windows Client

如果客户端是 Windows，则可以使用系统自带的 PowerShell，也可以使用一些现成的客户端工具：

1. Windows PowerShell
2. Git Bash Shell
3. Putty，支持中文，可设置编码，中文无乱码
4. [Bitvise SSH Client](https://bitvise.com/ssh-client-download), 这个工具上传和下载文件也很方便。用了它，FTP, Samba 的必要性似乎下降不少了。中文支持不知如何。
5. WinSCP，下载很方便，可设置编码，中文无乱码
6. XMing，和 putty 配合使用，远程连接和操作 Linux 的桌面，相当于 Windows 版本的 ssh -X. 具体使用方法参[《SSH X11 Forwarding》](ssh_x_forwarding.md)。

### Linux Client

在 Linux 中通过 SSH 连接其他其他 Linux server，非常方便，在 Shell 中输入命令 `ssh username@host` 即可，如：

```shell
ssh root@192.168.8.85
```

更详细的连接参数可以从 ssh 指令的帮助文档中找到。

参数 X。`SSH -X` 的原理，很有趣，Linux X Window 是通用的，将远程机器 X 程序的内容取过来，在本地的 X Server 上运行。具体使用方法参[《SSH X11 Forwarding》](ssh_x_forwarding.md)。

上传和下载文件，需要用到 scp 指令(参 [Linux 常用命令](https://sites.google.com/site/iridiumsite/it/os/linux/commands)中的scp命令介绍)，用起来还比较麻烦，需要进一步研究。这个协议其实不怎么用了，一般都用 SFTP 了。

## 我的故事

比较有趣的是我自己的使用故事——几台机器你中有我，我中有你：
- U: Ubuntu 系统
- WU: 安装在 U 系统 VirtualBox 里的虚拟 Windows XP
- WH: 神舟小本上的 Windows XP

我是这样连接的：

1. 在 U 中通过远程桌面连 WH, 再在 WH 里通过 SSH Client 连 U,
2. 在 WU 中连 U.