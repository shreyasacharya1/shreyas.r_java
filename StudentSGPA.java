import java.util.Scanner;

class Student {
    private String usn;
    private String name;
    private int[] credits;
    private int[] marks;

    public void acceptDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter USN: ");
        usn = scanner.nextLine();
        System.out.print("Enter Name: ");
        name = scanner.nextLine();

        System.out.print("Enter number of subjects: ");
        int n = scanner.nextInt();
        credits = new int[n];
        marks = new int[n];

        System.out.println("Enter credits and marks for each subject:");
        for (int i = 0; i < n; i++) {
            System.out.print("Credits for subject " + (i + 1) + ": ");
            credits[i] = scanner.nextInt();
            System.out.print("Marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }

    public void displayDetails() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
    }

    public void calculateSGPA() {
        int totalCredits = 0;
        double weightedSum = 0.0;

        for (int i = 0; i < credits.length; i++) {
            int gradePoint = (marks[i] / 10) + 1;
            weightedSum += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        double sgpa = weightedSum / totalCredits;
        System.out.println("SGPA: " + String.format("%.2f", sgpa));
    }
}

public class StudentSGPA {
    public static void main(String[] args) {
        Student student = new Student();
        student.acceptDetails();
        student.displayDetails();
        student.calculateSGPA();
    }
}
