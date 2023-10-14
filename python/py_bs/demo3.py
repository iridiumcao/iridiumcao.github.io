#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import subprocess

# 调用 Shell 命令并接收返回的输出
output = subprocess.check_output("ls", shell=True)

# 将输出转换为字符串并去除末尾的换行符
output = output.decode().rstrip()

# 打印输出
print(output)