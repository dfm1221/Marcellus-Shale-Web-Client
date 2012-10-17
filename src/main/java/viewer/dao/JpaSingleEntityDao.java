package viewer.dao;

import viewer.model.OBJ;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * User: Justin Ford
 * Date: 10/7/12
 * Time: 8:34 PM
 */
@Repository
@Transactional
public abstract class JpaSingleEntityDao<T extends OBJ> extends JpaBaseDao implements SingleEntityDao<T> {

    public T create(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("obj to create should not be null");
        }
        entityManager.persist(obj);
        return obj;
    }

    public T update(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("obj to update should not be null");
        }
        return entityManager.merge(obj);
    }

    public void delete(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("obj to delete should not be null");
        }
        entityManager.remove(obj);
    }

    public void delete(Long id) {
        delete(read(id));
    }

    @Transactional(readOnly = true)
    protected T read(Class<T> type, Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        return entityManager.find(type, id);
    }

    @Transactional(readOnly = true)
    protected Boolean exists(Class<T> type, Long id) {
        try {
            entityManager.getReference(type, id).getId();
            return true;
        } catch (EntityNotFoundException e) {
            return false;
        }
    }

    @Transactional(readOnly = true)
    protected T getReference(Class<T> type, Long id) {
        try {
            return entityManager.getReference(type, id);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

}