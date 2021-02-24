package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.util.UserInputService;

import java.util.List;

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
        String name = userInputService.getString();
        Student addStudent = new Student();
        addStudent.setName(name);

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
        System.out.println("Enter student id: ");
        int scannerId = userInputService.getInt();
        return studentDao.find(scannerId);
    }

    @Override
    public Student remove(int id) {
        Student studentToRemove = find(id);
        studentDao.delete(id);
        return studentToRemove;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        if (student.getStudentId() == 0) throw new NullPointerException("Student id can not be null");
        student.getStudentId();

        System.out.println("Edit: ");
        String editName = userInputService.getString();
        student.setName(editName);

        return student;
    }
}
