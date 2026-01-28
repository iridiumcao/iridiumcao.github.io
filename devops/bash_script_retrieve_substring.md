# Extracting Substrings in Bash Shell Scripts

[Index](index_en.md)

Obtain the original string: `${var_name}`.

```plaintext
$ a='abc123'
$ echo $a
abc123
```

Modify a section of `${var_name}`:

Remove all digit characters and replace them with an empty string

```plaintext
$ echo ${a//[0-9]/}
abc
```

Remove all non-digit characters and replace them with an empty string

```plaintext
$ echo ${a//[!0-9]/}
123
```

Replace digits with 'dd'

```plaintext
$ echo ${a//[0-9]/dd}
abcdddddd
```

Reference: <https://stackoverflow.com/questions/13210880/replace-one-substring-for-another-string-in-shell-script>

Another example. Extract digits at the end of a string. Assisted by ChatGPT.

Question: Can you please explain the following commands and outputs?

```plaintext
$ b='a2b23c234'
$ echo $b
a2b23c234
$ echo ${b##*[!0-9]}
234
```

Answer:

The first command assigns the variable `b` the value `a2b23c234`

The second command, `echo $b`, displays the value of the variable `b`: `a2b23c234`

The third command, `echo ${b##*[!0-9]}`, displays the numeric characters at the end of the variable `b`, which is 234

Explanation of the third command:

- `${b##*[!0-9]}` is a parameter expansion that removes the longest substring matching the pattern `*[!0-9]` from the beginning of the variable `b`.
- The pattern `*[!0-9]` matches any sequence of characters that does not end with a numeric digit.
- As a result, the parameter expansion removes all non-numeric characters from the beginning of the string, leaving only the numeric characters at the end.

---

This article has been rewritten using GPT-4. [Source](https://poe.com/s/pOKG6Tqe9rzmAHChxDmQ).

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