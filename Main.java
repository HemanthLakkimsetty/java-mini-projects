import java.util.*;

class Student {
    String name;
    int vtuno;
    String depart;
    String mentorName;
    String mentorPhno;
    int batch;
    String phno;
    String fatherName;
    String fatherPhno;

    // Constructor
    public Student(String name, int vtuno, String depart, String mentorName, String mentorPhno,
                   int batch, String phno, String fatherName, String fatherPhno) {
        this.name = name;
        this.vtuno = vtuno;
        this.depart = depart;
        this.mentorName = mentorName;
        this.mentorPhno = mentorPhno;
        this.batch = batch;
        this.phno = phno;
        this.fatherName = fatherName;
        this.fatherPhno = fatherPhno;
    }

    // Display student details
    public void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("VTU No: " + vtuno);
        System.out.println("Department: " + depart);
        System.out.println("Mentor Name: " + mentorName);
        System.out.println("Mentor Phone Number: " + mentorPhno);
        System.out.println("Batch: " + batch);
        System.out.println("Phone Number: " + phno);
        System.out.println("Father's Name: " + fatherName);
        System.out.println("Father's Phone Number: " + fatherPhno);
        System.out.println("-----------------------------------");
    }
}
class StudentManager {
    private ArrayList<Student> std = new ArrayList<>();

    // Add student with duplicate check
    public void addStudent(Student s) {
        for (Student st : std) {
            if (st.vtuno == s.vtuno) {
                System.out.println("Student with VTU No " + s.vtuno + " already exists. Cannot add duplicate.");
                return;
            }
        }
        std.add(s);
        System.out.println("Student added successfully.");
    }

    // View all students
    public void viewAllStudents() {
        if (std.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : std) {
            s.displayStudentDetails();
        }
    }

    // Search student by VTU No
    public void searchStudentByVtuNo(int vtuno) {
        for (Student s : std) {
            if (s.vtuno == vtuno) {
                s.displayStudentDetails();
                return;
            }
        }
        System.out.println("Student with VTU No " + vtuno + " not found.");
    }

    // Delete student by VTU No
    public void delStd(int vtuno) {
        Iterator<Student> it = std.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.vtuno == vtuno) {
                it.remove();
                System.out.println("Student with VTU No " + vtuno + " deleted successfully.");
                return;
            }
        }
        System.out.println("Student with VTU No " + vtuno + " not found. Cannot delete.");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n--- VelTech University Student System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by VTU No");
            System.out.println("4. Delete Student by VTU No");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter VTU No: ");
                    int vtuno = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Department: ");
                    String depart = sc.nextLine();

                    System.out.print("Enter Mentor Name: ");
                    String mentorName = sc.nextLine();

                    System.out.print("Enter Mentor Phone No: ");
                    String mentorPhno = sc.nextLine();

                    System.out.print("Enter Batch No: ");
                    int batch = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Phone No: ");
                    String phno = sc.nextLine();

                    System.out.print("Enter Father's Name: ");
                    String fatherName = sc.nextLine();

                    System.out.print("Enter Father's Phone No: ");
                    String fatherPhno = sc.nextLine();

                    Student s = new Student(name, vtuno, depart, mentorName, mentorPhno, batch, phno, fatherName, fatherPhno);
                    manager.addStudent(s);
                    break;

                case 2:
                    manager.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter VTU No to search: ");
                    int searchVtu = Integer.parseInt(sc.nextLine());
                    manager.searchStudentByVtuNo(searchVtu);
                    break;

                case 4:
                    System.out.print("Enter VTU No to delete: ");
                    int deleteVtu = Integer.parseInt(sc.nextLine());
                    manager.delStd(deleteVtu);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}