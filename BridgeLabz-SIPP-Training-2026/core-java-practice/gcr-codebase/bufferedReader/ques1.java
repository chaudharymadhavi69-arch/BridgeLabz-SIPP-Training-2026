import java.io.*;
import java.util.*;

public class ques1 {
    
    // Method to read student data and generate report card
    public static void processStudentResults(String inputFile, String outputFile) {
        BufferedReader reader = null;
        FileWriter writer = null;
        
        try {
            // Read from input file
            reader = new BufferedReader(new FileReader(inputFile));
            String line;
            int studentCount = 0;
            
            // Append mode - open file for writing in append mode
            writer = new FileWriter(outputFile, true);
            
            // Write header if file is empty
            File file = new File(outputFile);
            if (file.length() == 0) {
                writer.write("============================================\n");
                writer.write("          SCHOOL RESULT PORTAL\n");
                writer.write("============================================\n\n");
            }
            
            writer.write("Report Generated on: " + new Date() + "\n");
            writer.write("--------------------------------------------\n");
            
            // Process each line from input file
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                
                // Skip empty lines and comments
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                
                // Parse student data (format: StudentName,Math,English,Science,History)
                String[] parts = line.split(",");
                
                if (parts.length < 2) {
                    System.out.println("⚠ Invalid format in line: " + line);
                    continue;
                }
                
                String studentName = parts[0].trim();
                double[] marks = new double[parts.length - 1];
                
                try {
                    // Parse marks
                    for (int i = 1; i < parts.length; i++) {
                        marks[i - 1] = Double.parseDouble(parts[i].trim());
                    }
                    
                    // Calculate average
                    double average = calculateAverage(marks);
                    String grade = getGrade(average);
                    
                    // Write report card
                    writer.write("\nStudent Name: " + studentName + "\n");
                    writer.write("Marks: ");
                    for (double mark : marks) {
                        writer.write(mark + " ");
                    }
                    writer.write("\n");
                    writer.write("Average: " + String.format("%.2f", average) + "\n");
                    writer.write("Grade: " + grade + "\n");
                    writer.write("--------------------------------------------\n");
                    
                    studentCount++;
                    
                    System.out.println("✓ Processed: " + studentName + " (Average: " + 
                                     String.format("%.2f", average) + ", Grade: " + grade + ")");
                    
                } catch (NumberFormatException e) {
                    System.out.println("⚠ Invalid marks for student: " + studentName);
                }
            }
            
            // Write summary
            writer.write("\n✓ Total students processed: " + studentCount + "\n");
            writer.write("✓ Report appended successfully to: " + outputFile + "\n");
            
            System.out.println("\n✓ Successfully processed " + studentCount + " students");
            System.out.println("✓ Report written to: " + outputFile);
            
        } catch (FileNotFoundException e) {
            System.err.println("❌ ERROR: Input file not found: " + inputFile);
            System.err.println("   Please ensure the input file exists at: " + 
                             new File(inputFile).getAbsolutePath());
        } catch (IOException e) {
            System.err.println("❌ ERROR: I/O error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("❌ ERROR: Error closing files: " + e.getMessage());
            }
        }
    }
    
    // Calculate average of marks
    private static double calculateAverage(double[] marks) {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }
    
    // Get grade based on average
    private static String getGrade(double average) {
        if (average >= 90) {
            return "A+ (Excellent)";
        } else if (average >= 80) {
            return "A (Very Good)";
        } else if (average >= 70) {
            return "B (Good)";
        } else if (average >= 60) {
            return "C (Satisfactory)";
        } else if (average >= 50) {
            return "D (Passing)";
        } else {
            return "F (Fail)";
        }
    }
    
    public static void main(String[] args) {
        // Default file paths
        String inputFile = "students.txt";
        String outputFile = "report_card.txt";
        
        // Allow command line arguments
        if (args.length >= 1) {
            inputFile = args[0];
        }
        if (args.length >= 2) {
            outputFile = args[1];
        }
        
        System.out.println("School Result Portal\n");
        System.out.println("Input File: " + inputFile);
        System.out.println("Output File: " + outputFile);
        System.out.println("----------------------------------------\n");
        
        processStudentResults(inputFile, outputFile);
    }
}
