# How to check if a git branch exists in the local/remote repository?

How can one verify the existence of a git branch in a local or remote repository? The article presents two bash script functions that can be used for this purpose.

Source code can be downalod from [gist.github.com](https://gist.github.com/iridiumcao/714d3d0a9137ce614c26e4e10d185291).

## 1. To check if the branch in the local repository

```bash
# Local:
# https://stackoverflow.com/questions/21151178/shell-script-to-check-if-specified-git-branch-exists
# test if the branch is in the local repository.
# return 1 if the branch exists in the local, or 0 if not.
function is_in_local() {
    local branch=${1}
    local existed_in_local=$(git branch --list ${branch})

    if [[ -z ${existed_in_local} ]]; then
        echo 0
    else
        echo 1
    fi
}
```

## 2. To check if the branch in the remote repository

```bash
# Remote
# Ref: https://stackoverflow.com/questions/8223906/how-to-check-if-remote-branch-exists-on-a-given-remote-repository
# test if the branch is in the remote repository.
# return 1 if its remote branch exists, or 0 if not.
function is_in_remote() {
    local branch=${1}
    local existed_in_remote=$(git ls-remote --heads origin ${branch})

    if [[ -z ${existed_in_remote} ]]; then
        echo 0
    else
        echo 1
    fi
}
```

---

This artical was post on [dev.to](https://dev.to/iridiumcao/how-to-check-if-a-git-branch-exists-in-the-local-remote-repository-3gkd) and [OSC](https://my.oschina.net/iridium/blog/3208407) as well.
