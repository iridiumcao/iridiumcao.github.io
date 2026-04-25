# Exporting and Importing Python Packages

[Index](index.md)

To rebuild a Python environment, we need to copy the Python package dependencies. Here's how.

## 1. Export Package List with `pip3 freeze`

```plaintext
$ pip3 freeze
psycopg2==2.9.6
pywin32==305
vboxapi==1.0
```

Save the above output to a plain text file, assuming it is `requirements.txt`, which will be used by `pip3 install`.

Note that `pip3 list` shows packages too, but it cannot be imported by `pip3 install`.

## 2. Install the Package List

```plaintext
pip3 install -r requirements.txt
```

## 3. Other Information

### 3.1. Help Document

```plaintext
$ pip3 install --help

Usage:
...
  pip3 install [options] -r <requirements file> [package-index-options] ...
...

Description:
...

  pip also supports installing from "requirements files", which provide
  an easy way to specify a whole environment to be installed.

Install Options:
  -r, --requirement <file>    Install from the given requirements file. This
                              option can be used multiple times.
...
```

### 3.2. `pip3 list`

The output is not able to feed to `pip3 install`.

```plaintext
$ pip3 list
Package    Version
---------- -------
pip        23.1.2
psycopg2   2.9.6
pywin32    305
setuptools 65.5.0
vboxapi    1.0
vboxapi    1.0
vboxapi    1.0

[notice] A new release of pip is available: 23.1.2 -> 23.2.1
[notice] To update, run: python.exe -m pip install --upgrade pip
```

<script src="https://giscus.app/client.js"
        data-repo="iridiumcao/iridiumcao.github.io"
        data-repo-id="MDEwOlJlcG9zaXRvcnkyOTUwNTIyODQ="
        data-category="Announcements"
        data-category-id="DIC_kwDOEZYj_M4Cxfqj"
        data-mapping="pathname"
        data-strict="0"
        data-reactions-enabled="1"
        data-emit-metadata="0"
        data-input-position="bottom"
        data-theme="preferred_color_scheme"
        data-lang="en"
        crossorigin="anonymous"
        async>
</script>