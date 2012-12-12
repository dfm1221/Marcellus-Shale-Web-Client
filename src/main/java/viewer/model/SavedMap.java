package viewer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Justin Ford
 * Date: 9/20/12
 * Time: 8:45 PM
 */

@Entity
public class SavedMap extends OBJ{

    @Column(unique = true, nullable = false, length = 128)
    private String name;

    @Column(unique = true, nullable = false, length = 10)
    private Integer uniqueESRIID;

    private int latitude;

    private int longitude;

    private int zoom;

    private int roll;

    private int pitch;

    private int yaw;

    @Temporal(value = TemporalType.DATE)
    private Date creationDate;

    @Temporal(value = TemporalType.DATE)
    private Date lastModifiedDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getPitch() {
        return pitch;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    public int getYaw() {
        return yaw;
    }

    public void setYaw(int yaw) {
        this.yaw = yaw;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getUniqueESRIID() {
        return uniqueESRIID;
    }

    public void setUniqueESRIID(Integer uniqueESRIID) {
        this.uniqueESRIID = uniqueESRIID;
    }
}
