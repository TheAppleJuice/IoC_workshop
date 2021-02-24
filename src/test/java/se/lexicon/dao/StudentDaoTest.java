package se.lexicon.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ComponentScanConfig.class})

public class StudentDaoTest {
    @Autowired
    StudentDao studentDao;

    @Test
    public void test_save(){
        Student expected = new Student(1, "Sebastian");
        Student actual = studentDao.save(new Student("Sebastian"));

        Assert.assertEquals(expected, actual);

    }

}
