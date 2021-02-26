package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.util.UserInputService;

import java.util.List;


@Component
public class StudentManagementConsoleImpl implements StudentManagement{

    private StudentDao studentDao;
    private UserInputService userInputService;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    @Autowired
    public void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    @Override
    public Student create() {
        System.out.println("Enter your name: ");
        String studentName = userInputService.getString();
        Student addStudent = new Student();
        addStudent.setName(studentName);

        return save(addStudent);
    }

    @Override
    public Student save(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Student name is null");

        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        if (id == 0)
            throw new IllegalArgumentException("No student found with id: " + id);

        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student studentToRemove = find(id);
        if (studentToRemove == null)
            throw new IllegalArgumentException("No student found with id: " + id);

        studentDao.delete(id);

        return studentToRemove;
    }

    @Override
    public List<Student> findAll() {
        System.out.println("All listed students: ");
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        if (student.getStudentId() == 0)
            throw new NullPointerException("Student id can not be null");
        Student original = find(student.getStudentId());

        System.out.println("Edit name: ");
        String editName = userInputService.getString();
        original.setName(editName);

        return original;
    }
}
