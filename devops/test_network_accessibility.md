# Testing Network Accessibility in an Intranet with Bash Script

[Index](index_en.md)

there are two hosts in the same intranet:

- host A: 192.168.0.100
- host B: 192.168.0.102

Here is an example to test network accessibility in bash script.
It runs on host A.
If A can access B, it returns "OK", or returns "Failed"

## Solution

```bash
#!/usr/bin/env bash

ping -c 1 192.168.0.102 > /dev/null
if [ $? -eq 0 ]; then
  echo "OK"
else
  echo "Failed"
fi
```

## Details

### `ping -c`

```plaintext
-c count
      Stop after sending count ECHO_REQUEST packets. With deadline option, ping waits for count ECHO_REPLY packets, until the timeout expires.
```

### `/dev/null`

> What is /dev/null?
>
> It is a virtual device, which has a special property: Any data written to /dev/null vanishes or disappears. Because of this characteristic, it is also called bitbucket or blackhole.

Quoted from <https://www.geeksforgeeks.org/what-is-dev-null-in-linux/>

### `$?`

> This is the exit status of the last executed command.
>
> For example the command true always returns a status of 0 and false always returns a status of 1:

```bash
true
echo $? # echoes 0
false
echo $? # echoes 1
```

Quoted from <https://stackoverflow.com/questions/7248031/meaning-of-dollar-question-mark-in-shell-scripts>

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