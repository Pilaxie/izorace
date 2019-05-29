# Izo Race

## Delete a remote branch
$ git push origin --delete <branch>
$ git push origin :<branch>

## Delete a local branch
$ git branch --delete <branch>
$ git branch -d <branch> # Shorter version
$ git branch -D <branch> # Force delete un-merged branches

## Delete a local remote-tracking branch
$ git branch --delete --remotes <remote>/<branch>
$ git branch -dr <remote>/<branch> # Shorter
$ git fetch <remote> --prune # Delete multiple obsolete tracking branches
$ git fetch <remote> -p # Shorter
