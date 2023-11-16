# Merge Two Directories

今天工作上有个需求：合并两个目录，两个目录的子目录和文件都保留，同名的目录和文件也合并。

如果直接用系统的 `mv` 命令，可能会碰到报错：

```plaintext
$ mv a/* A -f
mv: cannot move 'a/b' to 'A/b': File exists
```

如上所示，即使加了 `force` 参数 `-f` 也不行。

看来不能通过一行简单的命令来实现，那就考虑用 Python 脚本吧。

自己写？怎么可能，这么清楚的需求，找 ChatGPT 最简单。

## 问

请写一段 Python3 script, 合并两个目录，如果有同名的子目录，也合并，如果子目录还有子目录，也合并，以此类推。 合并后，将源目录和文件删掉，只保留目标目录和文件，谢谢。

## 答

```python
import os
import shutil

def merge_directories(source_dir, target_dir):
    for item in os.listdir(source_dir):
        source_item = os.path.join(source_dir, item)
        target_item = os.path.join(target_dir, item)
        
        if os.path.isdir(source_item):
            if os.path.exists(target_item):
                merge_directories(source_item, target_item)
            else:
                shutil.move(source_item, target_dir)
        else:
            shutil.move(source_item, target_dir)
    
    os.rmdir(source_dir)

source_directory = 'path/to/source/directory'
target_directory = 'path/to/target/directory'

merge_directories(source_directory, target_directory)
```

请将`path/to/source/directory`替换为源目录的路径，将`path/to/target/directory`替换为目标目录的路径。运行此脚本后，源目录和文件将被删除，只保留目标目录和文件。

## 问

请继续改进代码，如果 target 目录里已经同名文件，就跳过，但通过屏幕告诉用户哪些文件没有移动。

## 答

```python
import os
import shutil

def merge_directories(source_dir, target_dir):
    for item in os.listdir(source_dir):
        source_item = os.path.join(source_dir, item)
        target_item = os.path.join(target_dir, item)
        
        if os.path.isdir(source_item):
            if os.path.exists(target_item):
                if os.path.isdir(target_item):
                    merge_directories(source_item, target_item)
                else:
                    print(f"File {item} already exists in target directory, skipping...")
            else:
                shutil.move(source_item, target_dir)
        else:
            if os.path.exists(target_item):
                print(f"File {item} already exists in target directory, skipping...")
            else:
                shutil.move(source_item, target_dir)
    
    os.rmdir(source_dir)

source_directory = 'path/to/source/directory'
target_directory = 'path/to/target/directory'

merge_directories(source_directory, target_directory)
```

在这个改进的代码中，我们增加了对目标目录中已经存在的同名文件的处理。如果目标目录中已经存在同名文件，就会在屏幕上提示用户，并跳过移动这个文件。这样用户就可以知道哪些文件没有被移动。

## 问

执行时，出现类似的报错：

File hello1.text already exists in target directory, skipping...
Traceback (most recent call last):
File "merge2.py", line 30, in <module>
merge_directories(source_directory, target_directory)
File "merge2.py", line 14, in merge_directories
merge_directories(source_item, target_item)
File "merge2.py", line 25, in merge_directories
os.rmdir(source_dir)
OSError: [Errno 39] Directory not empty: '/home/aaa/sandbox/test/a/b'

## 答

