# Practical Git and GitHub Lesson (Step-by-Step)

This lesson introduces the core Git workflow from local setup to pushing code to GitHub.

## Learning Objectives

By the end of this lesson, students will be able to:

- Verify Git installation
- Configure Git identity
- Initialize a repository
- Track and commit changes
- Work with branches
- Connect a local project to GitHub and push code

## 1. Check if Git Is Installed

Run:

```bash
git --version
```

Example output:

```text
git version 2.43.0
```

If a version number appears, Git is installed correctly.

## 2. Configure Git (First-Time Setup)

Set your name:

```bash
git config --global user.name "Your Name"
```

Example:

```bash
git config --global user.name "Ismet"
```

Set your email:

```bash
git config --global user.email "ismet@example.com"
```

If you want to use a different name/email for only one project, go to that project directory and set local config (without `--global`):

```bash
cd /path/to/project
git config user.name "John Smith"
git config user.email "jsmith@seas.upenn.edu"
```

This affects only the current repository.

Verify configuration:

```bash
git config --list
```

Git stores this identity in your commits so authorship is clear.

## 3. Create a Project Folder

Create a new folder and move into it:

```bash
mkdir git-practice
cd git-practice
```

This folder will be your project workspace.

## 4. Initialize a Git Repository

Run:

```bash
git init
```

Example output:

```text
Initialized empty Git repository
```

Git creates a hidden `.git` directory that contains the repository history and metadata.

To display hidden files:

```bash
ls -a
```

## 5. Create a File

Create a file:

```bash
touch hello.txt
```

Add content to `hello.txt`:

```text
Hello Git
```

At this point, Git can see the file but is not tracking it yet.

## 6. Check Repository Status

Run:

```bash
git status
```

Example output:

```text
Untracked files:
  hello.txt
```

`hello.txt` is untracked until it is staged.

## 7. Stage the File

Add the file to the staging area:

```bash
git add hello.txt
```

To stage all new and modified files in the current directory, you can also use:

```bash
git add .
```

If you accidentally staged `hello.txt`, unstage it but keep your file changes:

```bash
git reset hello.txt
```

Check status again:

```bash
git status
```

Example output:

```text
Changes to be committed:
  new file: hello.txt
```

Staging prepares changes for the next commit.

## 8. Create the First Commit

Run:

```bash
git commit -m "First commit"
```

Example output:

```text
1 file changed, 1 insertion
```

A commit is a snapshot of your project at a specific point in time.

## 9. View Commit History

Run:

```bash
git log
```

For a compact history view, use:

```bash
git log --oneline
```

To visualize all branches in graph format, use:

```bash
git log --oneline --graph --all
```

Example output:

```text
commit a83f92d...
Author: Ismet <ismet@example.com>
Date: ...

    First commit
```

`git log` shows the full history of commits.

## 10. Modify the File

Update `hello.txt` with:

```text
Hello Git
Learning Git is fun
```

Check status:

```bash
git status
```

Example output:

```text
modified: hello.txt
```

Git detects the change immediately.

## 11. Stage the Updated File

```bash
git add hello.txt
```

If you changed multiple files, use:

```bash
git add .
```

## 12. Create a Second Commit

```bash
git commit -m "Update hello file"
```

View history again:

```bash
git log
```

Compact view:

```bash
git log --oneline
```

You should now see two commits.

## 13. See Line-by-Line Changes

Run:

```bash
git diff
```

`git diff` shows exact changes between versions.

## Undo Commands (Very Important)

Undo file changes:

```bash
git checkout -- file.txt
```

Undo the last commit but keep changes:

```bash
git reset --soft HEAD~1
```

Remove the last commit completely:

```bash
git reset --hard HEAD~1
```

Warning:

`--hard` permanently deletes uncommitted changes.

## 14. Create a Branch

Create a new branch only:

```bash
git branch feature-login
```

Create and switch in one command (classic):

```bash
git checkout -b feature-login
```

Create and switch in one command (modern):

```bash
git switch -c feature-login
```

List branches:

```bash
git branch
```

Example output:

```text
* main
  feature-login
```

Branches let you develop features without affecting `main`.

## 15. Switch to the Branch

Modern command:

```bash
git switch feature-login
```

Legacy equivalent:

```bash
git checkout feature-login
```

You are now working in the `feature-login` branch.

## Stash Commands (Temporary Save)

Sometimes you need to switch branches but have unfinished work.

Save temporary changes:

```bash
git stash
```

Restore stashed changes:

```bash
git stash pop
```

## 16. Merge the Branch

Switch back to `main`:

```bash
git checkout main
```

Merge `feature-login` into `main`:

```bash
git merge feature-login
```

Merging combines branch changes into the target branch.

## 17. Connect to a GitHub Repository

Add a remote repository:

```bash
git remote add origin https://github.com/username/git-practice.git
```

Verify remote configuration:

```bash
git remote -v
```

## 18. Fetch and Pull Remote Changes

Download remote changes without merging:

```bash
git fetch
```

Fetch and merge changes from `main`:

```bash
git pull origin main
```

## 19. Push to GitHub

```bash
git push -u origin main
```

`git push` uploads your local commits to GitHub.

## One-Sentence Summary

Git helps developers track changes, collaborate effectively, and maintain a complete project history.
