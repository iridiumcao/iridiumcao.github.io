# Windows查找端口占用并关闭

[Index](index.md)

2021-03-10 11:37:29 +08:00

IntelliJ IDEA因license过期，30分钟强行关闭IDE，而此时tomcat正在运行。
重启IDEA后，tomcat不能正常启动，系统提示1099端口被占用。

解决办法。查到占用1099的程序，再kill

```text
C:\Users\iridi>netstat -aon | find "1099"
  TCP    0.0.0.0:1099           0.0.0.0:0              LISTENING       12068
  TCP    [::]:1099              [::]:0                 LISTENING       12068

C:\Users\iridi>taskkill /f /pid 12068
成功: 已终止 PID 为 12068 的进程。
```
