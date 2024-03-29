# Testing Python Installation with OS

[Index](index.md)

Note: This article was written in 2021 and edited in 2023, so some version values are very old.

Most of the time, the OS would integrate Python in some version. We can check the version first. If Python is not installed, we can install it then.

## Environment

### MacOS

``` plaintext
% python --version
Python 2.7.16
% python3 --version
Python 3.7.3
```

### Ubuntu

``` plaintext
$ python --version
Python 2.7.18
$ python3 --version
Python 3.8.6
```

### Windows

We can use ``py`` instead of ``python`` or ``python3`` with Git Bash, Power Shell or CMD on Windows.

The following is using Git Bash.

If Python is not installed:

``` plaintext
$ py hello.py
Python was not found; run without arguments to install from the Microsoft Store, or disable this shortcut from Settings > Manage App Execution Aliases.
```

When ``Python`` is installed, it shows:

``` plaintext
$ py --version
Python 3.8.5
```

If the script contains ``#!/usr/bin/env python``, it should be at the top of the script. It works with Windows too.
