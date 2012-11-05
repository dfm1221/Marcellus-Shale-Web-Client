package viewer.security;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import viewer.types.OptionType;
import viewer.types.PersistentEnum;

import java.util.Collection;
import java.util.HashSet;

/**
 * User: Justin Ford
 * Date: 10/30/12
 * Time: 4:29 PM
 */
public enum UserTypes implements OptionType<UserTypes>, PersistentEnum {

    /** Has access to everything in the app **/
    ADMIN("Administrator", UserRoles.values());

    private String label;
    private Collection<UserRoles> roles;

    private UserTypes(String label, UserRoles... roles) {
        this.label = label;
        if (roles == null) {
            throw new IllegalArgumentException("At least one role must be defined for a user group/type");
        }
        initRoles(roles);
    }

    @SuppressWarnings("unchecked")
    private void initRoles(UserRoles... roles) {
        this.roles = new HashSet<UserRoles>();
        for(UserRoles role : roles) {
            this.roles.add(role);
        }
        this.roles = CollectionUtils.unmodifiableCollection(this.roles);
    }

    @Override
    public UserTypes getValue() {
        return this;
    }

    @Override
    public String getLabel() {
        return label;
    }

    public Collection<UserRoles> getRoles() {
        return roles;
    }

    public static UserTypes fromString(String str) {
        if (StringUtils.isNotBlank(str)) {
            for(UserTypes type : values()) {
                if (type.name().equals(str)) {
                    return type;
                }
            }
        }
        return null;
    }
}
