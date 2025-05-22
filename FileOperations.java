import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;
import java.nio.charset.StandardCharsets;

/**
 * FileOperations.java
 * 
 * This program demonstrates basic file operations in Java:
 * - Reading text files
 * - Writing to text files
 * - Modifying text files
 * - Appending to text files
 */
public class FileOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Java File Operations Program");
        System.out.println("=============================");
        
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Read a file");
            System.out.println("2. Write to a new file");
            System.out.println("3. Append to an existing file");
            System.out.println("4. Modify (replace content in) a file");
            System.out.println("5. Count lines in a file");
            System.out.println("6. Search for text in a file");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            
            switch (choice) {
                case 1:
                    readFile(scanner);
                    break;
                case 2:
                    writeFile(scanner);
                    break;
                case 3:
                    appendFile(scanner);
                    break;
                case 4:
                    modifyFile(scanner);
                    break;
                case 5:
                    countLines(scanner);
                    break;
                case 6:
                    searchInFile(scanner);
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Reads and displays the contents of a file
     * @param scanner Scanner object for user input
     */
    private static void readFile(Scanner scanner) {
        System.out.print("Enter the file path to read: ");
        String filePath = scanner.nextLine();
        
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
            System.out.println("\nFile content:");
            System.out.println("-------------");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Writes content to a new file (overwrites if file exists)
     * @param scanner Scanner object for user input
     */
    private static void writeFile(Scanner scanner) {
        System.out.print("Enter the file path to write: ");
        String filePath = scanner.nextLine();
        
        System.out.println("Enter content to write (type 'END' on a new line to finish):");
        StringBuilder content = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equals("END")) {
            content.append(line).append("\n");
        }
        
        try {
            Files.write(Paths.get(filePath), content.toString().getBytes(StandardCharsets.UTF_8));
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Appends content to an existing file
     * @param scanner Scanner object for user input
     */
    private static void appendFile(Scanner scanner) {
        System.out.print("Enter the file path to append: ");
        String filePath = scanner.nextLine();
        
        System.out.println("Enter content to append (type 'END' on a new line to finish):");
        StringBuilder content = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equals("END")) {
            content.append(line).append("\n");
        }
        
        try {
            Files.write(Paths.get(filePath), content.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }

    /**
     * Modifies content in a file by replacing text
     * @param scanner Scanner object for user input
     */
    private static void modifyFile(Scanner scanner) {
        System.out.print("Enter the file path to modify: ");
        String filePath = scanner.nextLine();
        
        try {
            String oldContent = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
            System.out.println("\nCurrent file content:");
            System.out.println("---------------------");
            System.out.println(oldContent);
            
            System.out.print("\nEnter text to replace: ");
            String oldText = scanner.nextLine();
            
            System.out.print("Enter new text: ");
            String newText = scanner.nextLine();
            
            String newContent = oldContent.replace(oldText, newText);
            
            Files.write(Paths.get(filePath), newContent.getBytes(StandardCharsets.UTF_8));
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    /**
     * Counts the number of lines in a file
     * @param scanner Scanner object for user input
     */
    private static void countLines(Scanner scanner) {
        System.out.print("Enter the file path to count lines: ");
        String filePath = scanner.nextLine();
        
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            long count = lines.count();
            System.out.println("Number of lines: " + count);
        } catch (IOException e) {
            System.out.println("Error counting lines: " + e.getMessage());
        }
    }

    /**
     * Searches for text in a file and displays matching lines
     * @param scanner Scanner object for user input
     */
    private static void searchInFile(Scanner scanner) {
        System.out.print("Enter the file path to search: ");
        String filePath = scanner.nextLine();
        
        System.out.print("Enter text to search for: ");
        String searchText = scanner.nextLine();
        
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            System.out.println("\nMatching lines:");
            System.out.println("---------------");
            
            lines.filter(line -> line.contains(searchText))
                 .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error searching file: " + e.getMessage());
        }
    }
}