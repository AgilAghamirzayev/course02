# Lesson 2 Practical Tasks - Git and GitHub

## Objective

The goal of this assignment is to practice real Git and GitHub workflows step by step, from basic commits to branch management, stash usage, and remote synchronization.

By completing these tasks, students will build confidence in daily development operations used in team projects.

## Repository Requirement

Use **one GitHub repository** for all three levels:

```text
git-github-practice
```

Recommended folder structure:

```text
easy/
medium/
advanced/
```

## Task 1 - Easy Level (Initialize, Commit, Push)

### Instructions

1. Create the project folder and initialize Git.
2. Create `easy/README.md` and write a short introduction (3-5 lines).
3. Stage all files:

```bash
git add .
```

4. Commit:

```bash
git commit -m "task1: add easy level files"
```

5. Check history:

```bash
git log --oneline
```

6. Push the repository to GitHub (`main` branch).

### Expected Result

- Repository is available on GitHub.
- At least one commit exists in `main`.
- `easy/README.md` is visible in the remote repository.

### Deliverable

Push your work and keep the repository link ready for Classroom submission.

## Task 2 - Medium Level (Branching and Merge)

### Instructions

1. Create and switch to a feature branch:

```bash
git switch -c feature-profile
```

2. Add these files:
   - `medium/profile.md`
   - `medium/checklist.md`
3. Write meaningful content in both files.
4. Stage and commit:

```bash
git add .
git commit -m "task2: add profile feature files"
```

5. Switch back to `main` and merge:

```bash
git switch main
git merge feature-profile
```

6. Show history graph:

```bash
git log --oneline --graph --all
```

7. Push updates to GitHub.

### Expected Result

- `feature-profile` branch is created and merged into `main`.
- `medium/` files exist on `main`.
- Commit history graph reflects branch workflow.

### Deliverable

Push all changes to GitHub and ensure the branch history is visible in the repository.

## Task 3 - Advanced Level (Stash, Undo, Fetch/Pull)

### Instructions

1. Create and switch to a new branch:

```bash
git switch -c feature-notes
```

2. Create `advanced/notes.md` and add unfinished work.
3. Temporarily save your unfinished changes:

```bash
git stash
```

4. Switch to `main`, update `easy/README.md`, commit, and push the hotfix.
5. Return to `feature-notes` and restore your saved changes:

```bash
git stash pop
```

6. Make a commit, then undo only the commit (keep file changes):

```bash
git reset --soft HEAD~1
```

7. Recommit with a better commit message.
8. Simulate remote updates (edit on GitHub or from another clone), then sync locally:

```bash
git fetch
git pull origin main
```

9. If a file contains unwanted local edits, discard them:

```bash
git checkout -- <file-name>
```

10. Push final changes to GitHub.

### Expected Result

- `stash` and `stash pop` are used correctly.
- `git reset --soft HEAD~1` is applied and corrected with a new commit.
- Local repository is synchronized with remote updates using `fetch` and `pull`.

### Deliverable

Push the final state of the repository, including `advanced/` files and commit history.

## Final Submission (Classroom)

Submit the GitHub repository link in Classroom after completing all three levels.

Submission must include:

1. `easy/`, `medium/`, and `advanced/` folders
2. Visible commit history for each level
3. Remote repository updated on GitHub (`main` branch)
