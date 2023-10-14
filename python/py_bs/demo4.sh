#!/bin/bash

# 调用 Python 脚本并接收返回值
output=$(python demo4.py)

# 将返回的字符串转换为数组
IFS=' ' read -r -a array <<< "$output"

# 打印数组元素
for element in "${array[@]}"
do
    echo "$element"
done
