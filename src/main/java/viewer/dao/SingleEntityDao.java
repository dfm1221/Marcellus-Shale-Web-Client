package viewer.dao;

/**
 * User: Justin Ford
 * Date: 10/7/12
 * Time: 8:30 PM
 */

import viewer.model.OBJ;

import java.util.Collection;


/**
 * An interface with convenience DAO methods that manages a single entity.
 *
 * @author 11913
 *
 * @param <T> BaseEntity
 */
public interface SingleEntityDao<T extends OBJ>  {

    public T create(T obj);

    public T read(Long id);

    public Collection<T> readAll();

    public T update(T obj);

    public void delete(T obj);

    public void delete(Long id);

}
