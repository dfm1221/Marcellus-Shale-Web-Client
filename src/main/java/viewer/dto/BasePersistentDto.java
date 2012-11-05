package viewer.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Contains data that is persisted.
 * 
 * User: Justin Ford 11685
 * Date: Apr 2, 2012
 * Time: 1:26:10 PM
 */
public class BasePersistentDto {
    private Long id;

    private Integer version;

    public BasePersistentDto() {
    	
    }
    
    public BasePersistentDto(Long id) {
    	this.id = id;
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BasePersistentDto) {
			final BasePersistentDto other = (BasePersistentDto) obj;
			return new EqualsBuilder().append(id, other.getId()).isEquals();
		} else {
			return false;
		}
	}
	
	public String toString(){
		return String.valueOf("Id:" + getId());
	}
	
    
    
}
