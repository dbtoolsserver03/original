package aaa;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring-basic.xml")
public class TestSpringMycat {


    /*@Autowired
    private UserDAO userDAO;


    @Test
    public void testSave(){
        userDAO.save(new User(UUID.randomUUID().toString(),"小明明"));
    }


    @Test
    public void testFindAll(){
        for (int i = 0; i < 10; i++) {
            List<User> users = userDAO.findAll();
            for (User user : users) {
                System.out.println(user);
            }
            System.out.println("=====================");
        }
    }
*/
}
