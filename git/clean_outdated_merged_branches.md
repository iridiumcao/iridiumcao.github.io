# Clean Outdated and Merged Branches

[Index](index.md)

Generally, a branch's deployment is merging it into the main branch ('main' or 'master'). After the deployment, the original branch should be deletd. However, some branches would be forgot being deleting.

This aritcle is aim to build a script to detect and delete the outdated (> 1 month) and merged branches in Python.

Known:

1. a local git repo path: /home/sandbox/test
2. its main branch is 'master'

Requirement:

1. Find the branches that were merged into branch master in its remote repository
2. If the commit date of the branch found by #1 is more that 1 month ago, delete the branch in the remote.

```python
#!/usr/bin/env python3

import datetime
import git

# Local repository path
repo_path = '/home/caoyi/sandbox/testrepo'
repo = git.Repo(repo_path)
repo.git.checkout('master')
repo.remotes.origin.pull()

# Get the remote branches merged into master
merged_branches = repo.git.branch('--remotes', '--merged', 'origin/master')
branches = merged_branches.split('\n')
branches = [branch.strip() for branch in branches if 'origin/master' not in branch]

cutoff_date = datetime.datetime.now() - datetime.timedelta(days=30)
cutoff_date = cutoff_date.replace(tzinfo=None)

for branch in branches:
    # Retrieve the commit date of the branch
    commit_date = repo.git.log('-1', '--format=%cd', branch)
    commit_date = datetime.datetime.strptime(commit_date, '%a %b %d %H:%M:%S %Y %z')
    commit_date = commit_date.replace(tzinfo=None)

    # Check if the commit date is more than 1 month ago
    if commit_date < cutoff_date:
        repo.git.push('origin', '--delete', branch)
        print(f"Deleted branch '{branch}'")
```
