package lesson6.tusk1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentManager {

    Set<Student> students;

    public StudentManager(Set<Student> students) {
        this.students = students;
    }

    public void processStudents(Set<Student> students) {
        List<Student> studentsList = new ArrayList<>(students);
        for (int i = studentsList.size() - 1; i >= 0; i--) {
            Student student = studentsList.get(i);
            if (!student.ifPromoteStudent()) {
                studentsList.remove(i);
            }
        }
        students.clear();
        students.addAll(studentsList);
    }


    public void printStudents(Set<Student> studentSet, int yearOfSt) {
        boolean found = false;
        for (Student student : studentSet) {
            if (student.yearOfSt == yearOfSt) {
                System.out.println("- " + student.name);
                found = true;
            }
        }
        if (!found) {
            System.out.println("На " + yearOfSt + " курсе еще никто не учится.");
        }
    }

}
