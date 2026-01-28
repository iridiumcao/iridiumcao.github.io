# Python 虚拟环境(Virtual Environment)

[Index](index.md)

有时我们在同一台机器上使用多个 Python 项目时可能会遇到依赖冲突问题。比如项目 A 需要 `Django 2.2`，而项目 B 需要 `Django 3.2`，直接安装会导致冲突。所有项目都用同样的 Python 环境在某些时候并不可行。

有时某个 pip 包只是某个项目用，别的项目用不上，安装后冗余很大。而且当使用它的项目移除后，我们也不一定敢移除它的依赖包，因为担心别的项目会用到。

如果我们能为每个项目创建独立的依赖环境就没有上面的问题了，实际上，在 Python 中是可以做到的，这就需要用到本文要介绍的虚拟环境(Virtual Environment)了。Python 虚拟环境是一个隔离的环境，可以独立安装和管理依赖包，而不会影响全局的 Python 环境或其他项目。

我们可使用 Python 提供的 `venv` 模块来创建虚拟环境。

## 创建虚拟环境

  ```bash
  python3 -m venv myenv
  ```

- `myenv` 是虚拟环境的目录名，可以根据需要修改。
- `venv` 会在该目录(`myenv`)下创建独立的 Python 解释器和 `pip` 包管理器。

## 激活虚拟环境

Linux/macOS:

```bash
source myenv/bin/activate
```

Windows (cmd):

```cmd
myenv\Scripts\activate
```

Windows (PowerShell):

```powershell
.\myenv\Scripts\Activate.ps1
```

激活后，命令行前面会显示环境名，如 `(myenv)`，表示当前正在使用该虚拟环境。你需要使用那个环境，就激活哪个，很方便。多个虚拟环境可以同时使用，互不影响。

## 使用虚拟环境

虚拟环境创建并激活后，就可以使用了

例如，我在当前虚拟环境中使用 `pip` 安装依赖包，所有的包都会被安装在当前虚拟环境中，不会影响系统全局环境。

```bash
pip install git-filter-repo
```

`git-filter-repo` 将只安装在当前的虚拟环境中。验证也很简单，在不同的虚拟环境或系统环境中使用 `pip list` 查看各自已经安装的依赖包就能看出。

## 退出虚拟环境

```bash
deactivate
```

## 删除虚拟环境

虚拟环境的删除很简单，退出后直接删除它的目录即可，如：

```bash
rm -rf myenv
```

---

附：实用命令速查

| 操作                | 命令                                    |
|---------------------|----------------------------------------|
| 创建虚拟环境        | `python3 -m venv myenv`                  |
| 激活虚拟环境 (Linux/macOS) | `source myenv/bin/activate`       |
| 激活虚拟环境 (Windows)    | `myenv\Scripts\activate`           |
| 安装依赖包          | `pip install package_name`               |
| 查看已安装的包      | `pip list`                               |
| 导出依赖列表        | `pip freeze > requirements.txt`          |
| 安装依赖列表        | `pip install -r requirements.txt`        |
| 退出虚拟环境        | `deactivate`                             |
| 删除虚拟环境        | `rm -rf myenv`                           |

注：创建和管理虚拟环境还可用其他工具如 `virtualenv` 和 `pipenv`。

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