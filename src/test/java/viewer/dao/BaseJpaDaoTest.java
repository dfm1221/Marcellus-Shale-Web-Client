package viewer.dao;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import viewer.model.User;
import viewer.util.Password;

/**
 * User: Justin Ford
 * Date: 10/7/12
 * Time: 9:34 PM
 */
@ContextConfiguration(locations = {"../dao/data-access-config.xml"})
@TransactionConfiguration
public class BaseJpaDaoTest {

    @PersistenceContext
    private EntityManager em;



    protected User createUser() {
        User user = new User();
        user.setEmail("someone@frostburg.edu");
        user.setFirstName("first");
        user.setLastName("last");
        user.setUserName("username");
        user.setPassword(new Password());
        return user;
    }




}

