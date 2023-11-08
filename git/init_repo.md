# How to Create a New Repository

[Index](index.md)

To create a new Git repository, you have two options: starting from scratch or basing it on an existing repository.

## Bare Repository (on Server Host)

Set up a repository on the server host by running the following command:

```plaintext
git init helloworld.git --bare
```

Alternatively, you can use the following commands:

```plaintext
mkdir helloworld.git
cd helloworld.git
git init --bare
```

A bare repository is typically named as "repo_name.git".

## Local Repository (as Client)

Create a repository as a workspace on your local machine by running the following command:

```plaintext
git init helloworld
```

Alternatively, you can use the following commands:

```plaintext
mkdir helloworld
cd helloworld
git init
```

By following these steps, you can create a new repository either on the server host or on your local machine.

## Clone

If you require to work with the existing code, you have the option to clone the current repository and proceed from there.

### 1. Clone a repository to workspace

This is the default way to clone.

```bash
git clone -git@github.com:iridiumcao/iridiumcao.github.io.git
```

or

```bash
git clone -git@github.com:iridiumcao/iridiumcao.github.io.git another_dir
```

### 2. Clone a bare repository

```bash
git clone --bare git@github.com:iridiumcao/iridiumcao.github.io.git
```

> `--bare`
>
> Make a bare Git repository. That is, instead of creating `<directory>` and placing the administrative files in `<directory>/.git`, make the `<directory>` itself the `$GIT_DIR`. This obviously implies the `--no-checkout` because there is nowhere to check out the working tree. Also the branch heads at the remote are copied directly to corresponding local branch heads, without mapping them to `refs/remotes/origin/`. When this option is used, neither remote-tracking branches nor the related configuration variables are created.
>
> [ref](https://www.git-scm.com/docs/git-clone)

### 3. Clone a repository as a mirror

```bash
git clone --mirror git@github.com:iridiumcao/iridiumcao.github.io.git
```

> `--mirror`
>
> Set up a mirror of the source repository. This implies `--bare`. Compared to `--bare`, `--mirror` not only maps local branches of the source to local branches of the target, it maps all refs (including remote-tracking branches, notes etc.) and sets up a refspec configuration such that all these refs are overwritten by a `git remote update` in the target repository.
>
> [ref](https://www.git-scm.com/docs/git-clone)

### 4. shallow clone

In some cases, the entire history of a repository may not be necessary. In such situations, a user can opt for a shallow clone by specifying the clone depth.

```bash
git clone --depth=1 git@github.com:iridiumcao/iridiumcao.github.io.git
```

> `--depth <depth>`
>
> Create a shallow clone with a history truncated to the specified number of commits. Implies `--single-branch` unless `--no-single-branch` is given to fetch the histories near the tips of all branches. If you want to clone submodules shallowly, also pass `--shallow-submodules`.
>
> [ref](https://www.git-scm.com/docs/git-clone)