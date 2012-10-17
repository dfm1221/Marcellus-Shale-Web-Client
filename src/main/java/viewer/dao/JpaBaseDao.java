package viewer.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * User: Justin Ford
 * Date: 10/7/12
 * Time: 8:36 PM
 */
@Repository
@Transactional
public abstract class JpaBaseDao {

    /**
     * Entity Manager is injected by Spring with this annotation.
     */
    @PersistenceContext
    protected EntityManager entityManager;

    protected static final int DEFAULT_BATCH_SIZE = 50;
    protected static final int MAX_IN_CLAUSE_SIZE = 1000;

    protected void flushAndClearEntityManager() {
        entityManager.flush();
        entityManager.clear();
    }

    // Utility Methods
    protected Integer getCountQueryResult(Query query) {
        return ((Long) query.getSingleResult()).intValue();
    }

}
