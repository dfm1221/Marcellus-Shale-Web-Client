package viewer.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Justin Ford
 * Date: 9/20/12
 * Time: 8:21 PM
 */

@MappedSuperclass
public abstract class OBJ implements Serializable {

    /**
     * Use to provide the primary key for the record.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Used for locking purposes. Will be used to prevent inconsistent writes to
     * an object.
     */
    @Version
    private Integer version = new Integer(0);

    @Override
    public boolean equals(Object o) {
        if (o instanceof OBJ) {
            final OBJ obj = (OBJ) o;
            return new EqualsBuilder().append(id, obj.id).isEquals();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).toHashCode();
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d]", this.getClass().getSimpleName(), getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @SuppressWarnings("unused")
    @PrePersist
    private void initializeVersion() {
        setVersion(new Integer(0));
    }


}
