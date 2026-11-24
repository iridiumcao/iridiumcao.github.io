# Merging Two Directories

[Index](index.md)

At work today, I needed to merge two directories. The result had to preserve the files and subdirectories from both, with the source file taking precedence when the same relative path existed in both.

If we try the command `mv`, it raises an error:

Git Bash (Windows):

```plaintext
$ mv demo3/* demo4/ -f
mv: cannot move 'demo3/demo' to 'demo4/demo': Directory not empty
```

Or

Bash Shell on RockyLinux:

```plaintext
$ mv demo3/* demo4 -f
mv: cannot move 'demo3/demo' to 'demo4/demo': File exists
```

Adding `--force` (`-f`) still produces the same error.

## `rsync`

```bash
rsync -a --remove-source-files demo3/ demo4/ && rm demo3 -rf
```

- `-a`:  This flag preserves file permissions, timestamps, and symbolic links (archive mode)
- `--remove-source-files`: It deletes each source file after a successful transfer, effectively turning it into a move operation.

After running `rsync`, transferred files are removed from `demo3/`. The directory and its subdirectories remain.

`mv` command failed because `mv` doesn't recursively merge non-empty directories by default—it treats them as simple moves and errors out when the target already exists and isn't empty. `rsync` handles the recursion and overwriting seamlessly.

## Python

To remove the empty source directories as well, we can use a Python script:

```python
import shutil
import os

# Source and target directories
source_dir = 'demo3'
target_dir = 'demo4'

# Copy the entire directory tree, overwriting existing files/directories
shutil.copytree(source_dir, target_dir, dirs_exist_ok=True)

# Remove the source directory after successful copy (simulates move)
shutil.rmtree(source_dir)
```

It works perfectly as an improved version of `mv`.

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
        data-lang="en"
        crossorigin="anonymous"
        async>
</script>
