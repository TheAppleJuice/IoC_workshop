package se.lexicon;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

import java.util.List;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService = context.getBean(UserInputService.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        System.out.println("Create student object: ");
        System.out.println(studentManagement.create());


        System.out.println("---------------------");
        System.out.println("Save student: ");

        Student student1 = studentManagement.save(new Student("Sebastian"));
        Student student2 = studentManagement.save(new Student("Emma"));
        Student student3 = studentManagement.save(new Student("Matteo"));
        Student student4 = studentManagement.save(new Student("Oliver"));
        Student student5 = studentManagement.save(new Student("Test"));


        System.out.println("---------------------");
        System.out.println("Find all students: ");
        List<Student> findAll = studentManagement.findAll();
        findAll.forEach(System.out::println);


        System.out.println("---------------------");
        System.out.println("Deleted student by id 1");
        studentDao.delete(1);


        System.out.println("---------------------");
        System.out.println("Find all students again: ");
        List<Student> finaAllAgain = studentManagement.findAll();
        finaAllAgain.forEach(System.out::println);

        System.out.println("---------------------");

        System.out.print("Find student by id 4");
        System.out.print(studentManagement.find(userInputService.getInt()));



        System.out.println("---------------------");
        System.out.println("Edit student");

        Student editStudent = studentManagement.edit(student2);
        System.out.println("Edited student = " + editStudent);

        System.out.println("---------------------");
        System.out.println("Find all students again with edit function: ");
        List<Student> finaAllEdit = studentManagement.findAll();
        finaAllEdit.forEach(System.out::println);


    }

}
