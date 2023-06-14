# Retrieve Substring in Bash Shell Script

Get the original string: ${var_name}.

```plaintext
$ a='abc123'
$ echo $a
abc123
```

Replace a part of ${var_name}:

```plaintext

Removes all digit characters that are replaced with empty

$ echo ${a//[0-9]/}
abc
```

Removes all non-digit characters that are replaced with empty

```plaintext
$ echo ${a//[!0-9]/}
123
```

Replace digits with 'dd'

```plaintext
$ echo ${a//[0-9]/dd}
abcdddddd
```

Ref: <https://stackoverflow.com/questions/13210880/replace-one-substring-for-another-string-in-shell-script>


Another example. Retrieve digits at the end of string. Help from ChatGPT.

Question. Can you please express the following commands and outputs.

```plaintext
$ b='a2b23c234'
$ echo $b
a2b23c234
$ echo ${b##*[!0-9]}
234
```

Answer.

The first command sets the variable `b` to the string `a2b23c234`

The second command, `echo $b`, outputs the value of the variable `b`:`a2b23c234` 

The third command, `echo ${b##*[!0-9]}`, outputs the numeric characters at the end of the variable `b`, which is234

Explanation of the third command:
- `${b##*[!0-9]}` is a parameter expansion that removes the longest substring matching the pattern `*[!0-9]` from the beginning of the variable `b`.
- The pattern `*[!0-9]` matches any sequence of characters that does not end with a numeric digit.
- Therefore, the parameter expansion removes all non-numeric characters from the beginning of the string, leaving only the numeric characters at the end.