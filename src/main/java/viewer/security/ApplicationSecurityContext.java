package viewer.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;

/**
 * User: Justin Ford
 * Date: 10/29/12
 * Time: 3:30 PM
 */
public final class ApplicationSecurityContext {

//    private static final Logger LOG = LoggerFactory.getLogger(ApplicationSecurityContext.class);

    public UserDetailsDto getUserDetails() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof UserDetailsDto) {
            return (UserDetailsDto) auth.getPrincipal();
        }
//        LOG.debug("auth object is either null, not authenticated or (very unlikely) not an instance of UserDetailsDto, returning null");
        return null;
    }

    public Long getUserId() {
        UserDetailsDto user = getUserDetails();
        if (user != null) {
            return user.getUserId();
        }
        return null;
    }

    public String getUsername() {
        UserDetailsDto user = getUserDetails();
        if (user != null) {
            return user.getUsername();
        }
        return null;
    }

    public boolean hasAuthority(UserRoles role) {
        UserDetailsDto user = getUserDetails();
        if (user != null) {
            return CollectionUtils.containsInstance(user.getAuthorities(), role);
        }
        return false;
    }

    public boolean isUserType(UserTypes userType) {
        UserDetailsDto user = getUserDetails();
        if (user != null) {
            return user.getUserType() == userType;
        }
        return false;
    }

    public UserTypes getUserType() {
        UserDetailsDto user = getUserDetails();
        if (user != null) {
            return user.getUserType();
        }
        return null;
    }

    /**
     * Authentication.isAuthenticated() returns true for Anonymous Users, so here is a custom check to see if the current user is authenticated with our app.
     * @return true if the current user is authenticated with the app
     */
    public boolean isAuthenticated() {
        return hasAuthority(UserRoles.ROLE_ADMIN);
    }
}
