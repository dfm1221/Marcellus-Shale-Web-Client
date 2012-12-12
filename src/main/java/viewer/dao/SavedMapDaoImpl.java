package viewer.dao;

import org.springframework.stereotype.Repository;
import viewer.model.SavedMap;

import java.util.Collection;

/**
 * User: Justin Ford
 * Date: 10/7/12
 * Time: 8:49 PM
 */

@Repository
public class SavedMapDaoImpl extends JpaSingleEntityDao<SavedMap> implements SavedMapDao {

    public SavedMap read(Long id) {
        return read(SavedMap.class, id);
    }

    public Collection<SavedMap> readAll() {
        return entityManager.createQuery("from SavedMap order by name").getResultList();
    }
}
