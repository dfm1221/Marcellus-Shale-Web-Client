package viewer.model;

import org.hibernate.annotations.Type;
import viewer.util.Password;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Justin Ford
 * Date: 9/20/12
 * Time: 8:29 PM
 */
@Entity
@Table(name = "_User")
public class User extends OBJ{

    @Column(unique = true, nullable = false, length = 64)
    private String userName;

    @Column(unique = false, nullable = false, length = 64)
    private String firstName;

    @Column(unique = false, nullable = false, length = 64)
    private String lastName;

    @Type(type = "viewer.util.Password")
    private Password password;

    @Column(unique = true, nullable = false, length = 64)
    private String email;

    @Temporal(value = TemporalType.DATE)
    private Date lastLoggedInDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasswordHash() {
        return password == null ? null : password.getHash();
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLoggedInDate() {
        return lastLoggedInDate;
    }

    public void setLastLoggedInDate(Date lastLoggedInDate) {
        this.lastLoggedInDate = lastLoggedInDate;
    }
}
