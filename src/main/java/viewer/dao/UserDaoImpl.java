package viewer.dao;

import org.springframework.stereotype.Repository;
import viewer.dto.BasePersistentDto;
import viewer.model.User;

import java.util.Collection;

/**
 * User: Justin Ford
 * Date: 10/7/12
 * Time: 8:33 PM
 */

@Repository
public class UserDaoImpl extends JpaSingleEntityDao<User> implements UserDao {
    @Override
    public User read(Long id) {
        return null;
    }

    @Override
    public Collection<User> readAll(Collection<? extends BasePersistentDto> dtoCollection) {
        return null;
    }
}
