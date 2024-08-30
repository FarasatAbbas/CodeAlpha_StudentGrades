import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int numberOfStudents = scanner.nextInt();

        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
            scanner.close();
            return;
        }

        int[] grades = new int[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter grade for student " + (i + 1) + ":");
            grades[i] = scanner.nextInt();
        }

        int highest = grades[0];
        int lowest = grades[0];
        int sum = 0;

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > highest) {
                highest = grades[i];
            }
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
            sum += grades[i];
        }

        double average = (double) sum / grades.length;

        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);

        scanner.close();
    }
}
