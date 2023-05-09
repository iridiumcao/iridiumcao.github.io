# Clean Local Git Repository

Keeping your local repository clean is helpful to development work.

## 0. Clean Work Directory if necessary

```text
$ git stash
$ git clean -df
```

## 1. Clean Rubbish

```text
$ git gc
$ git prune
```

## 2. Clean the branches that are no longer in the remote repository

```text
$ git remote prune origin
```

## 3. Clean the tags that are no longer in the remote repository

```text
$ git fetch origin --prune --prune-tags --force

```

or

```text
$ git tag -d $(git tag)
$ git fetch --tags
```

Ref:
* [Remove local git tags that are no longer on the remote repository](https://stackoverflow.com/questions/1841341/remove-local-git-tags-that-are-no-longer-on-the-remote-repository)
* This blog is also post to [CSDN](https://blog.csdn.net/caoi/article/details/124492563?spm=1001.2014.3001.5501).