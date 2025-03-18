# How to Remove Large Files from Git History

[Index](index.md)

In a Git repository, large files, including those deleted from the workspace, continue to occupy disk space because they remain in the history. Sometimes, we may want to remove them to free up disk space and reduce network usage.

The approach is to first find these large files and then remove them.

## 1. Find the Large Files

To identify large files in your Git history, run the following command in your repository's root directory:

```bash
git rev-list --objects --all | git cat-file --batch-check='%(objectsize) %(rest)' | awk '$1 > 10485760 {print $2}'
```

This command:

- Lists all objects in the Git history (`git rev-list --objects --all`).
- Retrieves the size of each object in bytes (`git cat-file --batch-check`).
- Filters for files larger than 10 MB (10,485,760 bytes) using awk.

You can adjust the size threshold as needed, modifying the value 10485760 (e.g., 5242880 for 5 MB).

## 2. Remove the Files

We'll use git `filter-repo` to remove the identified files from the history. Follow the steps below.

### 2.1. Install `git-filter-repo`

If you've already installed `git-filter-repo`, you can skip this section.
`git-filter-repo` is a Python package that can be installed via `pip`. Run:

```bash
pip install git-filter-repo
```

If needed, upgrade `pip` first:

```bash
python3 -m pip install --upgrade pip
```

Verify the installation by checking the version: (This command should run a git repository's root directory)

```bash
git filter-repo --version
```

### 2.2. Backup the Git Repository (Optional)

This step is optional but recommended, as rewriting Git history is irreversible and can cause issues if something goes wrong. To back up your repository, copy it to a new directory:

```bash
cp -r <repository-path> <backup-path>
```

Replace `<repository-path>` with the path to your repository and `<backup-path>` with the backup location (e.g., `cp -r my-repo my-repo-backup`).

### 2.3. Remove the Files

Use `git filter-repo` to remove the identified large files from the history. Replace the paths below with the files or directories you want to remove:

```bash
git filter-repo --invert-paths \
                --path <path1> \
                --path <path2> \
                --force
```

e.g.

```bash
git filter-repo --invert-paths \
                --path directory1/to/delete/ \
                --path directory2/to/delete/ \
                --path file1/to/delete \
                --path file2/to/delete \
                --force
```

- `--invert-paths` tells `git filter-repo` to remove the specified paths from history.
- `--force` is required if the repository has already been rewritten or if there are other conflicts.

Warning: Rewriting Git history changes commit hashes, which can break collaboration. After completing this step, inform your team to re-clone the repository or force-pull (`git fetch && git reset --hard origin/main`).

### 2.4. Verify the Size

Verify that the repository size has decreased by comparing it to the backup:

```bash
du -sh <repository-path>
du -sh <backup-path>
```

The `du -sh` command displays the total disk usage of a directory in a human-readable format.
For example, if the original repository was 3 GB and is now 27 MB, the large files were successfully removed.

## Conclusion

By following these steps, you can free up disk space, reduce bandwidth usage, and improve repository performance. Remember to back up your repository and coordinate with your team, as rewriting history can impact collaboration.

To avoid large files in the future, consider using Git LFS (Large File Storage) to store them outside the main repository.
