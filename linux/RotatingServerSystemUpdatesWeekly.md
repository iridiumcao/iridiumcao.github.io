# Rotating Server System Updates Weekly

There are 5 servers, s1, s2, s3, s4, and s5.
One of them will be updated each Monday. They are updated rotately.

e.g., the updated sequence is as:

* Monday, Week 1: s1
* Monday, Week 2: s2
* Monday, Week 3: s3
* Monday, Week 4: s4
* Monday, Week 5: s5
* Monday, Week 6: s1
* Monday, Week 7: s2
* ...

The servers hostname are:

* s1: Herbert
* s2: Charles
* s3: Alice
* s4: Bob
* s5: Hanmeimei

## Analysis

We can create an array to take the list of servers and update them per its index.

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

# the number of hosts is the length of the list
host_list_size=${#host_list[@]}

# date +%s,  %s   seconds since 1970-01-01 00:00:00 UTC
# 1 week = 60 * 60 * 24 * 7 seconds
# $host_list_size, the number of hosts 
# $(date +%s) % (60 * 60 * 24 * 7 * $host_list_size), the remainder that ...
# $(date +%s) % (60 * 60 * 24 * 7 * $host_list_size) / (60 * 60 * 24 * 7), to get the week series of current time
week_round=$(($(date +%s) % (60 * 60 * 24 * 7 * $host_list_size) / (60 * 60 * 24 * 7)))

if [[ ${host_list[$week_round]} == $host_ip ]]; then
    test.sh &> /tmp/test_$(date +"%Y%m%d").log
fi

```

Set a crontak weekly on every host in the list:

```plaintext
0 14 * * 5 the_above_script.sh &>/dev/null
```
