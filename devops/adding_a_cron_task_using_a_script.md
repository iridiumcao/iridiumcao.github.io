# Adding a Cron Task Using a Script

[Index](index_en.md)

To add a cron task item using a script, you can utilize the following script:

```bash
#!/bin/bash

# Define the crontab entry
CRONTAB_ENTRY="* * * * * echo \"hello, world!\" >> log_.txt 2>&1"

# Write the crontab entry to a temporary file
echo "$CRONTAB_ENTRY" > /tmp/my_cron

# Load the temporary crontab file
crontab /tmp/my_cron

# Remove the temporary file
rm /tmp/my_cron
```

Please note that running the above script will reset the crontab list, removing all previous items.

If you wish to create a log file for each day, you can replace the line:

```bash
CRONTAB_ENTRY="* * * * * echo \"hello, world!\" >> log_.txt 2>&1"
```

with:

```bash
CRONTAB_ENTRY="* * * * * echo \"hello, world!\" >> log_\$(date +\%Y\%m\%d).txt 2>&1"
```

Take note of how the Linux command is included within the crontask item above.

To view the current cron task list, you can use the command:

```plaintext
$ crontab -l
* * * * * echo "hello, world!" >> log_$(date +\%Y\%m\%d).txt 2>&1
```

## The Slash in Cron Task

```bash
CRONTAB_ENTRY="* * * * * echo \"hello, world!\" >> log_\$(date +\%Y\%m\%d).txt 2>&1"
```

Note that the slash before the dollar sign is essential in this command. If the slash is removed:

```bash
CRONTAB_ENTRY="* * * * * echo \"hello, world!\" >> log_$(date +\%Y\%m\%d).txt 2>&1"
```

The updated cron task list will appear as:

```plaintext
$ crontab -l
* * * * * echo "hello, world!" >> log_20230711.txt 2>&1
```

The cron task list is crucial for scheduling and automating tasks on a system.
It is important to ensure the correct syntax and formatting in the cron task list to ensure proper execution and logging of tasks.

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