# Disable Autostart of MySQL or PostgreSQL Server on Ubuntu

OS: Ubuntu 19.04

## MySQL

When the MySQL server is installed, it automatically started with the OS. It slows the speed of OS loading. But the computer is for personal, not a DB server. I just want to start it when I need.

Check the MySQL server's status and stop it.

```
$ service mysql status
$ service mysql stop
```

Disable autostart:

```
$ sudo systemctl disable mysql
```

When you need it, it can be started by:

```
$ service mysql start
```

References:
- https://askubuntu.com/questions/57381/how-to-stop-mysql-from-running-at-boot-time
- https://askubuntu.com/questions/833094/how-can-i-disable-autostart-of-mysql-server

## PostgreSQL

It's similiar to PostgreSQL:

```
$ service postgresql status
$ service postgresql stop
$ sudo systemctl disable postgresql
$ service postgresql start
```

---

This artical was post to [OSC](https://my.oschina.net/iridium/blog/3041476) originally at 2019/04/23 20:11.