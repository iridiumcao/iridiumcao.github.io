# Weekly Updates for Rotating Server System

In the current system, we have five servers, labeled as s1, s2, s3, s4, and s5.
One server is scheduled for an update every Monday, following a rotational pattern.

Here is an example of the update sequence:

* Week 1, Monday: s1
* Week 2, Monday: s2
* Week 3, Monday: s3
* Week 4, Monday: s4
* Week 5, Monday: s5
* Week 6, Monday: s1
* Week 7, Monday: s2
* ...

The hostnames assigned to the servers are as follows:

* s1: Herbert
* s2: Charles
* s3: Alice
* s4: Bob
* s5: Hanmeimei

## Methodology

We can implement this by creating an array to store the list of servers and then update each one according to its index.

```bash
#!/usr/bin/env bash

hostname=$(hostname)

declare -a host_list=(
    "Herbert"
    "Charles"
    "Alice"
    "Bob"
    "Hanmeimei"
)

# The size of the host list corresponds to the number of hosts
host_list_size=${#host_list[@]}

# Using date +%s to get the seconds since 1970-01-01 00:00:00 UTC
# A week is equal to 60 * 60 * 24 * 7 seconds
# $host_list_size is the number of hosts 
# $(date +%s) % (60 * 60 * 24 * 7 * $host_list_size) gives the remainder that determines the week series of current time
week_round=$(($(date +%s) % (60 * 60 * 24 * 7 * $host_list_size) / (60 * 60 * 24 * 7)))

if [[ ${host_list[$week_round]} == $hostname ]]; then
    test.sh &> /tmp/test_$(date +"%Y%m%d").log
fi

```

To ensure the script runs weekly on every host in the list, set a crontab as follows:

```plaintext
0 14 * * 1 the_above_script.sh &>/dev/null
```
Note that the '1' in the cron schedule represents Monday, ensuring the script runs at the start of every week.