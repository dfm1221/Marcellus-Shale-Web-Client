package viewer.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created with IntelliJ IDEA.
 * User: Justin Ford
 * Date: 9/21/12
 * Time: 11:02 AM
 */
public abstract class PasswordUserType implements UserType {
    public int[] sqlTypes() {
        return new int[]{Types.VARCHAR};
    }

    public boolean isMutable() {
        return true;
    }

    public Object deepCopy(Object value) throws HibernateException {
        return Password.copyOf((Password) value);
    }

    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return Password.copyOf((Password) cached);
    }

    public Serializable disassemble(Object value) throws HibernateException {
        return Password.copyOf((Password) value);
    }

    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return Password.copyOf((Password) original);
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y) return true;
        if (x == null || y == null) return false;
        if ((x instanceof Password) && (y instanceof Password))
            return ((Password) x).compareTo((Password) y) == 0;
        return x.equals(y);
    }

    public int hashCode(Object x) throws HibernateException {
        return (x == null) ? 0 : (((Password) x).getHash() == null) ? 0 : ((Password) x).getHash().hashCode();
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        String hash = rs.getString(names[0]);

        // Deferred check after first read.
        if (rs.wasNull()) return null;

        return Password.valueOf(hash);
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        if (value == null)
            st.setNull(index, Types.VARCHAR);
        else {
            //Should not have to account for collections. Collections are already
            //supported by Hibernate.
            if (value instanceof Object[]) {
                throw new UnsupportedOperationException(
                        "No Array support for Passwords");
            } else {
                Password password = (Password) value;
                st.setString(index, password.getHash());
            }
        }

    }

    public Class<Password> returnedClass() {
        return Password.class;
    }
}
