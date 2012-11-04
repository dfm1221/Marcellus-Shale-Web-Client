package viewer.security.authentication;

import org.springframework.security.core.userdetails.UserDetailsService;
import viewer.model.User;
import viewer.security.UserDetailsDto;

public abstract class AbstractUserDetailsService implements UserDetailsService {

	protected UserDetailsDto createUserDetails(User user) {
		UserDetailsDto instance = new UserDetailsDto();
		instance.setUsername(user.getUserName());
		instance.setPassword(user.getPasswordHash());
		instance.setAccountNonExpired(true);
		instance.setAccountNonLocked(true);
		instance.setCredentialsNonExpired(true);
		instance.setUserId(user.getId());
		return instance;
	}

}
