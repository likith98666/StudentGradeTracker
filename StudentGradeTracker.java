import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Tracker ===");

        while (true) {
            System.out.print("Enter student name (or type 'done' to finish): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Enter grade for " + name + ": ");
            double grade;

            try {
                grade = Double.parseDouble(scanner.nextLine());
                if (grade < 0 || grade > 100) {
                    System.out.println("Grade must be between 0 and 100.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric grade.");
                continue;
            }

            students.add(new Student(name, grade));
        }

        if (students.isEmpty()) {
            System.out.println("No student data entered.");
            return;
        }

        // Processing grades
        double total = 0, highest = Double.MIN_VALUE, lowest = Double.MAX_VALUE;
        for (Student s : students) {
            total += s.grade;
            if (s.grade > highest) highest = s.grade;
            if (s.grade < lowest) lowest = s.grade;
        }
        double average = total / students.size();

        // Summary Report
        System.out.println("\n--- Summary Report ---");
        System.out.printf("Total Students: %d\n", students.size());
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.printf("Highest Grade: %.2f\n", highest);
        System.out.printf("Lowest Grade: %.2f\n", lowest);

        System.out.println("\nStudent Grades:");
        for (Student s : students) {
            System.out.printf("%s: %.2f\n", s.name, s.grade);
        }

        scanner.close();
    }
}