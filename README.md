# FILE-HANDLING-UTILITY

*COMPANY*: CODTECH IT SOLUTIONS

*NAME*: PRIYANSH RATHOD

*INTERN ID*: CT04DL651

*DOMAIN*: JAVA

*DURATION*: 4 WEEKS

*MENTOR*:  NEELA SANTHOSH KUMAR 

*DESCRIPTION*:
-Introduction
This task involved developing a Java program capable of performing essential file operations, including reading, writing, appending, modifying, and searching text files. The goal was to create a user-friendly, menu-driven application that allows users to interact with text files efficiently. The program was developed using Java and tested in VS Code, with assistance from DeepSeek Chat for debugging and optimization.

-Objective
The primary objective was to build a command-line-based Java application that demonstrates:

Reading text files and displaying their contents.

Writing new content to files (overwriting if necessary).

Appending text to existing files without losing previous data.

Modifying file content by replacing specific text.

Counting the number of lines in a file.

Searching for specific text within a file.

This program serves as a practical example of file handling in Java, useful for beginners and intermediate programmers.

-Tools and Technologies Used
1. Java Development Kit (JDK)
Used Java 11+ (for Files.readString() and Files.writeString() methods).

Ensured compatibility with modern Java file I/O operations.

2. VS Code (Integrated Development Environment)
Code Editor: Used for writing, debugging, and testing the program.

Extensions:

Java Extension Pack (for syntax highlighting, debugging, and IntelliSense).

Code Runner (for quick execution).

3. DeepSeek Chat (AI Assistant)
Assisted in:

Code optimization (e.g., using Files instead of BufferedReader for simplicity).

Debugging (identifying and fixing logical errors).

Documentation (helping structure comments and explanations).

4. Git (Optional for Version Control)
Could be used to track changes and maintain different versions of the program.

-Implementation Details
1. Program Structure
The program follows an object-oriented approach with a single FileOperations class containing:

A main menu (handled via switch-case).

Six methods for different file operations.

Error handling (try-catch blocks for IOException).

2. Key Features
a) Reading a File (readFile())
Uses Files.readString(Path) for efficient reading.

Displays the entire content in the console.

b) Writing to a File (writeFile())
Takes user input until "END" is entered.

Uses Files.writeString(Path) to save content (overwrites existing files).

c) Appending to a File (appendFile())
Uses StandardOpenOption.APPEND to add text without deleting old content.

d) Modifying a File (modifyFile())
Reads the file, replaces specified text, and saves changes.

e) Counting Lines (countLines())
Uses Java Streams (Files.lines().count()) for efficiency.

f) Searching in a File (searchInFile())
Filters lines containing a search term using Stream.filter().

-Challenges & Solutions
1. Handling File Paths Correctly
Issue: Users might input invalid paths.

Solution: Used try-catch to handle IOException gracefully.

2. Efficient File Reading/Writing
Issue: Traditional BufferedReader and FileWriter require more code.

Solution: Used Java NIO (Files class) for cleaner implementation.

3. User Input Management
Issue: Scanner buffer issues when switching between nextInt() and nextLine().

Solution: Used scanner.nextLine() consistently for input.

-My Contributions & Learning Outcomes
1. Hands-on Java Practice
Improved understanding of:

File I/O operations (java.nio.file package).

Streams API for efficient file processing.

Exception handling in file operations.

2. Debugging & Optimization
Learned to:

Use VS Code’s debugger to trace errors.

Optimize code with DeepSeek’s suggestions.

3. Documentation & Readability
Added clear comments and structured the code for better maintainability.

-Conclusion
This project successfully demonstrates file handling in Java with a user-friendly CLI menu. Using VS Code and DeepSeek Chat, I enhanced the program’s efficiency and readability. Future improvements could include:

Support for large files (streaming instead of full reads).

GUI implementation (using JavaFX or Swing).

Batch processing (handling multiple files at once).

This task was a valuable learning experience in Java programming, debugging, and file manipulation.
