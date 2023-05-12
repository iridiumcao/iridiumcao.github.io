# The Way to Keep Git Branches Clean

[Home](index.md)

([Chinese](keeping_branches_clean_zh_CN.md))

## Goal

A feature branch should always incorporate the latest code of master branch, and the git tree should be clear.

## Issue

It is not difficult to achieve the above goal. You just need to continuously merge the latest code into the feature branch every day. However, the side effect of doing so is that the git history becomes messy. Commits on the feature branch are scattered and cannot be easily reviewed or organized for merge.

## Solution

When the workday begins, integrate the latest code of master branch.

Git Instructions

```plaintext
$ git stash // if needed
$ git checkout master 
$ git pull --rebase 
$ git checkout your_branch
$ git rebase master // solve conflict if needed
```

Before code pushed to remote, pull and integrate the latest code of the master branch and clear the git log.

Git Instructions:

```plaintext
$ git rebase -i HEAD~n // clear git log, n is the number of commits, starts from the last.
$ git checkout master
$ git pull --rebase
$ git checkout your_branch
$ git rebase master // solve the conflict if need
$ git push origin --delete your_branch // if this branch is in the remote repository
$ git push origin your_branch
```

To use rebase can reduce the number of commits, including merge significantly, but if a branch is behind the master branch for a long period, to use merge can reduce the difficulty of solving conflicts. In general, the merge commit from a feature branch into the master branch is meaningful, it’s a tag where a ticket starts and ends, but the reverse is not true, the merge commits from master into a feature branch is meaningless, but will mess the git tree.

Before you perform rebase or merge, you can use git checkout -b bak_branch to create a branch for bak, in case if there are too many conflicts.

If two or more folks share the same branch, you should be more careful when you perform rebase.

Solve conflicts while rebasing/merging
If there are conflicts while rebasing/merging, you can

1. Modify conflicted code
2. `$ git add the_file_you_changed`
3. `$ git rebase --continue`

If you want to abort the rebase, you can run this:

`$ git rebase --abort`

Clean local git repository

```plaintext
$ git remote prune origin
$ git gc --prune=now
```

Useful Resources:

1. Update the references of remote branches: `git remote prune origin` (from Curt Tudor’s mail)
2. Query your remote branches (Replace the last argument of grep to your own git name):
`git for-each-ref --format='%(committerdate)%09%(authorname)%09%(refname)' | sort -k5n -k2M -k3n -k4n | grep remotes | awk -F "\t" '{ printf "%-32s %-27s %s\n", $1, $2, $3 }' | grep Cao`
(from Robert Seaton’s mail)
3. A Normal Workflow of Git (in Chinese, by Ruan Yi Feng), [Git 使用规范流程（阮一峰）](http://www.ruanyifeng.com/blog/2015/08/git-use-process.html)
(`--force` is not recommended, it’s better to delete the remote branch and push it again to keep the commit log clear.)
4. [Git Protocol (by ThoughtBot)](https://github.com/thoughtbot/guides/tree/master/protocol/git) (A very helpful guide, highly recommend to read!)
5. [About Git rebase (from GitHub Help)](https://help.github.com/articles/about-git-rebase/)
6. [Rebase and fast-forwarding (from Eclipse Help)](
http://help.eclipse.org/juno/index.jsp?topic=%2Forg.eclipse.egit.doc%2Fhelp%2FEGit%2FGit_For_Eclipse_Users%2FGit-For-Eclipse-Users.html&cp=20_4_9&anchor=Rebasing_and_fast-forwarding)
(What’s a good practice to perform rebase)

![](images/git_threads.png)
