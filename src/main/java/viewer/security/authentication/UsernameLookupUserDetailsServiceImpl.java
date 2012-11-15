package viewer.security.authentication;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import viewer.dao.UserDao;
import viewer.model.User;

@Service("usernameUserDetailsService")
public class UsernameLookupUserDetailsServiceImpl extends AbstractUserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (StringUtils.isBlank(username)) {
            throw new UsernameNotFoundException("Username not found: Username is blank");
        }
        User user = userDao.readByUsernameForPasswordLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found: " + username);
        }
        return createUserDetails(user);
    }

}
