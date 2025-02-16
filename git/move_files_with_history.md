# Move Files Between Git Repositories While Preserving History

[Index](index.md)

There are two tools available to move files and directories between Git repositories while presering history:

- `filter-branch`
- `filter-repo` ([official site](https://github.com/newren/git-filter-repo))

`filter-branch` is an older built-in tool, but Git no longer recommends using it. It's slow and prone to errors. In this article, we will use `filter-repo`, a modern and effient tool for the task.

## Demo

- Source: `source.git:/hello/world`
- Target: `target.git:/hello/world`

In this demo, we will move the directory `hello/world` from `source.git` to `target.git` while preserving its commit history.

## Step-by-Step Solution

Filter the source directory along with its history and push the result, then fetch it into the target and merge the result.

### Step 1: Install `filter-repo`

First, ensure you have Python and `pip` installed on your system. Then, install `git-filter-repo` tool with:

```bash
pip3 install git-filter-repo
```

### Step 2: Filter Source Repository

Filter the source directory along with the history.

Create a new branch in the source repository to work with:

```bash
cd /path/to/source-repository
git checkout main
git pull
git checkout -b temp-branch
```

Next, filter out the desired path. The following command will remove all files and directories except `hello/world`:

```bash
git filter-repo --path hello/world --force
```

### Step 3: Push to Target Repository

Now, push the filtered branch to the target repository:

```bash
git remote add target <target-repo-url>
git push target temp-branch
```

### Step 4: Pull and Merge in Target Repository

In the target repository, pull the new branch:

```bash
cd /path/to/target-repository
git pull origin
git checkout temp-branch
```

Now, merge the branch into `main` branch:

```bash
git checkout main
git merge temp-branch --allow-unrelated-histories
```

If there are conflicts, resolve them, then push the changes:

```bash
git push origin main
```

## Addditional Notes

`--invert-paths`: Invert the selection of files from the specified --path-{match,glob,regex} options below, i.e. only select files matching none of those options.

```bash
git filter-repo --path <file-or-directory-path> --invert-paths
```

It will only remove `<file-or-directory-path>` and preserve all the other files/directories.

## Conclusion

Using `git filter-repo`, we can effectively move specific files or directories between repositories while preserving their history. This method allows for flexible, clean history management with including unnecessary files.
