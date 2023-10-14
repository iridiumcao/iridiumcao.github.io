#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import subprocess

# 调用Bash shell脚本
def run_bash_script(script_path):
    try:
        # 执行shell命令
        subprocess.call(['bash', script_path])
        print("脚本执行成功！")
    except subprocess.CalledProcessError as e:
        print("脚本执行失败：", e)

# 指定要调用的脚本路径
script_path = "demo1.sh"

# 调用Bash shell脚本
run_bash_script(script_path)