package viewer.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import viewer.model.User;
import viewer.util.Password;

import static org.junit.Assert.assertTrue;

/**
 * User: Justin Ford
 * Date: 10/7/12
 * Time: 9:34 PM
 */
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"/viewer/web/web-application-config.xml"})
public class BaseJpaDaoTest {


    @Autowired
    UserDao userDao;


    @Test
    public void createUser() {
        User user = new User();
        user.setEmail("someone@frostburg.edu");
        user.setFirstName("first");
        user.setLastName("last");
        user.setUserName("username");
        user.setPassword(new Password());

        userDao.create(user);
        System.out.println(userDao.readByUsernameForPasswordLogin(user.getUserName()));
        assertTrue(userDao.readByUsernameForPasswordLogin(user.getUserName()) != null);

    }




}

