package viewer.dao;

import org.springframework.stereotype.Repository;
import viewer.dto.BasePersistentDto;
import viewer.model.User;
import viewer.model.User_;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    @Override
    public User readByUsernameForPasswordLogin(String username) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cquery = cb.createQuery(User.class);
        Root<User> root = cquery.from(User.class);

        Predicate isSameUsername = cb.equal(root.get(User_.userName), username);

        cquery.where(isSameUsername);

        User user = null;
        try {
            user = entityManager.createQuery(cquery).getSingleResult();
        } catch (NoResultException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
