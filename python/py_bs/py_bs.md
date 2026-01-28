# Python 和 Bash Shell 脚本相互调用

[Index](../index.md)

Python 和 Bash Shell 脚本相互调用都是以调用系统命令的方式，如果要接受和处理调用的输出，都是以字符串形式接受再处理。

## 1. Python 调用 Bash shell 脚本

用 Python 调用 Bash shell 脚本就是通过子进程调用系统命令，例如

```python
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
script_path = "/path/to/your/script.sh"

# 调用Bash shell脚本
run_bash_script(script_path)
```

Sources: [demo1.py](demo1.py), [demo1.sh](demo1.sh)

上面的示例中使用了 Python 的 `subprocess` 模块来调用 Bash shell 脚本。`subprocess.call()`函数接受一个命令列表作为参数，其中第一个元素是要执行的命令（这里是bash），第二个元素是要执行的脚本路径。

## 2. Bash shell 脚本调用 Python

用 Bash shell 脚本调用 Python 也是直接调用系统命令的方式

```bash
#!/bin/bash

# 调用Python脚本
function run_python_script() {
    python /path/to/your/script.py
    if [ $? -eq 0 ]; then
        echo "脚本执行成功！"
    else
        echo "脚本执行失败！"
    fi
}

# 调用Python脚本
run_python_script
```

Sources: [demo2.py](demo2.py), [demo2.sh](demo2.sh)

函数 `run_python_script` 使用 Python 命令来调用 Python 脚本。脚本执行后，会检查 Python 命令的返回值。如果返回值为0，表示脚本执行成功；如果返回值不为0，表示脚本执行失败。

## 3. Python 脚本调用 Bash shell，并接受返回的字串

前面的例子中，仅仅是调用，没有传值。这里示例的 Python 脚本调用一个 Shell 命令并接收返回的字符串：

```python
import subprocess

# 调用 Shell 命令并接收返回的输出
output = subprocess.check_output("your_shell_command", shell=True)

# 将输出转换为字符串并去除末尾的换行符
output = output.decode().rstrip()

# 打印输出
print(output)
```

Sources: [demo3.py](demo3.py)

Python 的 `subprocess` 模块提供了调用外部命令的功能。`check_output` 函数用于执行指定的命令，并返回命令的输出结果。通过 `shell=True` 参数，我们可以在命令中使用 shell 语法。

返回的输出是一个字节字符串（bytes），需要使用函数 `decode()` 将其转换为普通字符串。然后，使用函数 `rstrip()` 去除字符串末尾的换行符。

## 4. Bash shell 脚本调用 Python，并接受返回值

以下是一个示例的 Bash Shell 脚本，它调用一个 Python 脚本并接收并接受返回值：

```bash
#!/bin/bash

# 调用 Python 脚本并接收并接受返回值，注意对应的 Python 脚本必须用 print 输出内容才行
output=$(python your_script.py)

# 将返回的字符串转换为数组
IFS=' ' read -r -a array <<< "$output"

# 打印数组元素
for element in "${array[@]}"
do
    echo "$element"
done
```

上面的示例中Bash Shell 脚本使用 `$()` 语法来调用 Python 脚本并将输出存储在 `output` 变量中。然后，使用 `read` 命令将 `output` 字符串分割为数组元素，并将其存储在 `array` 变量中。

对应的 Python 脚本必须用 `print` 输出内容才行，为了让 Bash Shell 脚本能够接收到 Python 函数的返回结果，你需要在 Python 脚本中使用 `print` 函数将结果输出到标准输出。只有这样，Bash Shell 脚本才能捕获到输出并将其保存到变量中。

```python
import subprocess

def hello():
    return [1, 2, 3, 4]

print(hello())
```

Sources: [demo4.py](demo4.py), [demo4.sh](demo4.sh)

## 5. Bash shell 脚本调用 Python 脚本的某个函数

前面的例子演示了如何通过 Bash shell 脚本调用 Python 脚本，已经接受调用后的输出值，但是没有演示如何只调用脚本中的某个函数，其实可以通过 `python -c` 做到。

```bash
#!/bin/bash

python -c "from demo5 import hello; hello()"

str=$(python -c "from demo5 import hello2; hello2()")
echo ${str}
```

上面脚本中，`-c`选项用于在命令行中执行 Python 代码。在这里，使用`from demo5 import hello`语句导入 Python 脚本中的 `hello()` 函数，然后调用。主要导入 `demo5.py` 时，需要写成 `import demo5` 而非 `import demo5.py`，在引入模块时，后缀名 `.py` 不能要。

```python
def hello():
    print("Hello, from Demo 5.")

def hello2():
    return "Hello, this a string from Demo 5."
```

Sources: [demo5.py](demo5.py), [demo5.sh](demo5.sh)

<script src="https://giscus.app/client.js"
        data-repo="iridiumcao/iridiumcao.github.io"
        data-repo-id="MDEwOlJlcG9zaXRvcnkyOTUwNTIyODQ="
        data-category="Announcements"
        data-category-id="DIC_kwDOEZYj_M4Cxfqj"
        data-mapping="pathname"
        data-strict="0"
        data-reactions-enabled="1"
        data-emit-metadata="0"
        data-input-position="bottom"
        data-theme="preferred_color_scheme"
        data-lang="zh-CN"
        crossorigin="anonymous"
        async>
</script>