package viewer.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import viewer.model.User;
import viewer.util.Password;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Justin Ford
 * Date: 12/12/12
 * Time: 2:45 PM
 */
public class UserDaoTest extends DaoFixture {
    @Autowired
    UserDao userDao;


    public User createUser() {
        User user = new User();
        user.setEmail("someone@frostburg.edu");
        user.setFirstName("first");
        user.setLastName("last");
        user.setUserName("username");
        user.setPassword(new Password());
        userDao.create(user);
        return user;

    }

    public void createListUsers(){
        User u1 = new User();
        u1.setUserName("markB");
        u1.setFirstName("Mark");
        u1.setLastName("Toms");
        u1.setEmail("mt4@company.com");

        User u5 = new User();
        u5.setUserName("markTho");
        u5.setFirstName("Mark");
        u5.setLastName("Toms");
        u5.setEmail("mt3@company.com");

        User u2 = new User();
        u2.setUserName("markTo");
        u2.setFirstName("Mark");
        u2.setLastName("Toms");
        u2.setEmail("mt2@company.com");

        User u3 = new User();
        u3.setUserName("markT");
        u3.setFirstName("Mark");
        u3.setLastName("Toms");
        u3.setEmail("t@company.com");

        User u4 = new User();
        u4.setUserName("mToms");
        u4.setFirstName("Mark");
        u4.setLastName("Toms");
        u4.setEmail("m@company.com");

        userDao.create(u1);
        userDao.create(u2);
        userDao.create(u3);
        userDao.create(u4);
        userDao.create(u5);

    }

    @Test
    public void testCreateUser(){
        assertTrue(createUser().getId() != null);
    }

    @Test
    public void testReadUserByUserName(){
        assertTrue(userDao.readByUsernameForPasswordLogin(createUser().getUserName()) != null);
    }

    @Test
    public void testReadUserById(){
        assertTrue(userDao.read(createUser().getId()) != null);
    }

    @Test
    public void testReadAllUsers(){
        createListUsers();
        assertEquals(userDao.readAll().size(), 5);
    }



}
