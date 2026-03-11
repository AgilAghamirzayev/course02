# Git and GitHub Interview Questions and Answers

This document provides common Git and GitHub interview questions with short, clear, and practical answers.

## 1. What is Git?
Git is a distributed version control system. It helps developers track code changes, restore previous versions, and collaborate efficiently.

## 2. What is GitHub?
GitHub is a cloud-based platform for hosting Git repositories, collaboration, code reviews, and project management workflows.

## 3. What is the difference between Git and GitHub?
Git is the version control tool that runs locally. GitHub is an online service that hosts Git repositories and enables team collaboration.

## 4. What is a repository?
A repository (repo) is a project folder that contains files, commit history, and Git metadata.

## 5. What is a commit?
A commit is a snapshot of changes at a specific point in time. Each commit has a unique hash and a commit message.

## 6. What is the staging area?
The staging area is an intermediate step before committing. `git add` moves selected changes into this area.

## 7. What is the difference between `git add` and `git commit`?
`git add` stages changes. `git commit` records the staged changes into repository history.

## 8. Why do we use `git status`?
`git status` shows the current state of the repository, including modified, staged, and untracked files.

## 9. What does `git log --oneline` show?
It shows commit history in a compact format: short hash plus commit message.

## 10. What is a branch?
A branch is an independent line of development. It allows you to work on features without affecting `main`.

## 11. What do `git checkout -b` and `git switch -c` do?
Both commands create a new branch and switch to it. `git switch -c` is the modern and clearer syntax.

## 12. What is merge?
Merge combines changes from one branch into another, commonly from a feature branch into `main`.

## 13. When does a merge conflict happen?
A merge conflict occurs when the same part of a file is changed differently in separate branches and Git cannot auto-resolve it.

## 14. What is the difference between `git fetch` and `git pull`?
`git fetch` downloads remote updates without applying them.  
`git pull` performs fetch and then merges (or rebases) those updates into the current branch.

## 15. Why do we use `git stash`?
`git stash` temporarily saves unfinished changes so you can switch branches or handle urgent tasks safely.

## 16. What does `git stash pop` do?
It reapplies the most recent stashed changes and removes that stash entry.

## 17. What does `git reset --soft HEAD~1` do?
It removes the last commit but keeps all changes in a staged state.

## 18. What does `git reset --hard HEAD~1` do?
It removes the last commit and discards associated local changes. This is destructive and should be used carefully.

## 19. What is the difference between `git revert` and `git reset`?
`git revert` creates a new commit that undoes a previous commit and keeps history intact.  
`git reset` moves the branch pointer backward and can rewrite history.

## 20. What does `git clone` do?
`git clone` creates a full local copy of a remote repository, including commit history.

## 21. What is the difference between `fork` and `clone`?
A fork is a server-side copy of a repository in your GitHub account.  
A clone is a local copy of a repository on your machine.

## 22. What is `.gitignore` used for?
`.gitignore` defines files and folders Git should not track, such as build outputs, logs, and sensitive config files.

## 23. What is `origin` in Git?
`origin` is the default name for a remote repository, usually the main remote source for push and pull operations.

## 24. What is `HEAD` in Git?
`HEAD` is a reference to your current checkout position, typically the latest commit on the active branch.

## 25. What makes a good commit message?
A good commit message is short, specific, and action-oriented.  
Example: `fix: handle null response in login service`.
