# Lesson 1 Homework - Java Environment Setup & First Compilation

## Objective

The goal of this assignment is to help you understand how the Java development environment works and how Java code is compiled and executed.

By completing this task, you will learn how to install Java tools, explore the JDK structure, and manually compile Java programs.

## Task 1 - Install Java Development Tools

### Instructions

1. Download and install the Java Development Kit (JDK).
2. Download and install IntelliJ IDEA Community Edition.
3. Verify that Java is installed correctly.

### Verification

Open your terminal (Command Prompt / Terminal) and run:

```bash
java -version
javac -version
```

### Expected Result

The terminal should display the installed Java version.

### Deliverable

Upload a screenshot of the terminal output showing the installed Java version.

## Task 2 - Explore the JDK Structure

### Instructions

1. Locate the JDK installation folder on your computer.
2. Navigate to the `bin` directory.
3. Find the following important files:
   - `javac` -> Java compiler
   - `java` -> JVM launcher
4. Understand that:
   - `javac` converts `.java` files into `.class` bytecode.
   - `java` runs the bytecode using the JVM.

### Deliverable

Take a screenshot of the JDK `bin` folder showing the `javac` and `java` files and upload it to the classroom.

## Task 3 - Compile a Java Program Manually

### Instructions

1. Create a simple Java program.

Example:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, Java World!");
    }
}
```

2. Save the file as:

```text
HelloWorld.java
```

### Compile the Program

Open the terminal and run:

```bash
javac HelloWorld.java
```

### Expected Result

A new file should appear:

```text
HelloWorld.class
```

### Run the Program

Execute the program using:

```bash
java HelloWorld
```

### Expected Output

```text
Hello, Java World!
```

### Deliverables

Upload:

1. Screenshot of the terminal showing the compilation command (`javac`)
2. Screenshot showing the generated `.class` file
3. Screenshot showing the program output
