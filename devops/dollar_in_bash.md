# Using Special Variables in Bash Scripts

[Index](index.md)

Here is an example of how Bash scripts utilize certain special variables:

```bash
#!/bin/bash

# Display the process ID of the current script
echo "Process ID: $$"

# Display the path of the current script
echo "Current script path: $0"

# Display the number of arguments passed to the script
echo "Number of arguments: $#"

# Display the first and second arguments
echo "First argument: $1"
echo "Second argument: $2"

# Display all arguments
echo "List of all arguments: $@"

# Display all arguments as a single string
echo "All arguments as a string: $*"

# Iterate over each argument
params=$@
for param in $params; do
  echo "Parameter: $param"
done

# Check if the first argument is 123
# Exit with status 0 if true, 1 otherwise
if [[ $1 = 123 ]]; then
  echo "Exit status: $?"
  exit 0
else
  echo "Exit status: $?"
  exit 1
fi
```

When running the script with a few arguments, you can expect the following output:

```plaintext
$ ./hello003.sh arg1 arg2 arg3
Process ID: 640234
Current script path: ./hello003.sh
Number of arguments: 3
First argument: arg1
Second argument: arg2
List of all arguments: arg1 arg2 arg3
All arguments as a string: arg1 arg2 arg3
Parameter: arg1
Parameter: arg2
Parameter: arg3
Exit status: 1
```

This script demonstrates the use of special variables in Bash, such as `$$`, `$0`, `$#`, `$1`, `$2`, `$@`, and `$*`. These variables contain useful information about the script itself and the arguments that are passed to it.
