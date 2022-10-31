# Git Submodule Test

Assume three repositories: repoa, repob, repoc

* supermodule: repoa
* submodule: repob, repoc

## 1. Add submodules

Add a repository as the current repository's submodule.

e.g., change directory to repoa:

```bash
$ git submodule add ssh://cy@192.168.5.45/home/cy/repob
$ git submodule add ssh://cy@192.168.5.45/home/cy/repoc
```

`.gitmodules` is as the following:

```bash
$ cat .gitmodules
[submodule "repob"]
        path = repob
        url = ssh://cy@192.168.5.45/home/cy/repob
[submodule "repoc"]
        path = repoc
        url = ssh://cy@192.168.5.45/home/cy/repoc
```

## 2. Clone a repository with submodules

e.g., Clone a repository with its submodules:

```bash
$ git clone --recurse-submodules ssh://cy@192.168.5.45/home/cy/repoa
```

The above is a simple way. We can also clone supermodule and its submodules seprated, without parameter `--recurse-submodules`.

e.g.,

```bash
$ git clone ssh://cy@192.168.5.45/home/cy/repoa
$ git submodule init
$ git submodule update
```

more details:

```bash
$ git submodule init 
Submodule 'repob' (ssh://cy@192.168.5.45/home/cy/repob) registered for path 'repob'
Submodule 'repoc' (ssh://cy@192.168.5.45/home/cy/repoc) registered for path 'repoc'
$ git submodule update
Cloning into '/home/cy/sandbox/repoa/repob'...
Cloning into '/home/cy/sandbox/repoa/repoc'...
Submodule path 'repob': checked out '644355143d331c0dd2b37e8e090f8fabba2031e3'
Submodule path 'repoc': checked out '42b2b2369122f5cf25e4569011177caf58d01d5e'
```

`git submodule init` and `git submodule update` can be merged as `git submodule update --init`.

## 3. Use submodule for development

A feature in development would work with a special branch of submodules.

If submodules ara changed, the supermodule can detect it. The supermodule's repository holds the head commit hash code of the current submodules. The submodules are still independent.

You can change directory to submodules and switch to the proper branches and can work in the submodules directories as they are standalone repositories.

e.g., when a submodule changed:

When stepping into the submodule `repob`'s directory, it shows that its workspace is at commit `6443551`.

```bash
cy@cy:~/sandbox/repoa$ ls
hellogit  helloworld  repob  repoc
cy@cy:~/sandbox/repoa$ cd repob
cy@cy:~/sandbox/repoa/repob$ git branch
* (HEAD detached at 6443551)
  master
```

Switching to another branch to demonstrate changes on submodule. You can also make some changes on the current branch and commit.

```bash
cy@cy:~/sandbox/repoa/repob$ git checkout master
Previous HEAD position was 6443551 commit from branch another-b-branch
Switched to branch 'master'
Your branch is up to date with 'origin/master'.
cy@cy:~/sandbox/repoa/repob$ cd ..
cy@cy:~/sandbox/repoa$ git status
On branch master
Your branch is up to date with 'origin/master'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   repob (new commits)

no changes added to commit (use "git add" and/or "git commit -a")
```

In the supermode, it shows that the head commit of submodule is changed.

```bash
cy@cy:~/sandbox/repoa$ git diff
diff --git a/repob b/repob
index 6443551..337ce9e 160000
--- a/repob
+++ b/repob
@@ -1 +1 @@
-Subproject commit 644355143d331c0dd2b37e8e090f8fabba2031e3
+Subproject commit 337ce9e16cdd60ed6a5e3941f946741ae6549571

```

## 4. Not need to set branch of submodule

Per git's documents, we can set submodules branch. e.g.,

```bash
$ git submodule set-branch --branch another-b-branch repob/
```

The submodule's branch is appended to file `.gitsubmodes`:

```text
[submodule "repob"]
        path = repob
        url = ssh://cy@192.168.5.45/home/cy/repob
[submodule "repob/"]
        branch = another-b-branch
```

However, the block `[submodule]` is useless. Please ignore `[submodule]` in `.gitsubmodes`.

---

This is post to [CSDN](https://blog.csdn.net/caoi/article/details/127601327).