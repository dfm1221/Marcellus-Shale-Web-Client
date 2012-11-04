package viewer.model;

import viewer.util.Password;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

/**
 * User: Justin Ford
 * Date: 11/4/12
 * Time: 5:39 PM
 */

@StaticMetamodel( User.class )
public class User_ {

        public static volatile SingularAttribute<User, String> userName;
        public static volatile SingularAttribute<User, String> firstName;
        public static volatile SingularAttribute<User, String> lastName;
        public static volatile SingularAttribute<User, Date> lastLoggedInDate;
        public static volatile SingularAttribute<User, Password> password;




}
