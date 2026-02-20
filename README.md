# Arc Core Library

This project contains shared core utilities and managers for Arc plugins.

## Features
- **Managers**: Centralized logic for components, instances, permissions, and worlds.
- **Loggers**: Shared logging utilities.
- **Colors**: Common text color definitions.

## Usage
To use this library in other Maven projects, add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>arc</groupId>
    <artifactId>core</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

In Gradle projects, ensure you have `mavenLocal()` in your repositories and add:

```gradle
implementation 'arc:core:1.0.0'
```

## Building
To install the library to your local Maven repository:

```bash
mvn install
```