# 创建和分发 Python 模块(包)

[Index](../index.md)

本文档演示如何从零创建并分发一个 Python 模块。本文面向具备 Python 基础知识、希望学习如何发布自定义模块的开发者。

## 0. 实验环境

- 操作系统：Windows 11
- Python 3.11.4
- Terminal: PowerShell

## 1. 创建项目目录，并启用虚拟环境

在 PowerShell 中运行以下指令。

创建并进入项目目录：

```powershell
mkdir demo
cd demo
```

创建并为当前项目激活虚拟环境：

```powershell
python -m venv myenv
.\myenv\Scripts\Activate.ps1
```

更多内容可参见[Python 虚拟环境(Virtual Environment)](../venv.md)

## 2. 初始化项目结构

有不少工具可以帮助初始化项目结构，这里我们选用 [Poetry](https://python-poetry.org/). Poetry 是一个现代化的 Python 项目管理工具。

安装 Poetry:

```plaintext
pip install poetry
```

用指令 `poetry init` 初始化项目，它会引导你定义项目的基本信息，我的执行过程如下：

```plaintext
(myenv) PS D:\temp\demo> poetry init

This command will guide you through creating your pyproject.toml config.

Package name [demo]:  iridiumcao
Version [0.1.0]:  3.14.0
Description []:  This is a demo
Author [Cao Yi <iridiumcao@gmail.com>, n to skip]:  Cao Yi <iridiumcao@gmail.com>
License []:  MIT
Compatible Python versions [>=3.12]:  >=3.10

Would you like to define your main dependencies interactively? (yes/no) [yes] no
Would you like to define your development dependencies interactively? (yes/no) [yes] no
Generated file

[project]
name = "iridiumcao"
version = "3.14.0"
description = "This is a demo"
authors = [
    {name = "Cao Yi",email = "iridiumcao@gmail.com"}
]
license = {text = "MIT"}
readme = "README.md"
requires-python = ">=3.10"
dependencies = [
]


[build-system]
requires = ["poetry-core>=2.0.0,<3.0.0"]
build-backend = "poetry.core.masonry.api"


Do you confirm generation? (yes/no) [yes] yes
```

在输入 `Package name` 时请确保包名未被占用，否则可能与现有模块冲突。可访问 [PyPI](https://pypi.org/) 搜索包名确认可用性。

此时可以发现在项目的根目录里有一个新文件生成：`pyproject.toml`, 它的内容在前面执行 `poetry init` 时已经展示过了。

不过前面的操作并没有自动建立目录，因此我们手动在项目的根目录下创建三个子目录：

- src
- test
- doc

## 3. 编写代码

本实验主要为了演示，这里只添加必须的几个文件: `README.md`, `utils.py`, `__init__.py` 和 `test_utils.py`. 添加后，项目的目录树如下：

```plaintext
.
├── pyproject.toml
├── README.md
├── doc/
├── src/
│   └── iridiumcao/
│       ├── __init__.py
│       └── utils.py
└── test/
    └── test_utils.py
```

注意上面的 `src/iridiumcao` 目录，这里的名称要和之前在 `pyproject.toml` 中定义的 Package 名称一致。还可以在 `pyproject.toml` 中添加

```plaintext
packages = [{ include = "iridiumcao", from = "src" }]
```

以明示代码路径。如果项目的源码不在根目录，而是放在 `src/` 下（如本例），需要在 `pyproject.toml` 中明确指定源码路径，否则 Poetry 默认会在根目录搜索包。

新建的文档和代码的内容也很简单，附在下面，也可以在[这里](https://github.com/iridiumcao/iridiumcao.github.io/tree/master/python/package/code/demo)浏览下载。

`README.md` 里需要填写一些说明内容，比如：

```plaintext
# iridiumcao

A simple demo package for data processing.

... ...
```

`utils.py`:

```python
def process_data(data):
    return [x ** 2 - 1 for x in data]
```

`__init__.py`:

```python
from .utils import process_data  # 让用户直接 import iridiumcao.process_data
__version__ = '3.14.0'
```

## 4. 安装和使用包

将前面的代码以模块形式安装到本地环境。

在项目根目录下执行：

```powershell
poetry install
```

**测试:**

编写测试代码 `test_utils.py`:

```python
import iridiumcao
result = iridiumcao.process_data([1, 2, 3]) 
print("Processed Result:", result)
```

（这个测试仅为演示效果，不是标准写法。标准的测试将来会在其他文档介绍。）

```plaintext
cd .\test\
python .\test_utils.py
```

运行结果如下：

```plaintext
Processed Result: [0, 3, 8]
```

满足预期。

### 附

卸载安装包：

```powershell
poetry remove iridiumcao
```

查看所有安装包列表：

```powershell
pip list
```

## 5. 后记

我写这篇文档的原因是，在我们的项目中有许多公共 Python 脚本。过去我们通过 `sys.path.append(...)` 来导入这些脚本，但由于不同环境的路径不同，常常带来麻烦。

使用模块化打包的方式可以彻底解决这个问题：只需将公共代码打包成一个模块，通过 `poetry install` 安装后即可直接导入使用，无需再修改路径。

如果未来需要共享或部署，还可以进一步将模块发布到 [PyPI](https://pypi.org/), 本文暂不涉及。

感谢 Grok & ChatGPT：

- [Grok: 如何编写和分发Python模块（包）](https://x.com/i/grok?conversation=1983059022765789550)
- [Grok: Python 中类似 Maven 的工具推荐](https://x.com/i/grok/share/NIpKWFj749a3lrXjrg6RJiQ00)
- [ChatGPT: 命名冲突的诊断与解决](https://chatgpt.com/s/t_6901d3a4cc108191af4053fdc79c1c32)

<script src="https://utteranc.es/client.js"
        repo="iridiumcao/iridiumcao.github.io"
        issue-term="pathname"
        theme="github-light"
        crossorigin="anonymous"
        async>
</script>