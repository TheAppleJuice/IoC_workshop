package se.lexicon.dao;

import org.springframework.stereotype.Component;
import se.lexicon.model.Student;

import java.util.HashSet;
import java.util.List;

@Component("studentDao")
public class StudentDaoListImpl implements StudentDao {

    List<Student> students;

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student find(Student id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
