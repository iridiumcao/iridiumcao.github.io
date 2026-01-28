# Merging Two Directories

[Index](index_en.md)

There's a requirment from work today: merge two directories, all files, including directories should be reserved, if files in same name exist in the two directories, save one of them. In short, it uses one directory to override the other.

If we try the command `mv`, it will raises an error:

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

As the above, it does not work even appending the `--force` (`-f`) parameter.

## `rsync`

```bash
rsync -a --remove-source-files demo3/ demo4/ && rm demo3 -rf
```

- `-a`:  This flag preserves file permissions, timestamps, and symbolic links (archive mode)
- `--remove-source-files`: It deletes each source file after a successful transfer, effectively turning it into a move operation.

After running `rsync`, `demo3/` will be left empty, so it needs `rm` to remove `demo3/`.

`mv` command failed because `mv` doesn't recursively merge non-empty directories by default—it treats them as simple moves and errors out when the target already exists and isn't empty. `rsync` handles the recursion and overwriting seamlessly.

## Python

`rsync` is wonderful, but it will remain some empty directories in `demo3`, let's try Python script:

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
