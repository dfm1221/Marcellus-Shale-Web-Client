package viewer.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

/**
 * User: Justin Ford
 * Date: 10/30/12
 * Time: 4:34 PM
 */
public enum UserRoles implements GrantedAuthority {



    /** Access to view/edit Administrative pages **/
    ROLE_ADMIN;



    @Override
    public String getAuthority() {
        return this.name();
    }

    public static Collection<UserRoles> fromDelimitedString(String authorities) {
        return fromDelimitedString(authorities, ",");
    }

    public static Collection<UserRoles> fromDelimitedString(String authorities, String delimiter) {
        Collection<UserRoles> roles = new ArrayList<UserRoles>();
        if (StringUtils.isNotBlank(authorities)) {
            String[] strAuthorities = authorities.split(delimiter);
            for(String auth : strAuthorities) {
                UserRoles role = fromString(auth);
                if (role != null) {
                    roles.add(role);
                }
            }

        }

        return roles;
    }

    public static UserRoles fromString(String authority) {
        if (authority != null) {
            for (UserRoles r : values()) {
                if (r.name().equals(authority)) {
                    return r;
                }
            }
        }
        return null;
    }
}
