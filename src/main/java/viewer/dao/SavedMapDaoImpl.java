package viewer.dao;

import org.springframework.stereotype.Repository;
import viewer.dto.BasePersistentDto;
import viewer.model.SavedMap;

import java.util.Collection;

/**
 * User: Justin Ford
 * Date: 10/7/12
 * Time: 8:49 PM
 */

@Repository
public class SavedMapDaoImpl extends JpaSingleEntityDao<SavedMap> implements SavedMapDao {

    @Override
    public SavedMap read(Long id) {
        return null;
    }

    @Override
    public Collection<SavedMap> readAll(Collection<? extends BasePersistentDto> dtoCollection) {
        return null;
    }
}
