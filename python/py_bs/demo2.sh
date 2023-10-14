#!/bin/bash

# 调用Python脚本
function run_python_script() {
    python demo2.py
    if [ $? -eq 0 ]; then
        echo "脚本执行成功！"
    else
        echo "脚本执行失败！"
    fi
}

# 调用Python脚本
run_python_script
