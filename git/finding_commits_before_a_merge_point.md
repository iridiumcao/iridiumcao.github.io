<script type="module">
    import mermaid from 'https://cdn.jsdelivr.net/npm/mermaid@11/dist/mermaid.esm.min.mjs';
    mermaid.initialize({ startOnLoad: true });
</script>

# Finding Commits Before a Merge Point in Git

[Index](index.md)

This guide explains how to use Git's relative reference syntax to locate commits before a merge point in a branch's history.

Consider the following commit history for the `master` branch, which includes a merge from the `temp` branch:

```plaintext
$ git log --oneline --graph
* f121040 (HEAD -> master) 5
*   b4d4109 Merge branch 'temp'
|\
| * 9463330 (temp) b
| * 1c57deb a
* | 76b4746 4
* | a69fb73 3
|/
* 837f54f 2
* 518575a 1
```

The `temp` branch, with commits `a` and `b`, was merged into `master`. The commit `2` is the divergence point (where `temp` branched off from `master`), and the merge commit is between commits `4` and `5`.

<div class="mermaid">
%%{init: { 'gitGraph': {'mainBranchName': 'master'} }}%%
gitGraph BT:
    commit id: "1"
    commit id: "2"
    branch temp
    checkout temp
    commit id: "a"
    commit id: "b"
    checkout master
    commit id: "3"
    commit id: "4"
    merge temp id: "merge commit"
    commit id: "5"
</div>

The current HEAD is at commit `5`:

```bash
$ git show HEAD --oneline --no-patch
f121040 (HEAD -> master) 5
```

<div class="mermaid">
%%{init: { 'gitGraph': {'mainBranchName': 'master'} }}%%
gitGraph BT:
    commit id: "1"
    commit id: "2"
    branch temp
    checkout temp
    commit id: "a"
    commit id: "b"
    checkout master
    commit id: "3"
    commit id: "4"
    merge temp id: "merge commit"
    commit id: "5" type: HIGHLIGHT
</div>

In Git, you can use the `^` operator to reference a commit’s parent. For example, to view the direct parent of the current HEAD:

```bash
$ git show HEAD^ --oneline --no-patch
b4d4109 Merge branch 'temp'
```

<div class="mermaid">
%%{init: { 'gitGraph': {'mainBranchName': 'master'} }}%%
gitGraph BT:
    commit id: "1"
    commit id: "2"
    branch temp
    checkout temp
    commit id: "a"
    commit id: "b"
    checkout master
    commit id: "3"
    commit id: "4"
    merge temp id: "merge commit" type: HIGHLIGHT
    commit id: "5"
</div>

This output confirms that the parent of commit `5` is the merge commit, where `temp` was merged into `master`.

To navigate further back, you can chain ^ operators. For example, to reach the parent of the merge commit along the main branch:

```bash
$ git show HEAD^^ --oneline --no-patch
76b4746 4
```

<div class="mermaid">
%%{init: { 'gitGraph': {'mainBranchName': 'master'} }}%%
gitGraph BT:
    commit id: "1"
    commit id: "2"
    branch temp
    checkout temp
    commit id: "a"
    commit id: "b"
    checkout master
    commit id: "3"
    commit id: "4" type: HIGHLIGHT
    merge temp id: "merge commit"
    commit id: "5"
</div>

The `^` operator is equivalent to `^1`, so `HEAD^1^1` can be simplified to `HEAD^^`. Alternatively, you can use the `~` operator to specify the nth ancestor along the first parent: `HEAD~n`. The following commands are equivalent:

```bash
$ git show HEAD^1^1 --oneline --no-patch
76b4746 4
$ git show HEAD^^ --oneline --no-patch
76b4746 4
$ git show HEAD~2 --oneline --no-patch
76b4746 4
```

A merge commit has multiple parents. In this case, the merge commit (`b4d4109`) has two parents: `4` (first parent, from `master`) and `b` (second parent, from `temp`). The commands above follow the first parent (`4`). To access the second parent (`b`), use `^2`:

```bash
$ git show HEAD^^2 --oneline --no-patch
9463330 (temp) b
```

<div class="mermaid">
%%{init: { 'gitGraph': {'mainBranchName': 'master'} }}%%
gitGraph BT:
    commit id: "1"
    commit id: "2"
    branch temp
    checkout temp
    commit id: "a"
    commit id: "b" type: HIGHLIGHT
    checkout master
    commit id: "3"
    commit id: "4"
    merge temp id: "merge commit"
    commit id: "5"
</div>

To navigate further back along the `temp` branch to commit `a`, use:

```bash
$ git show HEAD^^2^ --oneline --no-patch
1c57deb a
```

Alternatively, these commands are equivalent:

```bash
$ git show HEAD^^2~1 --oneline --no-patch
1c57deb a
$ git show HEAD~1^2~1 --oneline --no-patch
1c57deb a
```

<div class="mermaid">
%%{init: { 'gitGraph': {'mainBranchName': 'master'} }}%%
gitGraph BT:
    commit id: "1"
    commit id: "2"
    branch temp
    checkout temp
    commit id: "a" type: HIGHLIGHT
    commit id: "b"
    checkout master
    commit id: "3"
    commit id: "4"
    merge temp id: "merge commit"
    commit id: "5"
</div>

By combining `^` and `~` with parent indices, you can precisely navigate to any commit in the history relative to the current HEAD.
