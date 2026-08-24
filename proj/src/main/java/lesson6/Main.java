package lesson6;

import lesson6.tusk1.Student;
import lesson6.tusk1.StudentManager;
import lesson6.tusk2.Phonebook;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        // Наполняем студентами с разными оценками
        students.add(new Student("Иван", 1, "БПИ-21",  Arrays.asList(4, 5, 4, 3)));
        students.add(new Student("Ольга", 1,"БПИ-21",  Arrays.asList(2, 3, 2, 2)));
        students.add(new Student("Петр", 1,"БПИ-11",  Arrays.asList(3, 3, 4, 3)));
        students.add(new Student("Анна", 1,"БПИ-11",  Arrays.asList(2, 2, 3, 2)));
        students.add(new Student("Катерина", 1,"БПИ-21",  Arrays.asList(2, 2, 3, 2, 5, 5, 5, 5)));
        students.add(new Student("Евгений", 1,"БПИ-11",  Arrays.asList(4, 4, 3, 5)));
        students.add(new Student("Жанна", 1,"БПИ-21",  Arrays.asList(5, 3, 5, 5)));

        StudentManager sMan = new StudentManager(students);
        sMan.printStudents(students,2);
        sMan.processStudents(students);
        System.out.println("Список студентов после отчислений");
        sMan.printStudents(students,2);

//        Phonebook phonebook = new Phonebook();
//        phonebook.add("Иванов", "+7 (999) 111-22-33");
//        phonebook.add("Петров", "+7 (999) 444-55-66");
//        phonebook.add("Иванов", "+7 (999) 777-88-99");
//        phonebook.add("Сидоров", "+7 (999) 000-11-22");
//        String surn = "Иванов";
//
//        System.out.println("Номера для " + surn + " : " + phonebook.get(surn));
    }
}
