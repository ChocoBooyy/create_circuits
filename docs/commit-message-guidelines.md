# Commit Message Format

This project uses an Angular inspired commit message format, adapted to this codebase.
It keeps history readable and supports automated changelogs.

Each commit message has a header, a body, and a footer.

```
<header>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```

The header is required and must follow the [Commit Message Header](#commit-header) format.

The body is required for all commits except type "docs". When present, the body must be at least 20 characters long.
The body must follow the [Commit Message Body](#commit-body) rules.

The footer is optional and follows the [Commit Message Footer](#commit-footer) rules.

## <a name="commit-header"></a>Commit Message Header

```
<type>(<scope>): <short summary>
  │       │             │
  │       │             └─ Summary in present tense. Not capitalized. No period at the end.
  │       │
  │       └─ Scope: free form, keep it short and specific
  │
  └─ Type: build|ci|docs|feat|fix|perf|refactor|test
```

Header examples:

- feat(arithmetic): add multiplier operation
- fix(signal): refresh outputs on neighbor updates
- feat(memory): add rs latch block
- feat(datagen): add recipes and lang entries
- build(assets): add block textures

### Type

Must be one of the following:

| Type         | Description                                                                 |
| ------------ | --------------------------------------------------------------------------- |
| build        | Changes to build system or external dependencies                           |
| ci           | Changes to CI configuration or scripts                                     |
| docs         | Documentation only changes                                                 |
| feat         | A new feature                                                              |
| fix          | A bug fix                                                                  |
| perf         | A code change that improves performance                                    |
| refactor     | A code change that neither fixes a bug nor adds a feature                  |
| test         | Adding missing tests or correcting existing tests                          |

### <a name="scope"></a>Scope

Use a short, specific scope that matches the area of change in this codebase.
The scope is free form, but keep it consistent across the project.
Examples: util, signal, base, logic, arithmetic, memory, timing, mux, create, registry, datagen, assets, docs, build, ci, idea.

Pick the most specific scope that fits.

### Summary

Use the summary field to provide a concise description:

- use the imperative, present tense
- do not capitalize the first letter
- no period at the end

## <a name="commit-body"></a>Commit Message Body

Use the imperative, present tense. Explain why the change is needed.
If helpful, include the previous behavior and the new behavior.
Minimum length is 20 characters.

## <a name="commit-footer"></a>Commit Message Footer

The footer is optional. Use it for breaking changes, deprecations, and issue references.

Examples:

```
BREAKING CHANGE: short summary

Detailed description and migration steps.

Fixes #123
```

```
DEPRECATED: short summary

Detailed description and recommended update path.

Closes #456
```

## Revert commits

Use the format:

```
revert: <header>
```

The body must include:

- This reverts commit <SHA>
- A clear reason for the revert
