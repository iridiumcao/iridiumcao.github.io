# How to Retrieve the Email of a Commit's Author

[Index](index_en.md)

To retrieve the email of a commit's author in Git, there are a few commands that you can use:

## 1. `git log`

To fetch the email of the author of the last commit, you can use the following command:

```plaintext
git log -1 --pretty=%ae
```

This will display the email address of the author of the most recent commit.

e.g.,

```plaintext
$ git log -1 --pretty=%ae
hello@world.hi
```

## 2. `git rev-list` or `git show`

If you want to fetch the email of the author of a specific commit, you can use either of the following commands:

```plaintext
git rev-list --pretty=format:%ae --max-count=1 <commit_hash>
```

or

```plaintext
git show -s --format=%ae <commit_hash>
```

Replace `<commit_hash>` with the hash of the commit you want to retrieve the author's email address from.

The first command `git rev-list` or `git show` will display the email of the author of the specified commit.

e.g.,

```plaintext
$ git rev-list --pretty=format:%ae --max-count=1 6efd100a8004191ddfd9
commit 6efd100a8004191ddfd9
hello@world.hi
```

or

```plaintext
$ git show -s --format=%ae 6efd100a8004191ddfd9
hello@world.hi
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