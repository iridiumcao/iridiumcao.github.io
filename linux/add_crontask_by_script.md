# Add a crontask by Script

Add crontask item by script, we can use the following script:

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

Note. The crontab list will be reset by the above script, all old items will be cleaned.

If we want to create the log file by day, we can replace 

```bash
CRONTAB_ENTRY="* * * * * echo \"hello, world!\" >> log_.txt 2>&1"
```

by

```bash
CRONTAB_ENTRY="* * * * * echo \"hello, world!\" >> log_\$(date +\%Y\%m\%d).txt 2>&1"
```

Please note how to contain Linux command in the above crontask item.