package viewer.util;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Justin Ford
 * Date: 9/21/12
 * Time: 11:03 AM
 */
public class Password extends PasswordUserType implements Comparable<Password>, Serializable {
    private static final long serialVersionUID = 5550779118057126576L;
    public static final String NO_PASSWORD = "NO_PASSWORD";
    private String hash;

    /**
     * Needed for Hibernate
     */
    public Password() {
        hash = NO_PASSWORD;
    }

    /**
     * Creates a password object out of an already hashed String
     * @param hash - a hashed String using MD5 or SHA1 or some other one way hash algorithm
     */
    public Password(String hash) {
        setHash(hash);
    }

    /**
     * Returns a copy of a password object.
     *
     * @param password - the value to analyze
     * @return copy of password
     */
    public static Password copyOf(Password password) {
        if (password == null)
            return null;

        Password copy = new Password();
        copy.setHash(password.getHash());
        return copy;
    }

    /**
     * Takes the hashValue and instantiates a Password object
     *
     * @param hashValue - an already hashed String
     * @return Password instantiation of hash value
     */
    static Password valueOf(String hashValue) {
        Password newInstance = new Password();
        newInstance.setHash(hashValue);
        return newInstance;
    }

    /**
     * Retrieve hash value.
     *
     * @return Hash Value
     */
    public String getHash() {
        return hash;
    }

    private void setHash(String hash) {
        if (hash == null || hash.isEmpty())
            this.hash = NO_PASSWORD;
        else
            this.hash = hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Password))
            return false;
        Password password = (Password) obj;

        if (this == password)
            return true;
        else
            return this.compareTo(password) == 0;
    }

    public int compareTo(Password o) {
        if (o == null)
            return 1;
        else if (getHash() == null && o.getHash() == null)
            return 0;
        else if (getHash() == null && o.getHash() != null)
            return -1;
        else if (getHash() != null && o.getHash() == null)
            return 1;
        else
            return getHash().compareTo(o.getHash());
    }

    @Override
    public String toString() {
        return hash == null ? "null" : hash;
    }
}
