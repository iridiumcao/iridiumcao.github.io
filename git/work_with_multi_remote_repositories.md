# Work with Multiple Remote Repositories

[Index](index.md)

Usually, a local git repository tracks a default remote repository named _origin_. However, we also needs to work with multiple remote repositories in some cases.

When we folk a project from GitHub and want to fetch the latest changes from the original project, or when we work with a git mirror, or we have two IP of a same repository and the connections are not stable, we would need it.

## Add Multiple Remote Repositories

E.g., we'll add another remote repository named `chengdu`:

```plaintext
$ git remote add chengdu ssh://git@192.168.0.5:2345/repos/demo.git
```

List all remote repositories:

```plaintext
$ git remote --v
chengdu  ssh://git@192.168.0.5:2345/repos/demo.git (fetch)
chengdu  ssh://git@192.168.0.5:2345/repos/demo.git (push)
origin  ssh://git@12.221.127.55:2345/repos/demo.git (fetch)
origin  ssh://git@12.221.127.55:2345/repos/demo.git (push)
```

The abbr command `git pull` is not allowed when there are multiple remote repositories. 

The remote repository must be filled in the command:

```plaintext
$ git pull chengdu master
```

or

```plaintext
$ git pull origin master
```

How to View the remote git URL?

List all remote repositories:

```plaintext
git remote -v
```

or list one:

* for 1.8: `git config --get remote.origin.url`
* for 2.X: `git remote get-url origin`
