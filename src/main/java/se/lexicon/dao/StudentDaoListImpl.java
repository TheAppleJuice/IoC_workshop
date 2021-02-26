package se.lexicon.dao;

import org.springframework.stereotype.Component;
import se.lexicon.dao.sequencer.StudentSequencer;
import se.lexicon.model.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao {

    private List<Student> students = new ArrayList<>(); // 1,A   + 2,ABCD  3,C 4,D

    @Override
    public Student save(Student student) { // 2,ABCD
    //SAVE AND UPDATE FUNCTION
        if (student.getStudentId()==0) {
            student.setStudentId(StudentSequencer.nextStudentId());//4
            students.add(student);
        }else{
            //UPDATE
            // find student index
            Student original = find(student.getStudentId()); //2,B
            int objectIndex = students.indexOf(original);// 1
            delete(original.getStudentId());
           students.add(objectIndex, student); //
            // add new student to existing index

        }
        return student;
    }

    @Override
    public Student find(int id) {
        if (id ==0) throw new IllegalArgumentException("Id should not be null");

        return students.stream().filter(student -> student.getStudentId()==id).
                findFirst().orElse(null);

    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void delete(int id) {
        students.removeIf(student -> student.getStudentId()==id);

    }
}
