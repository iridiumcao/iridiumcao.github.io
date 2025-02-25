# Windows查找端口占用并关闭

[Index](index.md)

- Created: 2021-03-10 11:37 +08:00
- Updated: 2025-02-25 21:56 +08:00

IntelliJ IDEA因license过期，30分钟强行关闭IDE，而此时tomcat正在运行。
重启IDEA后，tomcat不能正常启动，系统提示1099端口被占用。

解决办法：查到占用1099的程序，再kill

cmd 示例：

```plaintext
C:\Users\iridi>netstat -aon | find "1099"
  TCP    0.0.0.0:1099           0.0.0.0:0              LISTENING       12068
  TCP    [::]:1099              [::]:0                 LISTENING       12068

C:\Users\iridi>taskkill /f /pid 12068
成功: 已终止 PID 为 12068 的进程。
```

PowerShell 示例（这个例子找的是占用其他端口的进程，和找1099端口类似）：

```plaintext
PS C:\Users\iridi> netstat -ano | findstr :8080
  TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       111044
  TCP    [::]:8080              [::]:0                 LISTENING       111044
PS C:\Users\iridi> taskkill /PID 111044 /F
成功: 已终止 PID 为 111044 的进程。
```
