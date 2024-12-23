package CIE;

public class Personal {
    public String usn;
    public String name;
    public int sem;

    public void setDetails(String usn, String name, int sem) {
        this.usn = usn;
        this.name = name;
        this.sem = sem;
    }
}

package CIE;

public class Internals extends Personal {
    public int[] internalMarks = new int[5];

    public void setInternalMarks(int[] marks) {
        System.arraycopy(marks, 0, internalMarks, 0, 5);
    }
}
package SEE;

import CIE.Personal;

public class External extends Personal {
    public int[] externalMarks = new int[5];

    public void setExternalMarks(int[] marks) {
        System.arraycopy(marks, 0, externalMarks, 0, 5);
    }
}
import CIE.*;
import SEE.*;
import java.util.Scanner;

public class FinalMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            Internals internal = new Internals();
            External external = new External();

            System.out.print("Enter USN: ");
            String usn = scanner.next();
            System.out.print("Enter Name: ");
            String name = scanner.next();
            System.out.print("Enter Semester: ");
            int sem = scanner.nextInt();

            internal.setDetails(usn, name, sem);
            System.out.println("Enter 5 internal marks:");
            int[] internalMarks = new int[5];
            for (int j = 0; j < 5; j++) internalMarks[j] = scanner.nextInt();
            internal.setInternalMarks(internalMarks);

            System.out.println("Enter 5 external marks:");
            int[] externalMarks = new int[5];
            for (int j = 0; j < 5; j++) externalMarks[j] = scanner.nextInt();
            external.setExternalMarks(externalMarks);

            System.out.println("Final Marks for " + internal.name + " (USN: " + internal.usn + "):");
            for (int j = 0; j < 5; j++) {
                int finalMark = internal.internalMarks[j] + (external.externalMarks[j] / 2);
                System.out.println("Course " + (j + 1) + ": " + finalMark);
            }
        }
        scanner.close();
    }
}
