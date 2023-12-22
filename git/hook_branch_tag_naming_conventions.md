# Update Git Branch/Tag Naming Conventions

[Index](index.md)

> Note. This issue is from today's work (2023.12.22).

We have run into issues related to special characters in git branch/tag names, which cause complications within the Linux/git shell environment and require escaping. To prevent these problems, we are revising the rules for branch/tag names to allow only alphanumeric characters (0-9, a-z, A-Z), dash (-), and underscore (_) characters.

Git hook script guidelines:

* Branch/tag names should exclusively contain alphanumeric characters (0-9, a-z, A-Z), dash (-), and underscore (_).
* Pushing will be rejected if a branch or tag name does not adhere to this rule.
* Deletion of branches or tags with invalid names will be allowed.

Hook `pre-receive` script:

```bash
#!/bin/bash
shopt -s nocasematch

while read oldrev newrev refname; do
  if [[ $newrev == "0000000000000000000000000000000000000000" ]]; then
    # Skip the name validation check for branch or tag deletion
    continue
  fi

  if [[ $refname =~ ^refs/heads/.* ]]; then
    branch_name=$(echo $refname | cut -d'/' -f3)
    if ! [[ $branch_name =~ ^[0-9a-zA-Z_-]+$ ]]; then
      echo "Error: Branch name $branch_name does not match the allowed characters [0-9a-zA-Z_-]"
      exit 1
    fi
  elif [[ $refname =~ ^refs/tags/.* ]]; then
    tag_name=$(echo $refname | cut -d'/' -f3)
    if ! [[ $tag_name =~ ^[0-9a-zA-Z_-]+$ ]]; then
      echo "Error: Tag name $tag_name does not match the allowed characters [0-9a-zA-Z_-]"
      exit 1
    fi
  fi
done

exit 0
```

In this script, the condition `[[ $newrev == "0000000000000000000000000000000000000000" ]]` checks if the new revision is all zeros, which is the case for branch or tag deletion. Condition `[[ $newrev =~ "000000000000000" ]]` can be an approximate replacement.
