package viewer.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import viewer.model.SavedMap;
import viewer.model.User;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Justin Ford
 * Date: 12/12/12
 * Time: 2:45 PM
 */
public class SavedMapDaoTest extends DaoFixture {
    @Autowired
    SavedMapDao savedMapDao;


    public SavedMap createSavedMap() {
        SavedMap savedMap = new SavedMap();
        savedMap.setName("Appalachia");
        savedMap.setUniqueESRIID(new Integer(34234324));
        savedMap.setCreationDate(new Date());
        savedMapDao.create(savedMap);
        return savedMap;

    }

    public void createSavedMaps(){
        SavedMap s1 = new SavedMap();
        s1.setName("Appalachia");
        s1.setUniqueESRIID(new Integer(34234324));
        s1.setCreationDate(new Date());
        savedMapDao.create(s1);

        SavedMap s2 = new SavedMap();
        s2.setName("Appalachia2");
        s2.setUniqueESRIID(new Integer(34234764));
        s2.setCreationDate(new Date());
        savedMapDao.create(s2);

        savedMapDao.create(s1);
        savedMapDao.create(s2);

    }

    @Test
    public void testCreateSavedMaps(){
        assertTrue(createSavedMap().getId() != null);
    }

    @Test
    public void testReadSavedMapsById(){
        assertTrue(savedMapDao.read(createSavedMap().getId()) != null);
    }

    @Test
    public void testReadAllSavedMaps(){
        createSavedMaps();
        assertEquals(savedMapDao.readAll().size(), 2);
    }



}
