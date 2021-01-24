# SSH Auto-Login Failed

When SSH Auto-login failed, the warning messages are different due to the OS.

For Ubuntu, it shows the solution, but CentOS does not do so.

## Ubuntu

``` bash

$ sftp caoyi@192.168.0.100
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@    WARNING: REMOTE HOST IDENTIFICATION HAS CHANGED!     @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
IT IS POSSIBLE THAT SOMEONE IS DOING SOMETHING NASTY!
Someone could be eavesdropping on you right now (man-in-the-middle attack)!
It is also possible that a host key has just been changed.
The fingerprint for the ECDSA key sent by the remote host is
SHA256:Jt/yuETXIIuYmmwcJAyQPp/fnUPresmSg3TmhMvLZGs.
Please contact your system administrator.
Add correct host key in /home/caoyi/.ssh/known_hosts to get rid of this message.
Offending ECDSA key in /home/caoyi/.ssh/known_hosts:16
  remove with:
  ssh-keygen -f "/home/caoyi/.ssh/known_hosts" -R "192.168.0.100"
ECDSA host key for 192.168.0.100 has changed and you have requested strict checking.
Host key verification failed.
Connection closed.  
Connection closed

```

## CentOS

``` bash
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
Add correct host key in /c/Users/caoyi/.ssh/known_hosts to get rid of this message.
Offending ECDSA key in /c/Users/caoyi/.ssh/known_hosts:63
Password authentication is disabled to avoid man-in-the-middle attacks.
Keyboard-interactive authentication is disabled to avoid man-in-the-middle attacks.
root@192.168.0.222: Permission denied (publickey,gssapi-keyex,gssapi-with-mic,password).

$ ssh-keygen.exe -R root@192.168.0.222
Host root@192.168.0.222 not found in /c/Users/caoyi/.ssh/known_hosts

$ ssh-keygen.exe -R 192.168.0.222
# Host 192.168.0.222 found: line 63
/c/Users/caoyi/.ssh/known_hosts updated.
Original contents retained as /c/Users/caoyi/.ssh/known_hosts.old
```
