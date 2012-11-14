package viewer.setup;

import javax.persistence.*;
import java.util.List;

/**
 * User: Justin Ford
 * Date: 11/14/12
 * Time: 6:31 PM
 */
public class JpaSchemaAdapter implements SchemaAdapter {
    private final EntityManagerFactory emf;

    public JpaSchemaAdapter(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public List executeQuery(String query) {
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();
        tx.begin();
        final Query nativeQuery = em.createNativeQuery(query);
        final List resultList = nativeQuery.getResultList();
        tx.commit();
        em.close();
        return resultList;
    }

    public Integer executeUpdate(String query) {
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();
        tx.begin();
        final Query nativeQuery = em.createNativeQuery(query);
        final int updateCount = nativeQuery.executeUpdate();
        tx.commit();
        em.close();
        return updateCount;
    }

    public void dispose() {
        emf.close();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        dispose();
    }
}
