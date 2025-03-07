import java.util.ArrayList;
import java.util.iterator;
import java.util.Scanner;

public class iterator {
    public static void main(String[] args) {
        ArrayList<String>students = newArrayList< String >();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        int numOfStudents = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < numOfStudents; i++){
            System.out.println("Enter the name of student " + (i + 1) + ":");
            String name = scanner.nextLine();
            students.add(name);
        }
        iterator<String>iterator = students.iterator();

        System.out.println("\nList of students in uppercase:");

        while (iterator.hasNext()){
            String student = iterator.next();
            System.out.println(student.toUpperCase());
        }

        iterator = students.iterator();

        while (iterator.hasNext()){
            String student = iterator.next();
            if (student.equals("Sarah")){
                iterator.remove();
                System.out.println("Student 'Sarah' has been removed.");
            }
        }
    }
}
