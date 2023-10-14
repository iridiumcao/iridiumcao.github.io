#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import subprocess

def hello():
    return [1, 2, 3, 4]

# 必须用 `print` 输出内容才行，为了让 Bash Shell 脚本能够接收到 Python 函数的返回结果，
# 你需要在 Python 脚本中使用 `print` 函数将结果输出到标准输出。只有这样，Bash Shell 脚
# 本才能捕获到输出并将其保存到变量中。
print(hello())