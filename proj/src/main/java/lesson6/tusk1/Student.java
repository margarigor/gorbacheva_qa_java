package lesson6.tusk1;

import java.util.List;

public class Student {
    String name;
    String groupNum;
    int yearOfSt;
    List<Integer> grades;

    public Student(String name, int yearOfSt, String groupNum, List<Integer> grades) {
        this.name = name;
        this.yearOfSt = yearOfSt;
        this.groupNum = groupNum;
        this.grades = grades;
    }

    public double getAverageGrade() {
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public boolean ifPromoteStudent() {
        if (getAverageGrade() < 3.0) {
            return false;
        } else {
            yearOfSt++;
            return true;
        }
    }
}