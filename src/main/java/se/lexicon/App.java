package se.lexicon;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.dao.StudentDao;
import se.lexicon.util.UserInputService;

public class App
{
    public static void main( String[] args ) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService = context.getBean(UserInputService.class);
/*
        Student student1 = studentDao.save(new Student("Sebastian"));
        Student student2 = studentDao.save(new Student("Emma"));
        Student student3 = studentDao.save(new Student("Matteo"));
        Student student4 = studentDao.save(new Student("Oliver"));
        Student student5 = studentDao.save(new Student("Test"));


 */
/*
        Student find2 = studentDao.find(2);
        System.out.println(find2);

        Student find1 = studentDao.find(1);
        System.out.println(find1);
 */

      // studentDao.delete(5);


       // List<Student> findAll = studentDao.findAll();
       // findAll.forEach(System.out::println);




    }
}
